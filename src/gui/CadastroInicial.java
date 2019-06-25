package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInicial frame = new CadastroInicial();
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
	public CadastroInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Novo Aluno"); //("<html>Novo <br/> Aluno</html>");
		button.setBounds(10, 110, 140, 40);
		contentPane.add(button);
		
		JButton btnNovoResponsvel = new JButton("Novo Responsável");
		btnNovoResponsvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNovoResponsvel.setBounds(172, 110, 140, 40);
		contentPane.add(btnNovoResponsvel);
		
		JButton btnNovaAutorizao = new JButton("Nova Autorização");
		btnNovaAutorizao.setBounds(335, 110, 140, 40);
		contentPane.add(btnNovaAutorizao);
	}
}
