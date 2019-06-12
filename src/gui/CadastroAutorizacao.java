package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CadastroAutorizacao extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField matricula;
	private JTextField textField_2;
	private JTextField nomeAluno;
	private JTextField nomeResponsavel;
	private JFormattedTextField dataAutorizacao;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNomeDoResponsvel = new JLabel("Nome do responsável:");
		lblNomeDoResponsvel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoResponsvel.setBounds(10, 85, 124, 17);
		contentPane.add(lblNomeDoResponsvel);
		
		JLabel lblDataAutorizacao = new JLabel("Data da autorização:");
		lblDataAutorizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataAutorizacao.setBounds(10, 110, 124, 17);
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
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(270, 34, 75, 19);
		contentPane.add(btnNewButton);
		
		nomeAluno = new JTextField();
		nomeAluno.setBounds(145, 60, 200, 17);
		contentPane.add(nomeAluno);
		nomeAluno.setColumns(10);
		
		nomeResponsavel = new JTextField();
		nomeResponsavel.setBounds(144, 85, 200, 17);
		contentPane.add(nomeResponsavel);
		nomeResponsavel.setColumns(10);
		
		dataAutorizacao = new JFormattedTextField();
		dataAutorizacao.setBounds(144, 110, 200, 17);
		contentPane.add(dataAutorizacao);
		dataAutorizacao.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Autorização");
		btnNewButton_1.setBounds(145, 138, 200, 34);
		contentPane.add(btnNewButton_1);
		
		MaskFormatter dataMask;
		try {
			dataMask = new MaskFormatter("##/##/####");
			dataMask.install(dataAutorizacao);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
