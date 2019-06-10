package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class PesquisaPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField nome;
	private JTextField cpf;
	private JTextField rg;
	private JTextField telefone;
	private JTextField endereco;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private final ButtonGroup pessoa = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaPessoa frame = new PesquisaPessoa();
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
	public PesquisaPessoa() {
		setTitle("Pesquisa de pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAluno = new JRadioButton("Aluno");
		pessoa.add(rdbtnAluno);
		rdbtnAluno.setSelected(true);
		rdbtnAluno.setBounds(20, 20, 109, 25);
		contentPane.add(rdbtnAluno);
		
		JRadioButton rdbtnResponsavel = new JRadioButton("Responsável");
		pessoa.add(rdbtnResponsavel);
		rdbtnResponsavel.setBounds(20, 40, 109, 25);
		contentPane.add(rdbtnResponsavel);
		
		JLabel lblMatrculaidentificado = new JLabel("Matrícula/Identificador:");
		lblMatrculaidentificado.setBounds(130, 20, 150, 20);
		contentPane.add(lblMatrculaidentificado);
		
		textField = new JTextField();
		textField.setBounds(130, 40, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(30, 75, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(30, 95, 100, 20);
		contentPane.add(lblCpf);
		
		JLabel lblNewLabel_1 = new JLabel("RG:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(30, 115, 100, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(30, 135, 100, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 155, 120, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(30, 175, 100, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Responsável 1:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(30, 195, 100, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblReponsvel = new JLabel("Responsável 2:");
		lblReponsvel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReponsvel.setBounds(30, 215, 100, 20);
		contentPane.add(lblReponsvel);
		
		nome = new JTextField();
		nome.setBounds(140, 75, 110, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(140, 95, 110, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		rg = new JTextField();
		rg.setBounds(140, 115, 110, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(140, 135, 110, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(140, 155, 110, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 175, 110, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 195, 110, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(140, 215, 110, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(pessoa.getButtonCount());
			}
		});
		btnNewButton.setBounds(300, 20, 114, 40);
		contentPane.add(btnNewButton);
		
	}
}
