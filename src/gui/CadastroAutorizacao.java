package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.AlunoController;
import controle.AutorizacaoController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Autorizacao;
import modelo.Responsavel;

public class CadastroAutorizacao extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField matricula;
	private JTextField textField_2;
	private JTextField nomeAluno;
	private JTextField nomeResponsavel;
	private JTextField nomeResponsavel1;
	private JTextField nomeResponsavel2;
	private JFormattedTextField dataAutorizacao;
	private Aluno aluno;
	private Responsavel responsavel1;
	private Responsavel responsavel2;
	private JTextField descricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAutorizacao frame = new CadastroAutorizacao();
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
	public CadastroAutorizacao() {
		setTitle("Cadastro de Autorização");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblN = new JLabel("Número da matrícula:");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(10, 35, 124, 17);
		contentPane.add(lblN);
		
		JLabel lblNewLabel = new JLabel("Nome do aluno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 60, 124, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDoResponsvel1 = new JLabel("Nome do responsável 1:");
		lblNomeDoResponsvel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoResponsvel1.setBounds(10, 85, 124, 17);
		contentPane.add(lblNomeDoResponsvel1);
		
		JLabel lblNomeDoResponsvel2 = new JLabel("Nome do responsável 2:");
		lblNomeDoResponsvel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoResponsvel2.setBounds(10, 110, 124, 17);
		contentPane.add(lblNomeDoResponsvel2);
		
		JLabel lblDataAutorizacao = new JLabel("Data da autorização:");
		lblDataAutorizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataAutorizacao.setBounds(10, 135, 124, 17);
		contentPane.add(lblDataAutorizacao);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(10, 10, 124, 17);
		contentPane.add(lblUsurio);
		
		
		usuario = new JTextField();
		usuario.setBounds(145, 10, 200, 17);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		matricula = new JTextField();
		matricula.setBounds(145, 35, 120, 17);
		contentPane.add(matricula);
		matricula.setColumns(10);

		nomeAluno = new JTextField();
		nomeAluno.setBounds(145, 60, 200, 17);
		contentPane.add(nomeAluno);
		nomeAluno.setColumns(10);
		
		nomeResponsavel1 = new JTextField();
		nomeResponsavel1.setBounds(144, 85, 200, 17);
		contentPane.add(nomeResponsavel1);
		nomeResponsavel1.setColumns(10);
		
		nomeResponsavel2 = new JTextField();
		nomeResponsavel2.setBounds(144, 110, 200, 17);
		contentPane.add(nomeResponsavel2);
		nomeResponsavel2.setColumns(10);
		
		dataAutorizacao = new JFormattedTextField();
		dataAutorizacao.setBounds(144, 135, 200, 17);
		contentPane.add(dataAutorizacao);
		dataAutorizacao.setColumns(10);
				
		MaskFormatter dataMask;
		try {
			dataMask = new MaskFormatter("##/##/####  ##:##:##");
			dataMask.install(dataAutorizacao);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JRadioButton resp1 = new JRadioButton("");
		resp1.setBounds(350, 85, 20, 17);
		contentPane.add(resp1);
		
		JRadioButton resp2 = new JRadioButton("");
		resp2.setBounds(350, 110, 20, 17);
		contentPane.add(resp2);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione um ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(375, 85, 99, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("responsável");
		lblNewLabel_2.setBounds(375, 110, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(35, 160, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		descricao = new JTextField();
		descricao.setBounds(145, 160, 200, 48);
		contentPane.add(descricao);
		descricao.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int vID = Integer.parseInt(matricula.getText());	
				AlunoController controlaluno = new AlunoController();	
				aluno = controlaluno.find(vID);

				ResponsavelController controlresp = new ResponsavelController();
				responsavel1 = controlresp.find(aluno.getResponsavel1());
				responsavel2 = controlresp.find(aluno.getResponsavel2());
				
				nomeAluno.setText(aluno.getNome());
				nomeResponsavel1.setText(responsavel1.getNome());
				nomeResponsavel2.setText(responsavel2.getNome());
				
			}
		});
		btnNewButton.setBounds(270, 34, 75, 19);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Autorização");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int vUser = Integer.parseInt(usuario.getText());
				int vMat = Integer.parseInt(matricula.getText());
				int vResp;
				if (resp1.isSelected()) {
					vResp = aluno.getResponsavel1();
				} else {
					vResp = aluno.getResponsavel2();
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
				LocalDateTime data = LocalDateTime.parse(dataAutorizacao.getText(), formatter);
				
				String desc= descricao.getText();
				
				Autorizacao autorizacao = new Autorizacao(vMat, vResp, vUser, data, desc);
				AutorizacaoController controle = new AutorizacaoController();
				controle.persist(autorizacao);
				
			}
		});
		btnNewButton_1.setBounds(145, 216, 200, 34);
		contentPane.add(btnNewButton_1);
		
		
	}
}
