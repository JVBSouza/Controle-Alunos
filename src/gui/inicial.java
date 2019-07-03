package gui;

import java.awt.EventQueue;
import javax.swing.JFileChooser;

import javax.swing.JFrame;

import controle.ResponsavelController;
import controle.UsuarioController;
import modelo.Usuario;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class inicial {

	private JFrame frmTelaInicial;
	private JFrame cadastroRegistro;
	private JFrame escolherCadastrar;
	private JFrame escolherPesquisa;
	private JFrame relatorio;
	private JTextField user;
	private JPasswordField senha;

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
		this.escolherCadastrar = new EscolherCadastrar(); //
		this.cadastroRegistro = new CadastroRegistro();
		this.escolherPesquisa = new EscolherPesquisa();
		this.relatorio = new Relatorio();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaInicial = new JFrame();
		frmTelaInicial.setTitle("Início");
		frmTelaInicial.setBounds(100, 100, 530, 300);
		frmTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaInicial.getContentPane().setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setEnabled(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolherCadastrar.setVisible(true); //

			}
		});
		btnCadastrar.setBounds(135, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnCadastrar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setEnabled(false);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolherPesquisa.setVisible(true);
			}
		});
		btnPesquisar.setBounds(260, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnPesquisar);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

		senha = new JPasswordField();
		senha.setColumns(10);
		senha.setBounds(200, 61, 86, 20);
		frmTelaInicial.getContentPane().add(senha);
		//
		JButton btnRelatorio = new JButton("Relatório");
		btnRelatorio.setEnabled(false);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relatorio.setVisible(true);
			}
		});
		btnRelatorio.setBounds(385, 110, 115, 40);
		frmTelaInicial.getContentPane().add(btnRelatorio);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(inicial.class.getResource("/images/final.PNG")));
		lblNewLabel.setBounds(0, 171, 514, 65);
		frmTelaInicial.getContentPane().add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFrame popup = new JFrame();
				int idUser;
				try {
					idUser = Integer.parseInt(user.getText());
				} catch (RuntimeException e) {
					JOptionPane.showMessageDialog(popup, "O valor digitado não é válido", "Erro no usuário",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				UsuarioController control = new UsuarioController();
				Usuario usuario = control.find(idUser);
				if (usuario.getSenha().equals(senha.getText())) {
					if(usuario.getSetor().equals("Operador")) {
						btnRegistrar.setEnabled(true);
						btnPesquisar.setEnabled(true);
					} else if (usuario.getSetor().equals("Secretaria")) {
						btnCadastrar.setEnabled(true);
						btnPesquisar.setEnabled(true);
						btnRelatorio.setEnabled(true);
					} else if (usuario.getSetor().equals("Administrador")) {
						btnRegistrar.setEnabled(true);
						btnCadastrar.setEnabled(true);
						btnPesquisar.setEnabled(true);
						btnRelatorio.setEnabled(true);
					} 
				} else {
					JOptionPane.showMessageDialog(popup, "Senha incorreta", "ERRO!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

		});
		btnLogin.setBounds(297, 29, 89, 52);
		frmTelaInicial.getContentPane().add(btnLogin);

	}
}
