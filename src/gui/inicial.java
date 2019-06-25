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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inicial {

	private JFrame frmTelaInicial;
	private JFrame cadastroAluno;
	private JFrame cadastroResponsavel;
	private JFrame cadastroAutorizacao;
	private JFrame pesquisaPessoa;
	private JFrame cadastroRegistro;
	private JTextField user;
	private JTextField senha;

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
		this.cadastroRegistro = new CadastroRegistro();
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

		JButton btnCadastrarPessoa = new JButton("Cadastrar");
		btnCadastrarPessoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroResponsavel.setVisible(true);
				
			}
		});
		btnCadastrarPessoa.setBounds(135, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnCadastrarPessoa);
		
		JButton btnPesquisarPessoa = new JButton("Pesquisar");
		btnPesquisarPessoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pesquisaPessoa.setVisible(true);
			}
		});
		btnPesquisarPessoa.setBounds(260, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnPesquisarPessoa);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastroRegistro.setVisible(true);
			}
		});
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroRegistro.setVisible(true);
			}
		});
		btnRegistrar.setBounds(10, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnRegistrar);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(136, 30, 54, 20);
		frmTelaInicial.getContentPane().add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(144, 61, 46, 20);
		frmTelaInicial.getContentPane().add(lblSenha);
		
		user = new JTextField();
		user.setBounds(200, 30, 86, 20);
		frmTelaInicial.getContentPane().add(user);
		user.setColumns(10);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(200, 61, 86, 20);
		frmTelaInicial.getContentPane().add(senha);
		
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.setBounds(385, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnRelatorio);
	}
}
