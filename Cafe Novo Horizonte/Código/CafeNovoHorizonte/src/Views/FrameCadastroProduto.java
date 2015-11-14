package Views;

import java.awt.Color;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import Controllers.CadastroProdutoController;

public class FrameCadastroProduto {
	
	public static final String CADASTRAR = "Cadastrar";
	public static final String LIMPAR = "Limpar";
	public static final String CANCELAR = "Cancelar";

	private JFrame frame;
	private JDialog dialog;
	private JLabel lbCodigo, lbDescricao, lbEan, lbEanUnidTrib,  lbExIpi,  lbGenero, lbNcm, 
			lbQntTrib, lbUnidCom, lbUnidTrib,  lbValorUnidCom,  lbValorUnidTrib;
	private JTextField txCodigo,  txDescricao, txEan, txEanUnidTrib, txExIpi, txGenero,
			txNcm, txQntTrib, txUnidCom, txUnidTrib, txValorUnidCom, txValorUnidTrib;
	private JButton btCadastrar, btCancelar, btLimpar;

	public FrameCadastroProduto(JFrame frame){
		this.frame = frame;
		instanciarComponentes();
		eventos();
		inicializaComponentes();
	}

	private void instanciarComponentes() {
		
		dialog = new JDialog(frame, "Cadastrar produtos");
		dialog.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		lbCodigo = new JLabel("Codigo:");
		lbDescricao = new JLabel("Descricao:");
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
		
		txCodigo = new JTextField();
		txDescricao = new JTextField();
		txEan = new JTextField();
		txEanUnidTrib = new JTextField();
		txExIpi = new JTextField();
		txGenero = new JTextField();
		txNcm = new JTextField();
		txQntTrib = new JTextField();
		txUnidCom = new JTextField();
		txUnidTrib = new JTextField();
		txValorUnidCom = new JTextField();
		txValorUnidTrib = new JTextField();
		
		btCadastrar = new JButton(CADASTRAR);
		btLimpar = new JButton(LIMPAR);
		btCancelar = new JButton(CANCELAR);
	}
	
	private void inicializaComponentes(){
		
		Container container = dialog.getContentPane();
		
		GroupLayout layout = new GroupLayout(container);
		container.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(60, 60, 60)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lbDescricao)
								.addComponent(lbCodigo)
								.addComponent(lbEan)
								.addComponent(lbUnidCom)
								.addComponent(lbUnidTrib))
						.addGap(4, 4, 4)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(txDescricao)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(txUnidCom, GroupLayout.Alignment.LEADING)
												.addComponent(txEan, GroupLayout.Alignment.LEADING)
												.addComponent(txCodigo, GroupLayout.Alignment.LEADING)
												.addComponent(txUnidTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
										.addGap(60, 60, 60)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(lbEanUnidTrib)
																.addComponent(lbGenero)
																.addComponent(lbValorUnidCom)
																.addComponent(lbQntTrib))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addComponent(txGenero)
																.addComponent(txEanUnidTrib)
																.addComponent(txValorUnidCom)
																.addComponent(txQntTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
														.addGap(60, 60, 60)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(lbValorUnidTrib)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(txValorUnidTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(lbExIpi)
																				.addComponent(lbNcm))
																		.addGap(55, 55, 55)
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																				.addComponent(txExIpi, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
																				.addComponent(txNcm)))))
												.addGroup(layout.createSequentialGroup()
														.addComponent(btCadastrar)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btLimpar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btCancelar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(60, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(60, 60, 60)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbDescricao)
								.addComponent(txDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbCodigo)
								.addComponent(txCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbNcm)
								.addComponent(txNcm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbGenero)
								.addComponent(txGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbEan)
								.addComponent(txEan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbEanUnidTrib)
								.addComponent(txEanUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbExIpi)
								.addComponent(txExIpi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbUnidCom)
								.addComponent(txUnidCom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorUnidCom)
								.addComponent(txValorUnidCom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbUnidTrib)
								.addComponent(txUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbQntTrib)
								.addComponent(txQntTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorUnidTrib)
								.addComponent(txValorUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btCadastrar)
								.addComponent(btLimpar)
								.addComponent(btCancelar))
						.addGap(60, 60, 60))
				);

		dialog.pack();
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(frame);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
	}
	
	private void eventos(){
		
		CadastroProdutoController produtoCont = new CadastroProdutoController(dialog, txCodigo, txDescricao, txEan, 
				txEanUnidTrib, txExIpi, txGenero, txNcm, txQntTrib, txUnidCom, txUnidTrib, txValorUnidCom, txValorUnidTrib);
		
		btCadastrar.addActionListener(produtoCont);
		btLimpar.addActionListener(produtoCont);
		btCancelar.addActionListener(produtoCont);
	}	
}