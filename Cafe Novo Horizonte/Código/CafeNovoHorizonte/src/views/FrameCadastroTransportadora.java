package views;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controllers.CadastroTransportadoraController;

public class FrameCadastroTransportadora  {

	public static final String[] UF = new String []{" - ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
			"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PR", "PI", "RJ", "RN", "RO", "RS", "RR", "RS", "SP", "SE", "TO"};
	public static final String[] TIPO_DOCUMENTO = new String[]{" - ", "CPF", "CNPJ"};
	
	public static final String CADASTRAR = "Cadastrar";
	public static final String LIMPAR = "Limpar campos";
	public static final String CANCELAR = "Cancelar";
	
	private JFrame frame;
	private JDialog dialog;
	private JPanel pnlEndereco;
	private JLabel lbNome, lbTipoDocumento, lbDocumento, lbInscricaoEstadual, lbLogradouro, lbNumero,
			lbComplemento, lbBairro, lbCep, lbPais, lbUf, lbMunicipio, lbEmail, lbTelefone;
	private JTextField txNome, txDocumento, txInscricaoEstadual, txLogradouro, txNumero,
			txComplemento, txBairro, txCep, txPais, txMunicipio, txEmail, txTelefone;
	private JComboBox<String> cmbTipoDocumento, cmbUf;
	private JCheckBox chbIsentoIcms;
	private JButton btnCadastrar, btnLimpar, btnCancelar;
	

	public FrameCadastroTransportadora(JFrame frame) {
		
		this.frame = frame;

		this.instanciarComponentes();
		this.inicializarComponentes();
		this.eventos();
	}
	
	public void instanciarComponentes(){
		
		dialog = new JDialog(frame, "Cadastrar transportadora");
		
		lbNome = new JLabel("Nome/Razão social:");
		lbTipoDocumento = new JLabel("Tipo do documento:");
		lbDocumento = new JLabel("CPF/CNPJ");
		lbInscricaoEstadual = new JLabel("Inscrição Estadual:");
		lbLogradouro = new JLabel("Logradouro:");
		lbNumero = new JLabel("Numero:");
		lbComplemento = new JLabel("Complemento:");
		lbBairro = new JLabel("Bairro:");
		lbCep = new JLabel("CEP:");
		lbPais = new JLabel("Pais:");
		lbUf = new JLabel("UF:");
		lbMunicipio = new JLabel("Municipio:");
		lbEmail = new JLabel("E-mail");
		lbTelefone = new JLabel("Telefone:");
		
		txNome = new JTextField();
		txDocumento = new JTextField();
		txInscricaoEstadual = new JTextField();
		txLogradouro = new JTextField();
		txNumero = new JTextField();
		txComplemento = new JTextField();
		txBairro = new JTextField();
		txCep = new JTextField();
		txPais = new JTextField();
		txMunicipio = new JTextField();
		txEmail = new JTextField();
		txTelefone = new JTextField();
		
		cmbTipoDocumento = new JComboBox<String>(TIPO_DOCUMENTO);
		cmbUf = new JComboBox<String>(UF);
		
		chbIsentoIcms = new JCheckBox("Isento do ICMS:", false);
		
		txDocumento.setEnabled(false);
		txMunicipio.setEnabled(false);
		
		btnCadastrar = new JButton(CADASTRAR);
		btnLimpar = new JButton(LIMPAR);
		btnCancelar = new JButton(CANCELAR);
		
		pnlEndereco = new JPanel();
	}
	
	private void inicializarComponentes(){

		pnlEndereco.setLayout(panelEnderecoLayout());
		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));

        dialog.getContentPane().setLayout(dialogLayout());
        dialog.pack();		
		dialog.setLocationRelativeTo(frame);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	

	}
	
	private void eventos(){
		
		CadastroTransportadoraController controller = new CadastroTransportadoraController(dialog, txNome, txDocumento, txInscricaoEstadual, 
				txLogradouro, txNumero, txComplemento, txBairro, txCep, txPais, txMunicipio, txTelefone, cmbTipoDocumento, cmbUf, chbIsentoIcms);
		
		btnCadastrar.addActionListener(controller);
		btnLimpar.addActionListener(controller);
		btnCancelar.addActionListener(controller);
		
		cmbTipoDocumento.addItemListener(controller);
		cmbUf.addItemListener(controller);
	}
	
	private GroupLayout panelEnderecoLayout(){
		
		GroupLayout pnlEnderecoLayout = new GroupLayout(pnlEndereco);
		
		pnlEnderecoLayout.setHorizontalGroup(
	            pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(lbComplemento)
	                    .addComponent(lbBairro)
	                    .addComponent(lbPais)
	                    .addComponent(lbLogradouro)
	                    .addComponent(lbEmail))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                        .addComponent(txEmail, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(lbTelefone)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(txTelefone))
	                    .addComponent(txLogradouro, GroupLayout.Alignment.TRAILING)
	                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                        .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                                .addComponent(txPais, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
	                                .addGap(84, 84, 84)
	                                .addComponent(lbUf)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(cmbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                            .addComponent(txBairro, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
	                                .addComponent(lbCep)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txCep, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
	                            .addGroup(GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
	                                .addComponent(lbMunicipio)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txMunicipio, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                        .addComponent(txComplemento, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(lbNumero)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(txNumero)))
	                .addContainerGap())
	        );
	        pnlEnderecoLayout.setVerticalGroup(
	            pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbLogradouro)
	                    .addComponent(txLogradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbComplemento)
	                    .addComponent(txComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbNumero))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbBairro)
	                    .addComponent(txCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbCep)
	                    .addComponent(txBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(txPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbPais)
	                    .addComponent(lbUf)
	                    .addComponent(cmbUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbMunicipio))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbEmail)
	                    .addComponent(txEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbTelefone)))
	        );
		
		
		return pnlEnderecoLayout;		
	}
	
	private GroupLayout dialogLayout(){
		
		GroupLayout layout = new GroupLayout(dialog.getContentPane());
		
		layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(50, 50, 50)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(chbIsentoIcms)
	                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                            .addComponent(pnlEndereco, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                    .addComponent(lbNome)
	                                    .addComponent(lbTipoDocumento))
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                    .addComponent(txNome)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(12, 12, 12)
	                                        .addComponent(cmbTipoDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                        .addGap(41, 41, 41)
	                                        .addComponent(lbDocumento)
	                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(txDocumento, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
	                                        .addComponent(lbInscricaoEstadual)
	                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(txInscricaoEstadual, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))))
	                        .addGap(50, 50, 50))))
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(btnCadastrar)
	                .addGap(18, 18, 18)
	                .addComponent(btnLimpar)
	                .addGap(18, 18, 18)
	                .addComponent(btnCancelar)
	                .addGap(214, 214, 214))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(47, 47, 47)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbNome)
	                    .addComponent(txNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbDocumento)
	                    .addComponent(txDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbTipoDocumento)
	                    .addComponent(lbInscricaoEstadual)
	                    .addComponent(txInscricaoEstadual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(cmbTipoDocumento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(chbIsentoIcms)
	                .addGap(18, 18, 18)
	                .addComponent(pnlEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(btnLimpar)
	                    .addComponent(btnCancelar)
	                    .addComponent(btnCadastrar))
	                .addGap(50, 50, 50))
	        );
		
		return layout;
	}
}
