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

public class CadastroResponsavel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(39, 31, 44, 24);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setToolTipText("Nome do responsável");
		textField.setBounds(93, 33, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(39, 66, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(39, 97, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblNewLabel = new JLabel("Telefone:");
		lblNewLabel.setBounds(39, 122, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(39, 144, 54, 29);
		contentPane.add(lblEndereo);
		
		JLabel lblParentesco = new JLabel("Parentesco:");
		lblParentesco.setBounds(38, 171, 64, 20);
		contentPane.add(lblParentesco);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PAI", "MÃE", "AVÓ", "AVÔ"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(103, 171, 76, 20);
		contentPane.add(comboBox);
	}
}
