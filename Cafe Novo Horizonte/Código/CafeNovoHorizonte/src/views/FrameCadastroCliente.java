package views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.CadastroClienteController;

public class FrameCadastroCliente {
	
	private static final String[] IMPOSTOS = new String[]{"Simples", "- - -"};
	private static final String[] ESTADOS = new String []{"SE", "BA"};
	
	public static final String CADASTRAR = "Cadastrar";
	public static final String LIMPAR = "Limpar";
	public static final String CANCELAR = "Cancelar";
	
	private JFrame frame;
	
	private JDialog dialog;
	private JLabel lbNomeFantasia, lbEmail, lbTelefone, lbRua, lbNumero, lbBairro,
		    	   lbCidade, lbEstado, lbCep, lbCpfCnpj, lbNInscricao, lbTipoImposto;
	private JButton btCadastrar, btLimpar, btCancelar;
	private JTextField tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, 
					   tfCidade, tfCep, tfCpfCnpj, tfNInscricao;
	private JComboBox<String> cbEstado, cbTipoImposto;

	
	
	public FrameCadastroCliente(JFrame frame) {
		this.frame = frame;
		this.instanciarComponentes();
		this.inicializarComponentes();
		this.eventos();
	}	
	
	private void instanciarComponentes(){
		
		dialog = new JDialog(frame,"Cadastrar Clientes");
		lbNomeFantasia = new JLabel("Nome Fantasia:");
		lbEmail = new JLabel("E-mail:");
		lbTelefone = new JLabel("Telefone:");
		lbRua = new JLabel("Rua:");
		lbNumero = new JLabel("Nº:");
		lbBairro = new JLabel("Bairro:");
		lbCidade = new JLabel("Cidade:");
		lbEstado = new JLabel("Estado:");
		lbCep = new JLabel("CEP:");
		lbCpfCnpj = new JLabel("CPF/CNPJ:");
		lbNInscricao = new JLabel("Nº de Inscrição:");
		lbTipoImposto = new JLabel("Tipo de Imposto:");
		
		btCadastrar = new JButton(CADASTRAR);
		btLimpar = new JButton(LIMPAR);
		btCancelar = new JButton(CANCELAR);
		
		tfNomeFantasia = new JTextField();
		tfEmail = new JTextField();
		tfTelefone = new JTextField();
		tfRua = new JTextField();
		tfNumero = new JTextField();
		tfBairro = new JTextField();
		tfCidade = new JTextField();
		tfCep = new JTextField();
		tfCpfCnpj = new JTextField();
		tfNInscricao = new JTextField();
		
		cbEstado = new JComboBox<>(ESTADOS);
		cbTipoImposto = new JComboBox<>(IMPOSTOS);
	}
	
	private void inicializarComponentes(){
		
		dialog.setSize(700, 400);
		dialog.setLocationRelativeTo(frame);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.getContentPane().setLayout(null);
		
		dialog.add(lbNomeFantasia);
		dialog.add(lbEmail);
		dialog.add(lbTelefone);
		dialog.add(lbRua);
		dialog.add(lbNumero);
		dialog.add(lbBairro);
		dialog.add(lbCidade);
		dialog.add(lbEstado);
		dialog.add(lbCep);
		dialog.add(lbCpfCnpj);
		dialog.add(lbNInscricao);
		dialog.add(lbTipoImposto);
		
		dialog.add(btCadastrar);
		dialog.add(btLimpar);
		dialog.add(btCancelar);
		
		dialog.add(tfNomeFantasia);
		dialog.add(tfEmail);
		dialog.add(tfTelefone);
		dialog.add(tfRua);
		dialog.add(tfNumero);
		dialog.add(tfBairro);
		dialog.add(tfCidade);
		dialog.add(tfCep);
		dialog.add(tfCpfCnpj);
		dialog.add(tfNInscricao);
		
		cbEstado.setSelectedItem(0);
		cbTipoImposto.setSelectedItem(0);
		
		dialog.add(cbEstado);
		dialog.add(cbTipoImposto);
		
		lbNomeFantasia.setBounds(25, 20, 100, 20);
		lbEmail.setBounds(25, 70, 60, 20);
		lbRua.setBounds(25, 120, 60, 20);
		lbBairro.setBounds(25, 170, 60, 20);
		lbCep.setBounds(470, 120, 60, 20);
		lbCpfCnpj.setBounds(25, 220, 80, 20);
		lbTelefone.setBounds(410, 70, 60, 20);
		lbNumero.setBounds(350, 120, 60, 20);
		lbCidade.setBounds(260, 170, 60, 20);
		lbEstado.setBounds(535, 170, 60, 20);
		lbNInscricao.setBounds(260, 220, 100, 20);
		lbTipoImposto.setBounds(480, 220, 100, 20);
		
		btCadastrar.setBounds(180,300,100, 30);
		btLimpar.setBounds(290,300,100, 30);
		btCancelar.setBounds(400,300,100, 30);
		
		tfNomeFantasia.setBounds(115, 18, 545, 25);
		tfEmail.setBounds(115, 68, 280, 25);
		tfTelefone.setBounds(470, 68, 190, 25);
		tfRua.setBounds(115, 118, 225, 25);
		tfNumero.setBounds(370, 118, 85, 25);
		tfCep.setBounds(500, 118, 160, 25);
		tfBairro.setBounds(115, 168, 135, 25);
		tfCidade.setBounds(310, 168, 210, 25);
		cbEstado.setBounds(585, 168, 75, 25);
		tfCpfCnpj.setBounds(115, 218, 135, 25);
		tfNInscricao.setBounds(350,218,120, 25);
		cbTipoImposto.setBounds(575, 218, 85, 25);
	}
	
	private void eventos(){
		CadastroClienteController clienteCont = new CadastroClienteController(dialog, tfNomeFantasia, tfEmail, 
				tfTelefone, tfRua, tfNumero, tfBairro, tfCidade, tfCep, tfCpfCnpj, tfNInscricao, cbEstado, 
				cbTipoImposto);
		
		btCadastrar.addActionListener(clienteCont);
		btLimpar.addActionListener(clienteCont);
		btCancelar.addActionListener(clienteCont);
	}
}