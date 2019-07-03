package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.RegistroController;
import modelo.Registro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastroRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField cod_op;
	private JTextField matricula;
	private final ButtonGroup buttonTipo = new ButtonGroup();
	private final ButtonGroup buttonPossuiAutorizacao = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroRegistro frame = new CadastroRegistro();
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
	public CadastroRegistro() {
		
		final JFrame popup = new JFrame();
		
		setTitle("Registros de entrada e saída");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoOperador = new JLabel("Código do operador:");
		lblCdigoDoOperador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoDoOperador.setBounds(10, 10, 125, 17);
		contentPane.add(lblCdigoDoOperador);
		
		cod_op = new JTextField();
		cod_op.setBounds(145, 10, 200, 17);
		contentPane.add(cod_op);
		cod_op.setColumns(10);
		
		JLabel lblNumeroMatricula = new JLabel("Número da matrícula:");
		lblNumeroMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroMatricula.setBounds(10, 35, 124, 17);
		contentPane.add(lblNumeroMatricula);
		
		matricula = new JTextField();
		matricula.setColumns(10);
		matricula.setBounds(145, 35, 200, 17);
		contentPane.add(matricula);
		
		JLabel lblDataAutorizacao = new JLabel("Data:");
		lblDataAutorizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataAutorizacao.setBounds(10, 60, 124, 17);
		contentPane.add(lblDataAutorizacao);
		
		JFormattedTextField data = new JFormattedTextField();
		data.setColumns(10);
		data.setBounds(145, 60, 200, 17);
		contentPane.add(data);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
		data.setText(LocalDateTime.now().format(formatter));
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(11, 85, 124, 17);
		contentPane.add(lblTipo);
		
		JRadioButton rdEntrada = new JRadioButton("Entrada");
		rdEntrada.setSelected(true);
		buttonTipo.add(rdEntrada);
		rdEntrada.setBounds(145, 85, 89, 17);
		contentPane.add(rdEntrada);
		
		JRadioButton rdSaida = new JRadioButton("Saída");
		buttonTipo.add(rdSaida);
		rdSaida.setBounds(145, 105, 135, 17);
		contentPane.add(rdSaida);
		
		JRadioButton rdNo = new JRadioButton("Não");
		rdNo.setSelected(true);
		buttonPossuiAutorizacao.add(rdNo);
		rdNo.setBounds(145, 135, 62, 17);
		contentPane.add(rdNo);
		
		JLabel lblPossuiAutorizao_1 = new JLabel("Possui autorização?");
		lblPossuiAutorizao_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPossuiAutorizao_1.setBounds(10, 135, 124, 17);
		contentPane.add(lblPossuiAutorizao_1);
		
		JRadioButton rdYes = new JRadioButton("Sim");
		buttonPossuiAutorizacao.add(rdYes);
		rdYes.setBounds(145, 155, 56, 17);
		contentPane.add(rdYes);
		
		JFormattedTextField autoriza = new JFormattedTextField();
		autoriza.setColumns(10);
		autoriza.setBounds(271, 154, 74, 17);
		contentPane.add(autoriza);
		
		JLabel lblNmeroDaAutorizao = new JLabel("Número");
		lblNmeroDaAutorizao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmeroDaAutorizao.setBounds(210, 154, 56, 17);
		contentPane.add(lblNmeroDaAutorizao);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int vUser;
				try {
					vUser = Integer.parseInt(cod_op.getText());					
				}
				catch(RuntimeException e) {
					JOptionPane.showMessageDialog(popup,
						    "O valor digitado não é válido",
						    "Erro no usuário",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int vMatricula;
				
				try {
					vMatricula = Integer.parseInt(matricula.getText());
				}
				catch(RuntimeException e) {
					JOptionPane.showMessageDialog(popup,
						    "O valor digitado não é válido",
						    "Erro na matrícula",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}				
				LocalDateTime vData = LocalDateTime.parse(data.getText(),formatter);
				String vTipo;
				int vAutoriza;
				Registro registro;
				if (rdEntrada.isSelected()) {
					vTipo = "Entrada";
				} else {
					vTipo = "Saída";
				}
				if (rdYes.isSelected()) {
					try {
						vAutoriza = Integer.parseInt(autoriza.getText());	
					}
					catch(RuntimeException e) {
						JOptionPane.showMessageDialog(popup,
							    "O valor inserido não é válido",
							    "Erro na autorização",
							    JOptionPane.ERROR_MESSAGE);
						return;
					}							
					registro = new Registro(vUser, vAutoriza,vMatricula, vData, vTipo);
				} else {
					registro = new Registro(vUser, vMatricula, vData, vTipo);
				}				
				
				RegistroController control = new RegistroController();
				control.persist(registro);
				
				
			}
		});
		btnRegistrar.setBounds(145, 203, 200, 34);
		contentPane.add(btnRegistrar);
	}
}
