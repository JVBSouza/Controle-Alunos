package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.AlunoController;
import controle.AutorizacaoController;
import modelo.Aluno;
import modelo.Autorizacao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaAutorizacao extends JFrame {

	private JPanel contentPane;
	private JTextField autoriza;
	private JTextField descrAutoriza;
	private JTextField descrCancela;
	private JTextField nomeAluno;

	private Autorizacao autorizacao;
	private Aluno aluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaAutorizacao frame = new PesquisaAutorizacao();
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
	public PesquisaAutorizacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Código da autorização:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 20, 170, 20);
		contentPane.add(lblNewLabel);

		autoriza = new JTextField();
		autoriza.setBounds(190, 20, 75, 20);
		contentPane.add(autoriza);
		autoriza.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descrição da autorização:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 80, 170, 20);
		contentPane.add(lblNewLabel_1);

		descrAutoriza = new JTextField();
		descrAutoriza.setEditable(false);
		descrAutoriza.setBounds(190, 80, 190, 20);
		contentPane.add(descrAutoriza);
		descrAutoriza.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Descrição do cancelamento:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 110, 170, 20);
		contentPane.add(lblNewLabel_2);

		descrCancela = new JTextField();
		descrCancela.setBounds(190, 110, 190, 20);
		contentPane.add(descrCancela);
		descrCancela.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nome do Aluno:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 50, 170, 20);
		contentPane.add(lblNewLabel_3);

		nomeAluno = new JTextField();
		nomeAluno.setEditable(false);
		nomeAluno.setBounds(190, 50, 190, 20);
		contentPane.add(nomeAluno);
		nomeAluno.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar Autorização");
		btnCancelar.setBounds(120, 160, 180, 50);
		contentPane.add(btnCancelar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int vAutoriza;

				try {
					vAutoriza = Integer.parseInt(autoriza.getText());
				} catch (RuntimeException e) {
					final JFrame popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "Código inserido não é válido",
							"Erro na autorização", JOptionPane.ERROR_MESSAGE);
					return;
				}
				AutorizacaoController controlAuto = new AutorizacaoController();
				AlunoController controlAluno = new AlunoController();

				autorizacao = controlAuto.find(vAutoriza);
				
				if (autorizacao == null) {
					return;
				}
				
				aluno = controlAluno.find(autorizacao.getMatricula());

				nomeAluno.setText(aluno.getNome());
				descrAutoriza.setText(autorizacao.getDesc());

			}
		});
		btnProcurar.setBounds(275, 20, 105, 20);
		contentPane.add(btnProcurar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int vAutoriza = Integer.parseInt(autoriza.getText());
				String Cancela = descrCancela.getText();
				AutorizacaoController controlAuto = new AutorizacaoController();
				controlAuto.update(vAutoriza, Cancela);
			}
		});

	}
}
