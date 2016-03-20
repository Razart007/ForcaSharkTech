package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controllers.CadastroProdutoController;
import interfaces.AbstractCadastroController;

public class FrameCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel pnlBotoes;
	private JLabel lbTitulo, lbCodigo, lbDescricao, lbQuant, lbEan, lbEanUnidTrib, lbExIpi, lbGenero, lbNcm, lbQntTrib,
			lbUnidCom, lbUnidTrib, lbValorUnidCom, lbValorUnidTrib;

	private JTextField tfCodigo, tfDescricao, tfQuant, tfEan, tfEanUnidTrib, tfExIpi, tfGenero, tfNcm, tfQntTrib,
			tfUnidCom, tfUnidTrib, tfValorUnidCom, tfValorUnidTrib;
	private JButton btCadastrar, btCancelar, btLimpar;

	public FrameCadastroProduto(String titulo) {

		pnlBotoes = new JPanel();

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

	private void configurarCompomentes() {

		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		pnlBotoes.setBackground(Color.white);
		pnlBotoes.setLayout(getLayoutPnlBotoes());

		this.setBackground(Color.white);
		this.setLayout(getLayoutPrincipal());
	}

	public GroupLayout getLayoutPrincipal() {

		GroupLayout layout = new GroupLayout(this);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(pnlBotoes, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(lbTitulo).addGap(0, 0, Short.MAX_VALUE))
						.addGroup(
								layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(
												GroupLayout.Alignment.LEADING).addComponent(lbDescricao)
										.addComponent(lbCodigo).addComponent(lbEan).addComponent(lbNcm)
										.addComponent(lbUnidTrib))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(tfNcm, GroupLayout.Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
												.addComponent(tfCodigo, GroupLayout.Alignment.LEADING)
												.addComponent(tfEan, GroupLayout.Alignment.LEADING)
												.addComponent(tfUnidTrib))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(lbQntTrib).addComponent(lbEanUnidTrib)
														.addComponent(lbQuant).addComponent(lbUnidCom))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING,
																false)
														.addComponent(tfQuant, GroupLayout.DEFAULT_SIZE, 86,
																Short.MAX_VALUE)
														.addComponent(tfEanUnidTrib).addComponent(tfUnidCom)
														.addComponent(tfQntTrib))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(lbValorUnidTrib).addComponent(lbGenero)
														.addComponent(lbExIpi).addComponent(lbValorUnidCom))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout
														.createParallelGroup(GroupLayout.Alignment.LEADING,
																false)
														.addComponent(tfGenero, GroupLayout.DEFAULT_SIZE,
																92, Short.MAX_VALUE)
														.addComponent(tfExIpi).addComponent(tfValorUnidCom)
														.addComponent(tfValorUnidTrib))
												.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(tfDescricao))))
						.addContainerGap()));
		
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lbTitulo).addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfDescricao, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbDescricao))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbQuant).addComponent(lbCodigo)
								.addComponent(tfQuant, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbGenero).addComponent(tfGenero, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfEan, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbEan, GroupLayout.PREFERRED_SIZE, 14,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfEanUnidTrib, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbEanUnidTrib)
								.addComponent(tfExIpi, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbExIpi))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfNcm, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbNcm)
								.addComponent(tfUnidCom, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbUnidCom)
								.addComponent(tfValorUnidCom, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorUnidCom))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(tfUnidTrib, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfQntTrib, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfValorUnidTrib, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbUnidTrib, GroupLayout.PREFERRED_SIZE, 14,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbQntTrib).addComponent(lbValorUnidTrib))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
						.addComponent(pnlBotoes, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		return layout;
	}

	private LayoutManager getLayoutPnlBotoes() {

		GroupLayout pnlBotoesLayout = new GroupLayout(pnlBotoes);

		pnlBotoesLayout.setHorizontalGroup(pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(pnlBotoesLayout.createSequentialGroup().addGap(200, 200, 200).addComponent(btCadastrar)
						.addGap(18, 18, 18).addComponent(btLimpar).addGap(18, 18, 18).addComponent(btCancelar)
						.addContainerGap(142, Short.MAX_VALUE)));
		pnlBotoesLayout.setVerticalGroup(pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				pnlBotoesLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnlBotoesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btCadastrar).addComponent(btLimpar).addComponent(btCancelar))
						.addContainerGap()));
		return pnlBotoesLayout;
	}

	private void configurarEventos() {

		CadastroProdutoController controller = new CadastroProdutoController(tfCodigo, tfDescricao, tfQuant, tfEan,
				tfEanUnidTrib, tfExIpi, tfGenero, tfNcm, tfQntTrib, tfUnidCom, tfUnidTrib, tfValorUnidCom,
				tfValorUnidTrib);

		btCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));
	}
}
