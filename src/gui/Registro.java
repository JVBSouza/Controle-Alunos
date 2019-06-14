package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField codigoOperador;
	private JTextField numeroMatricula;
	private final ButtonGroup buttonTipo = new ButtonGroup();
	private final ButtonGroup buttonPossuiAutorizacao = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Registros de entrada e saída");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoOperador = new JLabel("Código do operador:");
		lblCdigoDoOperador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoDoOperador.setBounds(10, 10, 125, 17);
		contentPane.add(lblCdigoDoOperador);
		
		codigoOperador = new JTextField();
		codigoOperador.setBounds(145, 10, 200, 17);
		contentPane.add(codigoOperador);
		codigoOperador.setColumns(10);
		
		JLabel lblNumeroMatricula = new JLabel("Número da matrícula:");
		lblNumeroMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroMatricula.setBounds(10, 35, 124, 17);
		contentPane.add(lblNumeroMatricula);
		
		numeroMatricula = new JTextField();
		numeroMatricula.setColumns(10);
		numeroMatricula.setBounds(145, 35, 200, 17);
		contentPane.add(numeroMatricula);
		
		JLabel lblDataAutorizacao = new JLabel("Data:");
		lblDataAutorizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataAutorizacao.setBounds(10, 60, 124, 17);
		contentPane.add(lblDataAutorizacao);
		
		JFormattedTextField dataAutorizacao = new JFormattedTextField();
		dataAutorizacao.setColumns(10);
		dataAutorizacao.setBounds(145, 60, 200, 17);
		contentPane.add(dataAutorizacao);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(11, 85, 124, 17);
		contentPane.add(lblTipo);
		
		JRadioButton rdbtnEntrada = new JRadioButton("Entrada");
		rdbtnEntrada.setSelected(true);
		buttonTipo.add(rdbtnEntrada);
		rdbtnEntrada.setBounds(145, 85, 89, 17);
		contentPane.add(rdbtnEntrada);
		
		JRadioButton rdbtnSada = new JRadioButton("Saída");
		buttonTipo.add(rdbtnSada);
		rdbtnSada.setBounds(145, 105, 135, 17);
		contentPane.add(rdbtnSada);
		
		JRadioButton rdbtnNo = new JRadioButton("Não");
		rdbtnNo.setSelected(true);
		buttonPossuiAutorizacao.add(rdbtnNo);
		rdbtnNo.setBounds(145, 135, 62, 17);
		contentPane.add(rdbtnNo);
		
		JLabel lblPossuiAutorizao_1 = new JLabel("Possui autorização?");
		lblPossuiAutorizao_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPossuiAutorizao_1.setBounds(10, 135, 124, 17);
		contentPane.add(lblPossuiAutorizao_1);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		buttonPossuiAutorizacao.add(rdbtnSim);
		rdbtnSim.setBounds(145, 155, 56, 17);
		contentPane.add(rdbtnSim);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(145, 203, 200, 34);
		contentPane.add(btnRegistrar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(10);
		formattedTextField.setBounds(271, 154, 74, 17);
		contentPane.add(formattedTextField);
		
		JLabel lblNmeroDaAutorizao = new JLabel("Número");
		lblNmeroDaAutorizao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmeroDaAutorizao.setBounds(210, 154, 56, 17);
		contentPane.add(lblNmeroDaAutorizao);
	}
}
