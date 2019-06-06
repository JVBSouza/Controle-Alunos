package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class CadastroResponsavel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setToolTipText("Nome do responsável");
		textField.setBounds(115, 33, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 63, 167, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 94, 167, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(116, 127, 166, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(116, 156, 166, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
