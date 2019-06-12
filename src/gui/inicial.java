package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controle.ResponsavelController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicial {

	private JFrame frmTelaInicial;
	private JFrame cadastroAluno;
	private JFrame cadastroResponsavel;
	private JFrame cadastroAutorizacao;

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
		this.cadastroAluno = new CadastroAluno();
		
		ResponsavelController respcontrol = new ResponsavelController();
		
		this.cadastroResponsavel = new CadastroResponsavel();
		this.cadastroAutorizacao = new CadastroAutorizacao();
		
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
		btnCadastroDeAluno.setBounds(10, 11, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroDeAluno);

		JButton btnCadastroDeResponsavel = new JButton("Cadastrar novo responsável");
		btnCadastroDeResponsavel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroResponsavel.setVisible(true);
				
			}
		});
		btnCadastroDeResponsavel.setBounds(10, 60, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroDeResponsavel);
		
		JButton btnCadastroAutorizacao = new JButton("Cadastrar uma autorização");
		btnCadastroAutorizacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastroAutorizacao.setVisible(true);
			}
		});
		btnCadastroAutorizacao.setBounds(200, 11, 180, 40);
		frmTelaInicial.getContentPane().add(btnCadastroAutorizacao);
	}
}
