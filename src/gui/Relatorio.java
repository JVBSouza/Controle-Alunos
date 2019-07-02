package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controle.RelatorioController;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Relatorio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		
		final JFrame popup = new JFrame();
		
		setTitle("Exportação dos relatórios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExportSimples = new JButton("Relatório registros alunos");
		btnExportSimples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File local = escolherArquivo();
				RelatorioController control = new RelatorioController();
				control.gravarAluno(local);
			}
		});
		btnExportSimples.setBounds(10, 70, 195, 50);
		contentPane.add(btnExportSimples);
		
		textField = new JTextField();
		textField.setBounds(100, 30, 257, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Diretório:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 30, 80, 20);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("...");
		button.setBounds(367, 30, 30, 20);
		contentPane.add(button);
		
		JButton btnIrregular = new JButton("Relatório registros Irregulares");
		btnIrregular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer matricula = Integer.valueOf(JOptionPane.showInputDialog(popup,
                        "Qual matricula deseja pesquisar?", null));
				File local = escolherArquivo();
				RelatorioController control = new RelatorioController();
				control.gravarIrregular(local, matricula);
			}
		});
		btnIrregular.setBounds(100, 190, 220, 50);
		contentPane.add(btnIrregular);
		
		JButton btnTurma = new JButton("Relatório Alunos em Turma");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer turma = Integer.valueOf(JOptionPane.showInputDialog(popup,
                        "Qual turma deseja pesquisar?", null));
				File local = escolherArquivo();
				RelatorioController control = new RelatorioController();
				control.gravarTurma(local, turma);
			}
		});
		btnTurma.setBounds(215, 70, 195, 50);
		contentPane.add(btnTurma);
		
		JButton btnRelatrioSadaMs = new JButton("Relatório registros Mês");
		btnRelatrioSadaMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer mes = Integer.valueOf(JOptionPane.showInputDialog(popup,
                        "Qual mês deseja pesquisar?", null));
				File local = escolherArquivo();
				RelatorioController control = new RelatorioController();
				control.gravarMes(local, mes);
			}
		});
		btnRelatrioSadaMs.setBounds(215, 130, 195, 50);
		contentPane.add(btnRelatrioSadaMs);
		
		JButton btnUser = new JButton("Relatório usuário");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer user = Integer.valueOf(JOptionPane.showInputDialog(popup,
                        "Qual operador deseja pesquisar?", null));
				File local = escolherArquivo();
				RelatorioController control = new RelatorioController();
				control.gravarUser(local, user);
			}
		});
		btnUser.setBounds(10, 130, 195, 50);
		contentPane.add(btnUser);
	}
	
	public static File escolherArquivo() {
		File relatorio = null;
		JFileChooser fc = new JFileChooser();
		int resp = fc.showSaveDialog(null);
		// fc.setAcceptAllFileFilterUsed(false);
		FileFilter csv = new FileNameExtensionFilter("comma separated value", "csv");
		fc.addChoosableFileFilter(csv);
		if (resp == JFileChooser.APPROVE_OPTION) {
			relatorio = fc.getSelectedFile();
		}

		return relatorio;

		// Para adicionar textbox com file em vez de fazer trocentos botões
		// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
		// getAbsolutPath

	}
}
