package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.AlunoController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Pessoa;
import modelo.Responsavel;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisaPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nome;
	private JTextField cpf;
	private JTextField rg;
	private JFormattedTextField telefone;
	private JTextField dataNasc;
	private JTextField endereco;
	private JTextField resp1;
	private JTextField resp2;
	private final ButtonGroup pessoa = new ButtonGroup();
	private JTextField parentesco;
	private final ButtonGroup action = new ButtonGroup();
	private Aluno aluno;
	private Responsavel responsavel;

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
		
		id = new JTextField();
		id.setBounds(130, 40, 150, 20);
		contentPane.add(id);
		id.setColumns(10);
		
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
		nome.setEditable(false);
		nome.setBounds(140, 75, 140, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setEditable(false);
		cpf.setBounds(140, 95, 140, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		rg = new JTextField();
		rg.setEditable(false);
		rg.setBounds(140, 115, 140, 20);
		contentPane.add(rg);
		rg.setColumns(10);
		
		telefone = new JFormattedTextField();
		telefone.setEditable(false);
		telefone.setBounds(140, 135, 140, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
				
		dataNasc = new JTextField();
		dataNasc.setEditable(false);
		dataNasc.setBounds(140, 155, 140, 20);
		contentPane.add(dataNasc);
		dataNasc.setColumns(10);
		
		endereco = new JTextField();
		endereco.setEditable(false);
		endereco.setBounds(140, 175, 140, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		resp1 = new JTextField();
		resp1.setEditable(false);
		resp1.setBounds(140, 195, 140, 20);
		contentPane.add(resp1);
		resp1.setColumns(10);
		
		resp2 = new JTextField();
		resp2.setEditable(false);
		resp2.setBounds(140, 215, 140, 20);
		contentPane.add(resp2);
		resp2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Parentesco:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(30, 235, 100, 20);
		contentPane.add(lblNewLabel_6);
		
		parentesco = new JTextField();
		parentesco.setEditable(false);
		parentesco.setBounds(140, 235, 140, 20);
		contentPane.add(parentesco);
		parentesco.setColumns(10);
		
		
		JButton btnProcurar = new JButton("Procurar");
		JButton btnDeletar = new JButton("Deletar");
		JButton btnCancelar = new JButton("Cancelar");
		JButton btnEditar = new JButton("Editar");
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnAluno.isSelected()) {
					AlunoController control = new AlunoController();
					
					aluno.setNome(nome.getText());
					aluno.setCpf(cpf.getText());
					aluno.setRg(Integer.parseInt(rg.getText()));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					aluno.setDatanasc(LocalDate.parse(dataNasc.getText(), formatter));
					aluno.setEndereco(endereco.getText());
					//aluno.setResponsavel1(resp1.);
					
					control.update(Integer.parseInt(id.getText()), aluno);
				} else if (rdbtnResponsavel.isSelected()) {
					ResponsavelController control = new ResponsavelController();
					
					responsavel.setNome(nome.getText());
					responsavel.setCpf(cpf.getText());
					responsavel.setRg(Integer.parseInt(rg.getText()));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					responsavel.setDatanasc(LocalDate.parse(dataNasc.getText(), formatter));
					responsavel.setEndereco(endereco.getText());
					responsavel.setParentesco(parentesco.getText());
					
					control.update(Integer.parseInt(id.getText()), responsavel);
				}
				
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnProcurar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnEditar.setEnabled(true);
				
				nome.setEditable(false);
				cpf.setEditable(false);
				rg.setEditable(false);
				telefone.setEditable(false);
				dataNasc.setEditable(false);
				endereco.setEditable(false);
				resp1.setEditable(false);
				resp2.setEditable(false);
				parentesco.setEditable(false);
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(310, 140, 89, 20);
		contentPane.add(btnSalvar);
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnAluno.isSelected()) {			
					nome.setText(aluno.getNome());
					cpf.setText(aluno.getCpf());
					rg.setText(String.valueOf(aluno.getRg()));
					telefone.setText(aluno.getTelefone());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataNasc.setText(aluno.getDatanasc().format(formatter));
					endereco.setText(aluno.getEndereco());
//					resp1.setText(aluno.getResponsavel1());
//					resp2.setText(aluno.getResponsavel2());
					
				} else if (rdbtnResponsavel.isSelected()) {							
					nome.setText(responsavel.getNome());
					cpf.setText(responsavel.getCpf());
					rg.setText(String.valueOf(responsavel.getRg()));
					telefone.setText(responsavel.getTelefone());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataNasc.setText(responsavel.getDatanasc().format(formatter));
					endereco.setText(responsavel.getEndereco());
					parentesco.setText(responsavel.getParentesco());
				}
				btnSalvar.setEnabled(false);
				btnCancelar.setEnabled(false);
				btnProcurar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnEditar.setEnabled(true);
				
				nome.setEditable(false);
				cpf.setEditable(false);
				rg.setEditable(false);
				telefone.setEditable(false);
				dataNasc.setEditable(false);
				endereco.setEditable(false);
				resp1.setEditable(false);
				resp2.setEditable(false);
				parentesco.setEditable(false);
			
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(310, 165, 89, 20);
		contentPane.add(btnCancelar);
		
		
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
				
				btnProcurar.setEnabled(false);
				btnDeletar.setEnabled(false);
				btnEditar.setEnabled(false);
				
				nome.setEditable(true);
				cpf.setEditable(true);
				rg.setEditable(true);
				telefone.setEditable(true);
				dataNasc.setEditable(true);
				endereco.setEditable(true);
				if (rdbtnAluno.isSelected()) {
					resp1.setEditable(true);
					resp2.setEditable(true);
				} else {
					parentesco.setEditable(true);
				}
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(300, 95, 115, 40);
		contentPane.add(btnEditar);
				
		
		btnDeletar.setEnabled(false);
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[] options = {"Sim", "Não"};
				int n = JOptionPane.showOptionDialog(arg0.getComponent(),
					    "Prosseguir com o delete?",
					    "Confirmação",
					    JOptionPane.YES_NO_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,     //do not use a custom Icon
					    options,  //the titles of buttons
					    options[0]); //default button title
					
				if (n == 0) {
					if (rdbtnAluno.isSelected()) {
						AlunoController control = new AlunoController();
						control.delete(Integer.parseInt(id.getText()));
					} else if (rdbtnResponsavel.isSelected()) {
						ResponsavelController control = new ResponsavelController();
						control.delete(Integer.parseInt(id.getText()));
					}
				}
			}
		});
		btnDeletar.setBounds(300, 200, 115, 40);
		contentPane.add(btnDeletar);
		
		
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnAluno.isSelected()) {			
					int vID = Integer.parseInt(id.getText());	
					AlunoController control = new AlunoController();	
					aluno = control.find(vID);

					nome.setText(aluno.getNome());
					cpf.setText(aluno.getCpf());
					rg.setText(String.valueOf(aluno.getRg()));
					telefone.setText(aluno.getTelefone());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataNasc.setText(aluno.getDatanasc().format(formatter));
					endereco.setText(aluno.getEndereco());
//					resp1.setText(aluno.getResponsavel1());
//					resp2.setText(aluno.getResponsavel2());
					
				} else if (rdbtnResponsavel.isSelected()) {				
					int vID = Integer.parseInt(id.getText());
					ResponsavelController control = new ResponsavelController();
					responsavel = control.find(vID);
					
					nome.setText(responsavel.getNome());
					cpf.setText(responsavel.getCpf());
					rg.setText(String.valueOf(responsavel.getRg()));
					telefone.setText(responsavel.getTelefone());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataNasc.setText(responsavel.getDatanasc().format(formatter));
					endereco.setText(responsavel.getEndereco());
					parentesco.setText(responsavel.getParentesco());
				}
				btnDeletar.setEnabled(true);
				btnEditar.setEnabled(true);
			}
		});
		btnProcurar.setBounds(300, 20, 115, 40);
		contentPane.add(btnProcurar);
		
	}
	
}
