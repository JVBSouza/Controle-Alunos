package gui;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class CadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFormattedTextField telefone;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
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
	public CadastroAluno() {
		setTitle("Cadastro de novo aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 11, 96, 14);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(145, 11, 182, 17);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(39, 42, 96, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		cpf = new JFormattedTextField();
		cpf.setBounds(145, 42, 182, 17);
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
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(79, 73, 56, 14);
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblRg);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(145, 73, 182, 17);
		contentPane.add(formattedTextField);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setBounds(61, 103, 74, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		telefone = new JFormattedTextField();
		telefone.setBounds(145, 101, 182, 18);
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
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(61, 130, 74, 14);
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblEndereo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 130, 182, 17);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblResponsavel = new JLabel("Responsavel 1:");
		lblResponsavel.setBounds(39, 161, 96, 14);
		lblResponsavel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblResponsavel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 161, 182, 17);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Responsável 2:");
		lblNewLabel_2.setBounds(39, 190, 96, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(145, 190, 182, 17);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.setBounds(117, 227, 188, 23);
		contentPane.add(btnCadastrarAluno);
		
	}
}
