package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controllers.CadastroClienteController;
import interfaces.AbstractCadastroController;

public class FrameCadastroCliente extends JPanel {
	
	//Gambiarra do java para extender quqlquer coisa da biblioteca swing
	private static final long serialVersionUID = 1L;
	
	//Tipos de impostos e estados definidos como final para utilizar nos JComboBox do frame
	private static final String[] IMPOSTOS = new String[]{"Simples", "- - -"};
	private static final String[] ESTADOS = new String []{"SE", "BA"};

	//JPanel dos botões logo abaixo da tela
	private JPanel panelBotoes;	
	
	private JLabel lbTitulo, lbNomeFantasia, lbEmail, lbTelefone, lbRua, lbNumero,
				lbBairro,lbCidade, lbEstado, lbCep, lbCpfCnpj, lbNInscricao, lbTipoImposto;
	private JButton btCadastrar, btLimpar, btCancelar;
	private JTextField tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, 
					   tfCidade, tfCep, tfCpfCnpj, tfNInscricao;
	private JComboBox<String> cbEstado, cbTipoImposto;

	//Construtor da classe
	public FrameCadastroCliente(String titulo) {
		//Inicialização dos componentes
		panelBotoes = new JPanel();
		lbTitulo = new JLabel(titulo);
		
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
		
		btCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btCancelar = new JButton(FramePrincipal.BTN_CANCELAR);
		
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
		
		configurarComponentes();
		configurarEventos();
	}
	
	//Método de configuração dos componentes
	private void configurarComponentes(){
		
		this.setLayout(getLayoutPanel());
		this.setBackground(Color.WHITE);
		
		panelBotoes.setLayout(getLayoutPnlBotoes());
		panelBotoes.setBackground(Color.WHITE);
		
		cbEstado.setSelectedItem(0);
		cbTipoImposto.setSelectedItem(0);
		
		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	}
	
	//criação do layout manager de todo o frameCadastroCliente
	private LayoutManager getLayoutPanel(){
		
		GroupLayout layout = new GroupLayout(this);
		
		layout.setHorizontalGroup(
	        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addContainerGap()
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(lbRua)
	                        .addComponent(lbEstado)
	                        .addComponent(lbCpfCnpj))
	                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbCidade)
	                            .addGap(18, 18, 18)
	                            .addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbBairro)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(tfBairro))
	                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                            .addComponent(tfRua)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbNumero)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbCep)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(tfCep, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbNInscricao)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(tfNInscricao, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbTipoImposto)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(cbTipoImposto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addGap(0, 0, Short.MAX_VALUE))
	                        .addGroup(layout.createSequentialGroup()
	                            .addComponent(tfEmail)
	                            .addGap(18, 18, 18)
	                            .addComponent(lbTelefone)
	                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))))
	                .addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout.createSequentialGroup()
	                    .addComponent(lbTitulo)
	                    .addGap(0, 0, Short.MAX_VALUE))
	                .addGroup(layout.createSequentialGroup()
	                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                        .addComponent(lbEmail)
	                        .addComponent(lbNomeFantasia))
	                    .addGap(22, 22, 22)
	                    .addComponent(tfNomeFantasia)))
	            .addContainerGap())
	    );
	    layout.setVerticalGroup(
	        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addGap(30, 30, 30)
	            .addComponent(lbTitulo)
	            .addGap(30, 30, 30)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lbNomeFantasia)
	                .addComponent(tfNomeFantasia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lbEmail)
	                .addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbTelefone)
	                .addComponent(tfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(lbRua)
	                .addComponent(tfRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbNumero)
	                .addComponent(tfNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbCep)
	                .addComponent(tfCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(cbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbEstado)
	                .addComponent(lbCidade)
	                .addComponent(tfCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbBairro)
	                .addComponent(tfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(tfCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbCpfCnpj)
	                .addComponent(lbNInscricao)
	                .addComponent(tfNInscricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addComponent(lbTipoImposto)
	                .addComponent(cbTipoImposto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
	            .addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap())
	    );
		
		return layout;
	}

	//criação do layout manager de jpanel de botões
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
	
	//Método que cria a classe controller vinculada ao frame e adiciona as ações dos botões com este controller
	private void configurarEventos(){
		
		CadastroClienteController controller = new CadastroClienteController(tfNomeFantasia, tfEmail, tfTelefone, 
				tfRua, tfNumero, tfBairro, tfCidade, tfCep, tfCpfCnpj, tfNInscricao, 
				cbEstado, cbTipoImposto );
		
		btCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));
	}
	
}
