package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class EscolherCadastrar extends JFrame {

	private JPanel contentPane; //
	private JFrame cadastroAluno; //
	private JFrame cadastroResponsavel; //
	private JFrame cadastroAutorizacao; //

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolherCadastrar frame = new EscolherCadastrar();
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

	public EscolherCadastrar() {
		initialize();
		this.cadastroAluno = new CadastroAluno();
		this.cadastroResponsavel = new CadastroResponsavel();
		this.cadastroAutorizacao = new CadastroAutorizacao();
	}

	private void initialize() {
		setTitle("Cadastrar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNovoAluno = new JButton("Novo Aluno"); // ("<html>Novo <br/> Aluno</html>");
		btnNovoAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroAluno.setVisible(true); //
			}
		});
		btnNovoAluno.setBounds(10, 134, 145, 40);
		contentPane.add(btnNovoAluno);

		JButton btnNovoResponsvel = new JButton("Novo Responsável");
		btnNovoResponsvel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastroResponsavel.setVisible(true); //
			}
		});
		btnNovoResponsvel.setBounds(172, 134, 145, 40);
		contentPane.add(btnNovoResponsvel);

		JButton btnNovaAutorizao = new JButton("Nova Autorização");
		btnNovaAutorizao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cadastroAutorizacao.setVisible(true); //
			}
		});
		btnNovaAutorizao.setBounds(335, 134, 145, 40);
		contentPane.add(btnNovaAutorizao);
		
		JLabel aluno = new JLabel("");
		aluno.setHorizontalAlignment(SwingConstants.CENTER);
		aluno.setIcon(new ImageIcon(EscolherCadastrar.class.getResource("/images/aluno.png")));
		aluno.setBounds(10, 40, 145, 79);
		contentPane.add(aluno);
		
		JLabel responsavel = new JLabel("");
		responsavel.setHorizontalAlignment(SwingConstants.CENTER);
		responsavel.setIcon(new ImageIcon(EscolherCadastrar.class.getResource("/images/responsavel.png")));
		responsavel.setBounds(172, 40, 145, 79);
		contentPane.add(responsavel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(EscolherCadastrar.class.getResource("/images/autorizac.png")));
		lblNewLabel.setBounds(335, 40, 139, 79);
		contentPane.add(lblNewLabel);
		
	}
}
