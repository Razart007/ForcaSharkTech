package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableColumn;

import entidades.Produto;
import interfaces.AbstractTableCrud;

public class FrameRealizarVendaVista extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final String FILTRAR = "Filtrar";

	private static final int CODIGO = 0;
	private static final int DESCRICAO = 1;
	private static final int GENERO = 2;
	private static final int VALOR = 3;
	private static final int QUANTIDADE = 4;
	private static final int SUB_TOTAL = 5;

	private static final String[] COLUNAS = new String[] { "Codigo", "Descricção", "Genero", "Valor", "Quantidade",
			"Subtotal" };
	private static final Integer[] FILTRO_COD = new Integer[] { 0, 1, 2 };
	private static final String[] FILTRO_DESC = new String[] { "Nome do produto", "Produto #1", "Produto #2" };

	private JPanel panelCampos, panelBotoes;
	private JLabel lblTitulo;
	private ArrayList<Produto> produtos;
	private TableModelVendasVista tblModelVendasVista;
	private JTable tblVendas;
	private JScrollPane scrTabela;
	private ButtonGroup rbtnGroup;
	private JRadioButton rbtnCodigo, rbtnDescricao;
	private JComboBox<Integer> cmbCodigo;
	private JComboBox<String> cmbDescricao;
	private JLabel lblCodigo, lblDescricao, lblQuant, lblValor, lblGenero;
	private JSpinner spnQuant;
	private JTextField txfCodigo, txfDescricao, txfValor, txfGenero;
	private JButton btnCancelar, btnFinalizar, btnAdicionar;

	public FrameRealizarVendaVista(String titulo) {

		this.panelCampos = new JPanel();
		this.panelBotoes = new JPanel();
		this.lblTitulo = new JLabel(titulo);
		this.rbtnGroup = new ButtonGroup();
		this.rbtnCodigo = new JRadioButton("Codigo");
		this.rbtnDescricao = new JRadioButton("Descricao");
		this.cmbCodigo = new JComboBox<Integer>(FILTRO_COD);
		this.cmbDescricao = new JComboBox<String>(FILTRO_DESC);
		this.lblCodigo = new JLabel("Codigo");
		this.lblDescricao = new JLabel("Descricao");
		this.lblQuant = new JLabel("Quantidade");
		this.lblValor = new JLabel("Valor");
		this.lblGenero = new JLabel("Genero");
		this.spnQuant = new JSpinner();
		this.txfCodigo = new JTextField();
		this.txfDescricao = new JTextField();
		this.txfValor = new JTextField();
		this.txfGenero = new JTextField();
		this.btnAdicionar = new JButton("+");
		this.btnFinalizar = new JButton("Finalizar venda");
		this.btnCancelar = new JButton("Cancelar");
		this.produtos = new ArrayList<Produto>();
		this.tblModelVendasVista = new TableModelVendasVista(COLUNAS, produtos);
		this.tblVendas = new JTable(tblModelVendasVista);
		this.scrTabela = new JScrollPane();

		iniciarComponentes();
		iniciarTabela();
		iniciarEventos();
	}

	private void iniciarComponentes() {

		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		cmbCodigo.setVisible(false);
		cmbDescricao.setVisible(false);
		txfCodigo.setEnabled(false);
		txfDescricao.setEnabled(false);
		txfValor.setEnabled(false);
		txfGenero.setEnabled(false);

		rbtnCodigo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				boolean flag = rbtnCodigo.isSelected();
				cmbCodigo.setVisible(flag);
			}
		});

		rbtnDescricao.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				boolean flag = rbtnDescricao.isSelected();
				cmbDescricao.setVisible(flag);
			}
		});

		rbtnCodigo.setSelected(false);
		rbtnDescricao.setSelected(false);
		rbtnGroup.add(rbtnCodigo);
		rbtnGroup.add(rbtnDescricao);

		scrTabela.setViewportView(tblVendas);
		panelCampos.setLayout(getLayoutCampos());
		panelCampos.setBackground(Color.WHITE);

		panelBotoes.setLayout(getLayoutBotoes());
		panelBotoes.setBackground(Color.WHITE);

		this.setBackground(Color.WHITE);
		this.setLayout(getPanelLayout());
	}

	private LayoutManager getPanelLayout() {

		GroupLayout layout = new GroupLayout(this);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(panelCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(scrTabela)
								.addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(lblTitulo).addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblTitulo).addGap(30, 30, 30)
						.addComponent(panelCampos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(scrTabela, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(panelBotoes,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		return layout;
	}

	private LayoutManager getLayoutCampos() {

		GroupLayout panelCamposLayout = new GroupLayout(panelCampos);

		panelCamposLayout.setHorizontalGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelCamposLayout.createSequentialGroup().addGroup(panelCamposLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelCamposLayout.createSequentialGroup().addComponent(rbtnCodigo)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(rbtnDescricao))
						.addGroup(panelCamposLayout.createSequentialGroup()
								.addComponent(cmbCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(cmbDescricao,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(
						panelCamposLayout.createSequentialGroup()
								.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblCodigo).addComponent(lblQuant))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(txfCodigo, GroupLayout.PREFERRED_SIZE, 70,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(spnQuant))
								.addGap(18, 18, 18)
								.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblDescricao).addComponent(lblValor))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(panelCamposLayout.createSequentialGroup()
												.addComponent(txfValor, GroupLayout.PREFERRED_SIZE, 82,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(lblGenero)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(txfGenero, GroupLayout.PREFERRED_SIZE, 89,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(btnAdicionar)
												.addGap(0, 68, Short.MAX_VALUE))
										.addComponent(txfDescricao))));
		panelCamposLayout.setVerticalGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelCamposLayout.createSequentialGroup()
						.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(rbtnCodigo).addComponent(rbtnDescricao))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(cmbCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblCodigo)
								.addComponent(txfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescricao).addComponent(txfDescricao, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(
								panelCamposLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(lblQuant)
										.addGroup(panelCamposLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(spnQuant, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblValor)
												.addComponent(txfValor, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblGenero)
												.addComponent(txfGenero, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnAdicionar)))));

		return panelCamposLayout;
	}

	private LayoutManager getLayoutBotoes() {
		GroupLayout panelBotoesLayout = new GroupLayout(panelBotoes);

		panelBotoesLayout.setHorizontalGroup(panelBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBotoesLayout.createSequentialGroup().addGap(300).addComponent(btnFinalizar)
						.addGap(18, 18, 18).addComponent(btnCancelar)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelBotoesLayout
				.setVerticalGroup(
						panelBotoesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										panelBotoesLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addGroup(panelBotoesLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(btnFinalizar).addComponent(btnCancelar))));

		return panelBotoesLayout;
	}

	private void iniciarTabela() {

		tblVendas.setAutoCreateRowSorter(true);
		tblVendas.setRowHeight(35);
		
		TableColumn colunaCod = tblVendas.getColumnModel().getColumn(CODIGO);
		TableColumn colunaDes = tblVendas.getColumnModel().getColumn(DESCRICAO);
		TableColumn colunaGen = tblVendas.getColumnModel().getColumn(GENERO);
		TableColumn colunaValUni = tblVendas.getColumnModel().getColumn(VALOR);
		TableColumn colunaQuant = tblVendas.getColumnModel().getColumn(QUANTIDADE);
		TableColumn colunaValSub = tblVendas.getColumnModel().getColumn(SUB_TOTAL);
		
		colunaCod.setPreferredWidth(15);
		colunaDes.setPreferredWidth(300);
		colunaGen.setPreferredWidth(20);
		colunaValUni.setPreferredWidth(20);
		colunaQuant.setPreferredWidth(20);
		colunaValSub.setPreferredWidth(20);

		preencherTabela();
	}

	private void preencherTabela() {

		for (int i = 1; i <= 10; i++) {

			// TODO: Alterar o método para buscar os clientes do banco e salvar
			// num ArrayList();
			Produto p = new Produto(i, i * 100, "Prduto# " + i, i, "Genero# " + i, -1, -1, -1, -1, -1, -1, -1, -1,
					i * 10);
			tblModelVendasVista.salvar(p);
		}
	}

	private void iniciarEventos() {
		// RelatorioPagamentoController controller = new
		// RelatorioPagamentoController(tblPagamento,tblModelPagamento,
		// cmbFiltro, txtNome, lblAntes, lblDepois, dateAntes, dateDepois,
		// btnFiltro);
		//
		// btnFiltro.addActionListener(controller.getActionListener(AbstractRelatorioController.FILTRAR));
		// cmbFiltro.addItemListener(controller.getItemListener(AbstractRelatorioController.FILTRAR));
	}

	private class TableModelVendasVista extends AbstractTableCrud<Produto> {

		public TableModelVendasVista(String[] colunas, ArrayList<Produto> elementos) {
			super(colunas, elementos);
		}

		private static final long serialVersionUID = 1L;

		@Override
		public Object getCampo(Produto p, int coluna) {

			switch (coluna) {
			case CODIGO:

				return p.getCodigo();

			case DESCRICAO:

				return p.getDescricao();

			case GENERO:

				return p.getGenero();

			case VALOR:

				return p.getValorUnit();

			case QUANTIDADE:

				return p.getQuant();

			case SUB_TOTAL:

				return p.getQuant() * p.getValorUnit();
			}
			return null;
		}

		@Override
		public void setCampo(Produto p, Object valor, int coluna) {

			switch (coluna) {
			case CODIGO:

				p.setCodigo((int) valor);

			case DESCRICAO:

				p.setDescricao((String) valor);

			case GENERO:

				p.setGenero((String) valor);

			case VALOR:

				p.setValorUnit((float) valor);

			case QUANTIDADE:

				p.setQuant((int) valor);
			}
		}

		@Override
		public Class<?> getColumnClass(int coluna) {
			switch (coluna) {
			case CODIGO:
				return Integer.class;

			case DESCRICAO:
				return String.class;

			case GENERO:
				return String.class;

			case VALOR:
				return Float.class;

			case QUANTIDADE:
				return Integer.class;

			case SUB_TOTAL:
				return Float.class;
			}
			return Object.class;
		}
	}

}
