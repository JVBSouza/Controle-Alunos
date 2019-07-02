package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class EscolherPesquisa extends JFrame {

	private JPanel contentPane;
	private JFrame pesquisaPessoa;
	private JFrame pesquisaAutoriza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherPesquisa frame = new EscolherPesquisa();
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
	public EscolherPesquisa() {
		initialize();
		this.pesquisaAutoriza = new PesquisaAutorizacao();
		this.pesquisaPessoa = new PesquisaPessoa();
	}

	public void initialize() {
		setTitle("Pesquisas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Pesquisa Autorização");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaAutoriza.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(247, 134, 140, 40);
		contentPane.add(btnNewButton);

		JButton btnPessoa = new JButton("Pequisa Pessoa");
		btnPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisaPessoa.setVisible(true);
			}
		});
		btnPessoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPessoa.setBounds(58, 134, 140, 40);
		contentPane.add(btnPessoa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EscolherPesquisa.class.getResource("/images/aluno.png")));
		lblNewLabel.setBounds(58, 53, 140, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(EscolherPesquisa.class.getResource("/images/autorizac.png")));
		lblNewLabel_1.setBounds(247, 62, 140, 71);
		contentPane.add(lblNewLabel_1);
	}
}
