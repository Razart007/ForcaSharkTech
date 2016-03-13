package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CadastroTransportadoraController;
import interfaces.AbstractCadastroController;

public class FrameCadastroTransportadora  {

	public static final String[] UF = new String []{" - ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
			"MA", "MT", "MS", "MG", "PA", "PB", "PR", "PR", "PI", "RJ", "RN", "RO", "RS", "RR", "RS", "SP", "SE", "TO"};
	public static final String[] TIPO_DOCUMENTO = new String[]{" - - ", "CPF", "CNPJ"};
		
	private JPanel panel, pnlEndereco;
	
	private JLabel lbTitulo, lbNome, lbTipoDocumento, lbDocumento, lbInscricaoEstadual, lbLogradouro, 
		lbNumero, lbComplemento, lbBairro, lbCep, lbPais, lbUf, lbMunicipio, lbEmail, lbTelefone;
	
	private JTextField txNome, txDocumento, txInscricaoEstadual, txLogradouro, txEmail, txTelefone, txNumero, 
			txComplemento, txBairro, txCep, txPais,	txMunicipio;	
	private JComboBox<String> cmbTipoDocumento, cmbUf;
	private JCheckBox chbIsentoIcms;
	private JButton btnCadastrar, btnLimpar, btnCancelar;
	

	public FrameCadastroTransportadora(String titulo) {
		
		panel = new JPanel();
		pnlEndereco = new JPanel();
		
		lbTitulo = new JLabel (titulo);
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

		chbIsentoIcms = new JCheckBox("Isento do ICMS:", false);
		cmbTipoDocumento = new JComboBox<String>(TIPO_DOCUMENTO);
		cmbUf = new JComboBox<String>(UF);
		
		btnCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btnLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btnCancelar = new JButton(FramePrincipal.BTN_CANCELAR);
		
		iniciarComponentes();
		iniciarEventos();
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	private void iniciarComponentes(){

		panel.setBackground(Color.WHITE);
		panel.setLayout(gePanelLayout());
		
		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		pnlEndereco.setLayout(panelEnderecoLayout());
		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		
		txDocumento.setEnabled(false);
		txMunicipio.setEnabled(false);
	}
	
	private LayoutManager getLayoutPnlBotoes(JPanel panel){
		
		GroupLayout pnlBotoesLayout = new GroupLayout(panel);
		
		pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
        return pnlBotoesLayout;
	}
	
	private GroupLayout gePanelLayout(){
		
		JPanel pnlBotoes = new JPanel();
		pnlBotoes.setBackground(Color.WHITE);
		pnlBotoes.setLayout(getLayoutPnlBotoes(pnlBotoes));
		
		GroupLayout layout = new GroupLayout(panel);
		
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(pnlEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(lbNome)
	                            .addComponent(lbTipoDocumento))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(lbDocumento)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(lbInscricaoEstadual)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(0, 85, Short.MAX_VALUE))
	                            .addComponent(txNome)))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(chbIsentoIcms)
	                            .addComponent(lbTitulo))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(30, 30, 30)
	                .addComponent(lbTitulo)
	                .addGap(30, 30, 30)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbNome))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbDocumento)
	                    .addComponent(txDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbInscricaoEstadual)
	                    .addComponent(txInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbTipoDocumento))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(chbIsentoIcms)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
	                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
		
		return layout;
	}
	
	private GroupLayout panelEnderecoLayout(){
		
		GroupLayout pnlEnderecoLayout = new GroupLayout(pnlEndereco);
		
		pnlEnderecoLayout.setHorizontalGroup(
	            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(lbComplemento)
	                    .addComponent(lbLogradouro)
	                    .addComponent(lbBairro)
	                    .addComponent(lbPais)
	                    .addComponent(lbEmail))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                        .addComponent(txPais, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(lbUf)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(lbMunicipio)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(txMunicipio))
	                    .addComponent(txLogradouro)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEnderecoLayout.createSequentialGroup()
	                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(txEmail)
	                            .addComponent(txBairro, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(txComplemento, javax.swing.GroupLayout.Alignment.LEADING))
	                        .addGap(18, 18, 18)
	                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                                .addComponent(lbTelefone)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(lbNumero)
	                                    .addComponent(lbCep))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(txCep)
	                                    .addComponent(txNumero))))))
	                .addContainerGap())
	        );
	        pnlEnderecoLayout.setVerticalGroup(
	            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(pnlEnderecoLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbEmail)
	                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbTelefone))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbComplemento)
	                    .addComponent(txComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbNumero))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbBairro)
	                    .addComponent(txBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbCep)
	                    .addComponent(txCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(txPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbUf)
	                    .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lbMunicipio)
	                    .addComponent(txMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap())
	        );
		
		
		return pnlEnderecoLayout;		
	}
	
	private void iniciarEventos(){
		
		CadastroTransportadoraController controller = new CadastroTransportadoraController(
				txNome, txDocumento, txInscricaoEstadual, txLogradouro, txEmail, txTelefone, txNumero, 
				txComplemento, txBairro, txCep, txPais,	txMunicipio, 
				cmbTipoDocumento, cmbUf, chbIsentoIcms);
		
		btnCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btnLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btnCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));

		cmbUf.addItemListener(controller.getItemListener(CadastroTransportadoraController.UF));
		cmbTipoDocumento.addItemListener(controller.getItemListener(CadastroTransportadoraController.DOCUMENTO));
	}
}
