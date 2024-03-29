package gui;

import java.awt.EventQueue;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.AlunoController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Responsavel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField endereco;
	private JTextField resp1;
	private JFormattedTextField telefone;
	private JTextField resp2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroAluno() {
		final JFrame popup = new JFrame();
		
		setTitle("Cadastro de novo aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 10, 96, 14);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(145, 10, 200, 17);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(39, 35, 96, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		cpf = new JFormattedTextField();
		cpf.setBounds(145, 35, 200, 17);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		MaskFormatter cpfMask;
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.install(cpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(79, 60, 56, 14);
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblRg);
		
		JFormattedTextField rg = new JFormattedTextField();
		rg.setBounds(145, 60, 200, 17);
		contentPane.add(rg);
		
		MaskFormatter rgMask;
		try {
			rgMask = new MaskFormatter("#.###.###-##");
			rgMask.install(rg);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setBounds(61, 85, 74, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		telefone = new JFormattedTextField();
		telefone.setBounds(145, 85, 200, 17);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		MaskFormatter telefoneMask;
		try {
			telefoneMask = new MaskFormatter("(##) #####-####");
			telefoneMask.install(telefone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(61, 135, 74, 14);
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblEndereo);
		
		endereco = new JTextField();
		endereco.setBounds(145, 135, 200, 17);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		JLabel lblResponsavel = new JLabel("Responsavel 1:");
		lblResponsavel.setBounds(39, 160, 96, 14);
		lblResponsavel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblResponsavel);
		
		resp1 = new JTextField();
		resp1.setBounds(145, 160, 200, 17);
		contentPane.add(resp1);
		resp1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Responsável 2:");
		lblNewLabel_2.setBounds(39, 185, 96, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_2);
		
		resp2 = new JTextField();
		resp2.setBounds(145, 185, 200, 17);
		contentPane.add(resp2);
		resp2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 110, 124, 14);
		contentPane.add(lblNewLabel_3);
		
		JFormattedTextField dataNasc = new JFormattedTextField();
		dataNasc.setBounds(145, 110, 200, 17);
		contentPane.add(dataNasc);
		
		MaskFormatter dataMask;
		try {
			dataMask = new MaskFormatter("##/##/####");
			dataMask.install(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnCadastrarAluno = new JButton("Finalizar Cadastro");
		btnCadastrarAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vNome = nome.getText();
				String vCpf = cpf.getText();
				String vRg = rg.getText();
				
				
				String vTelefone = telefone.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate vDataNasc = LocalDate.parse(dataNasc.getText(), formatter);
				String vendereco = endereco.getText();
				int vresp1; 
				int vresp2; 
				try {
					vresp1 = Integer.parseInt(resp1.getText());
					vresp2 = Integer.parseInt(resp2.getText());
				}
				catch(RuntimeException e) {
					JOptionPane.showMessageDialog(popup,
							"Deve ser inserido o número do código dos responsáveis",
							"Erro no responsável",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
							
				Aluno aluno = new Aluno(vNome, vCpf, vRg, vTelefone, vDataNasc, vendereco, vresp1, vresp2);
				AlunoController control = new AlunoController();
				
				control.persist(aluno);
			}
		});
		btnCadastrarAluno.setBounds(145, 215, 200, 34);
		contentPane.add(btnCadastrarAluno);
		
	}
}
