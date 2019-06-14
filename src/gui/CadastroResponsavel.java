package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.AlunoController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Responsavel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroResponsavel extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField rg;
	private JFormattedTextField telefone;
	private JTextField endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroResponsavel frame = new CadastroResponsavel();
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
	public CadastroResponsavel() {
		setTitle("Cadastro de novo responsável");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha somente a janela solicitada (oposto de EXIT_ON_CLOSE)
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(39, 10, 96, 17);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setToolTipText("Nome do responsável");
		nome.setBounds(145, 10, 180, 17);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(39, 35, 96, 17);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setBounds(39, 60, 96, 17);
		contentPane.add(lblRg);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(39, 85, 96, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setBounds(39, 135, 96, 17);
		contentPane.add(lblEndereo);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentesco.setBounds(39, 160, 96, 17);
		contentPane.add(lblParentesco);
		
		JComboBox parentesco = new JComboBox();
		parentesco.setModel(new DefaultComboBoxModel(new String[] {"Pai", "Mãe", "Avó", "Avô"}));
		parentesco.setMaximumRowCount(4);
		parentesco.setBounds(145, 160, 180, 17);
		contentPane.add(parentesco);
		
		cpf = new JFormattedTextField();
		cpf.setBounds(145, 35, 180, 17);
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
		
		rg = new JTextField();
		rg.setBounds(145, 60, 180, 17);
		contentPane.add(rg);
		rg.setColumns(10);
		
		telefone = new JFormattedTextField();
		telefone.setBounds(145, 85, 180, 17);
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
		
		endereco = new JTextField();
		endereco.setBounds(145, 135, 180, 17);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 110, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		JFormattedTextField dataNasc = new JFormattedTextField();
		dataNasc.setBounds(145, 110, 180, 17);
		contentPane.add(dataNasc);
		
		MaskFormatter dataMask;
		try {
			dataMask = new MaskFormatter("##/##/####");
			dataMask.install(dataNasc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnCadastrar = new JButton("Cadastrar novo responsável");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String vNome = nome.getText();
				String vCpf = cpf.getText();
				String vRg = rg.getText();
				String vTelefone = telefone.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate vDataNasc = LocalDate.parse(dataNasc.getText(), formatter);
				String vendereco = endereco.getText();
				String vparentesco = (String) parentesco.getSelectedItem();
												
				Responsavel responsavel = new Responsavel(vNome, vCpf, vRg, vTelefone, vDataNasc, vendereco, vparentesco);
				ResponsavelController control = new ResponsavelController();
//				
				control.persist(responsavel);
			}
		});
		btnCadastrar.setBounds(145, 190, 180, 34);
		contentPane.add(btnCadastrar);
		
	}
}
