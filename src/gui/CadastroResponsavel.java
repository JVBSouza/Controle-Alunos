package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CadastroResponsavel extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField rg;
	private JTextField telefone;
	private JTextField endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroResponsavel frame = new CadastroResponsavel();
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
	public CadastroResponsavel() {
		setTitle("Cadastro de novo responsável");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(66, 33, 44, 20);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setToolTipText("Nome do responsável");
		nome.setBounds(115, 33, 167, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(39, 66, 71, 14);
		contentPane.add(lblCpf);
		
		
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRg.setBounds(49, 97, 61, 14);
		contentPane.add(lblRg);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(40, 130, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereo.setBounds(40, 152, 71, 29);
		contentPane.add(lblEndereo);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentesco.setBounds(38, 187, 72, 20);
		contentPane.add(lblParentesco);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PAI", "MÃE", "AVÓ", "AVÔ"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(115, 187, 95, 20);
		contentPane.add(comboBox);
		
		cpf = new JFormattedTextField();
		cpf.setBounds(115, 63, 167, 20);
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
		
		rg = new JTextField();
		rg.setBounds(115, 94, 167, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		
		telefone = new JTextField();
		telefone.setBounds(116, 127, 166, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		endereco = new JTextField();
		endereco.setBounds(116, 156, 166, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar novo responsável");
		btnCadastrar.setBounds(115, 218, 191, 23);
		contentPane.add(btnCadastrar);
	}
}
