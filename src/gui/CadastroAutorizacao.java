package gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.AlunoController;
import controle.AutorizacaoController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Autorizacao;
import modelo.Responsavel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroAutorizacao extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField matricula;
	private JTextField textField_2;
	private JTextField nomeAluno;
	private JTextField nomeResponsavel;
	private JTextField nomeResponsavel1;
	private JTextField nomeResponsavel2;
	private JFormattedTextField dataAutorizacao;
	private Aluno aluno;
	private Responsavel responsavel1;
	private Responsavel responsavel2;
	private JTextField descricao;
	private final ButtonGroup rdResponsavel1e2 = new ButtonGroup();

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
		final JFrame popup = new JFrame();

		setTitle("Cadastro de Autorização");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblN = new JLabel("Número da matrícula:");
		lblN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblN.setBounds(10, 35, 135, 17);
		contentPane.add(lblN);

		JLabel lblNewLabel = new JLabel("Nome do aluno:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 60, 135, 17);
		contentPane.add(lblNewLabel);

		JLabel lblNomeDoResponsvel1 = new JLabel("Nome Responsável 1:");
		lblNomeDoResponsvel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoResponsvel1.setBounds(10, 85, 135, 17);
		contentPane.add(lblNomeDoResponsvel1);

		JLabel lblNomeDoResponsvel2 = new JLabel("Nome Responsável 2:");
		lblNomeDoResponsvel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoResponsvel2.setBounds(10, 110, 135, 17);
		contentPane.add(lblNomeDoResponsvel2);

		JLabel lblDataAutorizacao = new JLabel("Data da autorização:");
		lblDataAutorizacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataAutorizacao.setBounds(10, 135, 135, 17);
		contentPane.add(lblDataAutorizacao);

		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsurio.setBounds(10, 10, 135, 17);
		contentPane.add(lblUsurio);

		usuario = new JTextField();
		usuario.setBounds(155, 10, 210, 17);
		contentPane.add(usuario);
		usuario.setColumns(10);

		matricula = new JTextField();
		matricula.setBounds(155, 35, 120, 17);
		contentPane.add(matricula);
		matricula.setColumns(10);

		nomeAluno = new JTextField();
		nomeAluno.setEditable(false);
		nomeAluno.setBounds(155, 60, 210, 17);
		contentPane.add(nomeAluno);
		nomeAluno.setColumns(10);

		nomeResponsavel1 = new JTextField();
		nomeResponsavel1.setEditable(false);
		nomeResponsavel1.setBounds(155, 85, 185, 17);
		contentPane.add(nomeResponsavel1);
		nomeResponsavel1.setColumns(10);

		nomeResponsavel2 = new JTextField();
		nomeResponsavel2.setEditable(false);
		nomeResponsavel2.setBounds(155, 110, 185, 17);
		contentPane.add(nomeResponsavel2);
		nomeResponsavel2.setColumns(10);

		dataAutorizacao = new JFormattedTextField();
		dataAutorizacao.setBounds(155, 135, 210, 17);
		contentPane.add(dataAutorizacao);
		dataAutorizacao.setColumns(10);

		MaskFormatter dataMask;
		try {
			dataMask = new MaskFormatter("##/##/####  ##:##:##");
			dataMask.install(dataAutorizacao);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JRadioButton resp1 = new JRadioButton("");
		resp1.setSelected(true);
		rdResponsavel1e2.add(resp1);
		resp1.setBounds(345, 85, 20, 17);
		contentPane.add(resp1);

		JRadioButton resp2 = new JRadioButton("");
		rdResponsavel1e2.add(resp2);
		resp2.setBounds(345, 110, 20, 17);
		contentPane.add(resp2);

		JLabel lblNewLabel_1 = new JLabel("Selecione um ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(375, 85, 80, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("responsável");
		lblNewLabel_2.setBounds(380, 110, 80, 17);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Descrição:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 160, 135, 14);
		contentPane.add(lblNewLabel_3);

		descricao = new JTextField();
		descricao.setBounds(155, 160, 210, 48);
		contentPane.add(descricao);
		descricao.setColumns(10);

		JButton btnCadastro = new JButton("Finalizar cadastro");

		JButton btnAlunoFind = new JButton("Buscar");
		btnAlunoFind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int vID;
				try {
					vID = Integer.parseInt(matricula.getText());
				} catch (RuntimeException e) {
					JOptionPane.showMessageDialog(popup, "Matrícula inválida", "Erro na matrícula",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				AlunoController controlaluno = new AlunoController();
				aluno = controlaluno.find(vID);

				if (aluno == null) {
					return;
				}

				ResponsavelController controlresp = new ResponsavelController();
				responsavel1 = controlresp.find(aluno.getResponsavel1());
				responsavel2 = controlresp.find(aluno.getResponsavel2());

				nomeAluno.setText(aluno.getNome());
				nomeResponsavel1.setText(responsavel1.getNome());
				nomeResponsavel2.setText(responsavel2.getNome());

				btnCadastro.setEnabled(true);
			}
		});
		btnAlunoFind.setBounds(280, 34, 85, 19);
		contentPane.add(btnAlunoFind);

		btnCadastro.setEnabled(false);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vUser;
				try {
					vUser = Integer.parseInt(usuario.getText());
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(popup, "Usuário inválido", "Erro na usuário",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int vMat;
				try {
					vMat = Integer.parseInt(matricula.getText());
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(popup, "Matrícula inválida", "Erro na matrícula",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int vResp;
				if (resp1.isSelected()) {
					vResp = aluno.getResponsavel1();
				} else {
					vResp = aluno.getResponsavel2();
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
				LocalDateTime data = LocalDateTime.parse(dataAutorizacao.getText(), formatter);

				String desc = descricao.getText();

				Autorizacao autorizacao = new Autorizacao(vMat, vResp, vUser, data, desc);
				AutorizacaoController controle = new AutorizacaoController();
				controle.persist(autorizacao);

			}
		});
		btnCadastro.setBounds(134, 216, 231, 34);
		contentPane.add(btnCadastro);

	}
}
