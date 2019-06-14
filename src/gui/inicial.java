package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controle.ResponsavelController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class inicial {

	private JFrame frmTelaInicial;
	private JFrame cadastroAluno;
	private JFrame cadastroResponsavel;
	private JFrame cadastroAutorizacao;
	private JFrame pesquisaPessoa;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicial window = new inicial();
					window.frmTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inicial() {
		initialize();
		this.cadastroAluno = new CadastroAluno(); //<<
		this.cadastroResponsavel = new CadastroResponsavel();
		this.cadastroAutorizacao = new CadastroAutorizacao();  //<<
		this.pesquisaPessoa = new PesquisaPessoa();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaInicial = new JFrame();
		frmTelaInicial.setTitle("Tela inicial");
		frmTelaInicial.setBounds(100, 100, 530, 300);
		frmTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaInicial.getContentPane().setLayout(null);
		
		JButton btnCadastroDeAluno = new JButton("Cadastrar novo aluno");
		btnCadastroDeAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("printei");
				cadastroAluno.setVisible(true);
			}
		});
		btnCadastroDeAluno.setBounds(10, 110, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroDeAluno);

		JButton btnCadastroDeResponsavel = new JButton("Cadastrar novo responsável");
		btnCadastroDeResponsavel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroResponsavel.setVisible(true);
				
			}
		});
		btnCadastroDeResponsavel.setBounds(10, 159, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroDeResponsavel);
		
		JButton btnCadastroAutorizacao = new JButton("Cadastrar uma autorização");
		btnCadastroAutorizacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastroAutorizacao.setVisible(true);
			}
		});
		btnCadastroAutorizacao.setBounds(10, 210, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroAutorizacao);
		
		JButton btnPesquisar = new JButton("Pesquisar um aluno ou responsável");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pesquisaPessoa.setVisible(true);
			}
		});
		btnPesquisar.setBounds(200, 110, 304, 89);
		frmTelaInicial.getContentPane().add(btnPesquisar);
		
		JButton btnRegistrar = new JButton("Registro entrada ou saída");
		btnRegistrar.setBounds(200, 210, 304, 40);
		frmTelaInicial.getContentPane().add(btnRegistrar);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(136, 30, 54, 20);
		frmTelaInicial.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(144, 61, 46, 20);
		frmTelaInicial.getContentPane().add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(200, 31, 86, 20);
		frmTelaInicial.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 61, 86, 20);
		frmTelaInicial.getContentPane().add(textField_1);
	}
}
