package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controle.ResponsavelController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicial {

	private JFrame frame;
	private JFrame cadastroAluno;
	private JFrame cadastroResponsavel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicial window = new inicial();
					window.frame.setVisible(true);
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
		this.cadastroAluno = new cadastroAluno();
		
		ResponsavelController respcontrol = new ResponsavelController();
		
		this.cadastroResponsavel = new CadastroResponsavel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCadastroDeAluno = new JButton("Cadastro de Aluno");
		btnCadastroDeAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("printei");
				cadastroAluno.setVisible(true);
			}
		});
		btnCadastroDeAluno.setBounds(32, 34, 155, 23);
		frame.getContentPane().add(btnCadastroDeAluno);
		
		JButton btnCadastroDeResponsvel = new JButton("Cadastro de Responsável");
		btnCadastroDeResponsvel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroResponsavel.setVisible(true);
				
			}
		});
		btnCadastroDeResponsvel.setBounds(32, 88, 155, 23);
		frame.getContentPane().add(btnCadastroDeResponsvel);
	}
}
