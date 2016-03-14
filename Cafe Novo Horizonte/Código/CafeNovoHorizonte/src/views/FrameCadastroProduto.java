package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CadastroProdutoController;
import interfaces.AbstractCadastroController;

public class FrameCadastroProduto {

	private JPanel panel, panelBotoes;
	private JLabel lbTitulo, lbCodigo, lbDescricao, lbQuant, lbEan, lbEanUnidTrib, lbExIpi, 
			lbGenero, lbNcm, lbQntTrib, lbUnidCom, lbUnidTrib,  lbValorUnidCom,  lbValorUnidTrib;
	
	private JTextField tfCodigo,  tfDescricao, tfQuant, tfEan, tfEanUnidTrib, tfExIpi, tfGenero,
			tfNcm, tfQntTrib, tfUnidCom, tfUnidTrib, tfValorUnidCom, tfValorUnidTrib;
	private JButton btCadastrar, btCancelar, btLimpar;

	public FrameCadastroProduto(String titulo) {
		
		panel = new JPanel();
		panelBotoes = new JPanel();
		
		lbTitulo = new JLabel(titulo);
		lbCodigo = new JLabel("Codigo:");
		lbDescricao = new JLabel("Descricao:");
		lbQuant = new JLabel("Quantidade:");
		lbEan = new JLabel("EAN:");
		lbEanUnidTrib = new JLabel("EAN Unid. Trib.:");
		lbExIpi = new JLabel("EX IPI:");
		lbGenero = new JLabel("Genero:");
		lbNcm = new JLabel("NCM:");
		lbQntTrib = new JLabel("Quant. Trib.:");
		lbUnidCom = new JLabel("Unid. Comp.:");
		lbUnidTrib = new JLabel("Unid. Trib.:");
		lbValorUnidCom = new JLabel("Valor Unid. Com.:");
		lbValorUnidTrib = new JLabel("Valor Unid. Trb.:");
		
		tfCodigo = new JTextField();
		tfDescricao = new JTextField();
		tfQuant = new JTextField();
		tfEan = new JTextField();
		tfEanUnidTrib = new JTextField();
		tfExIpi = new JTextField();
		tfGenero = new JTextField();
		tfNcm = new JTextField();
		tfQntTrib = new JTextField();
		tfUnidCom = new JTextField();
		tfUnidTrib = new JTextField();
		tfValorUnidCom = new JTextField();
		tfValorUnidTrib = new JTextField();
		
		btCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btCancelar = new JButton(FramePrincipal.BTN_CANCELAR);
		
		configurarEventos();
		configurarCompomentes();
	}
	
	private void configurarCompomentes(){
		
		panel.setBackground(Color.white);
		panel.setLayout(getLayoutPrincipal());
		
		panelBotoes.setBackground(Color.white);
		panelBotoes.setLayout(getLayoutPnlBotoes());
		
		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	}
	
	public GroupLayout getLayoutPrincipal(){
		
		GroupLayout layout = new GroupLayout(panel);
		
		layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescricao)
                            .addComponent(lbCodigo)
                            .addComponent(lbEan)
                            .addComponent(lbUnidCom)
                            .addComponent(lbUnidTrib))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfUnidTrib, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUnidCom, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEanUnidTrib)
                                    .addComponent(lbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbValorUnidCom)
                                    .addComponent(lbQntTrib))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfQntTrib, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(tfGenero)
                                    .addComponent(tfEanUnidTrib)
                                    .addComponent(tfValorUnidCom))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNcm)
                                    .addComponent(lbExIpi)
                                    .addComponent(lbValorUnidTrib))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfValorUnidTrib, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfExIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNcm, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfDescricao)
                                .addGap(18, 18, 18)
                                .addComponent(lbQuant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescricao)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo)
                    .addComponent(lbGenero)
                    .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNcm)
                    .addComponent(tfNcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEanUnidTrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEanUnidTrib)
                    .addComponent(lbExIpi)
                    .addComponent(tfExIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUnidCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUnidCom)
                    .addComponent(tfValorUnidCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValorUnidCom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUnidTrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUnidTrib, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQntTrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQntTrib)
                    .addComponent(lbValorUnidTrib)
                    .addComponent(tfValorUnidTrib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
		
		return layout;
	}
	
	private LayoutManager getLayoutPnlBotoes(){
		
		GroupLayout pnlBotoesLayout = new GroupLayout(panelBotoes);
		
		pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btLimpar)
                .addGap(18, 18, 18)
                .addComponent(btCancelar)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btLimpar)
                    .addComponent(btCancelar))
                .addContainerGap())
        );
        return pnlBotoesLayout;
	}
	
	private void configurarEventos(){
		
		CadastroProdutoController controller = new CadastroProdutoController(tfCodigo,  
				tfDescricao, tfQuant, tfEan, tfEanUnidTrib, tfExIpi, tfGenero, tfNcm, tfQntTrib, 
				tfUnidCom, tfUnidTrib, tfValorUnidCom, tfValorUnidTrib);
		
		btCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));
	}
	
	public JPanel getPanel() {
		return panel;
	}	
}
