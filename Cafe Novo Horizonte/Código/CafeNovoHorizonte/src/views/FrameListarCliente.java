package views;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import entidades.Cliente;
import entidades.Endereco;
import interfaces.AbstractTabelCrud;

public class FrameListarCliente {

	private JFrame frame;
	private JDialog dialog;
	private JTable tblCliente;
	private ClienteTableModel cTableModel;
	
	public FrameListarCliente(JFrame frame){
		
		this.frame = frame;
		this.dialog = new JDialog(frame, "Lista de clientes", true);
		this.tblCliente = new JTable();
		this.cTableModel = new ClienteTableModel();
		
		iniciarFrame();
		iniciarTabela();
		iniciarEventos();
		preencherTabela();
		
	}
	
	private void iniciarFrame(){
		
		dialog.setSize(1000, 500);
		dialog.setLocationRelativeTo(frame);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.getContentPane().add(new JScrollPane(tblCliente), BorderLayout.CENTER);
	}
	
	private void iniciarTabela(){
		
		tblCliente.setAutoCreateRowSorter(true);  
	    tblCliente.setRowHeight(35);
		tblCliente.setModel(cTableModel);
		
		TableColumn colunaDoc = tblCliente.getColumnModel().getColumn(ClienteTableModel.DOCUMENTO);
		TableColumn colunaNome = tblCliente.getColumnModel().getColumn(ClienteTableModel.NOME);
		TableColumn colunaEnd = tblCliente.getColumnModel().getColumn(ClienteTableModel.ENDERECO);
		TableColumn colunaTel = tblCliente.getColumnModel().getColumn(ClienteTableModel.TELEFONE);
		TableColumn colunaEdit = tblCliente.getColumnModel().getColumn(ClienteTableModel.EDITAR);
		TableColumn colunaExcl = tblCliente.getColumnModel().getColumn(ClienteTableModel.EXCLUIR);
		
		colunaDoc.setPreferredWidth(50);
		colunaNome.setPreferredWidth(150);
		colunaEnd.setPreferredWidth(150);
		colunaTel.setPreferredWidth(150);
		
		colunaEdit.setMaxWidth(50);
		colunaEdit.setMinWidth(35);
		colunaEdit.setCellRenderer(new AbstractTabelCrud.IconTableRenderer());
		
		colunaExcl.setMaxWidth(50);
		colunaExcl.setMinWidth(35);
		colunaExcl.setCellRenderer(new AbstractTabelCrud.IconTableRenderer());
		
	}
	
	private void iniciarEventos(){
		tblCliente.addMouseListener(new TblClienteListener());
	}
	
	private void preencherTabela(){
	
		for (int i = 1; i <= 5; i++){
			
			//TODO: Alterar o m�todo para buscar os clientes do banco e salvar num ArrayList();
			Cliente c = new Cliente(i, "NOME #" + i, false, i * 100, "Tel #" + i, "Email #" + i, new Endereco(), i * 10, false);
			cTableModel.salvar(c);	
		}
		dialog.setVisible(true);
	}
	
	private class TblClienteListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent event) {
			
			if(event.getSource().equals(tblCliente)){
				
				int indiceColuna = tblCliente.getSelectedColumn();
				Cliente c = cTableModel.get(tblCliente.getSelectedRow());
				
				if(indiceColuna == ClienteTableModel.EDITAR ){
					
					JOptionPane.showMessageDialog(dialog, c.toString(), cTableModel.getColumnName(ClienteTableModel.EDITAR), JOptionPane.WARNING_MESSAGE);
					
				} else if(indiceColuna == ClienteTableModel.EXCLUIR){
					
					JOptionPane.showMessageDialog(dialog, c.toString(), cTableModel.getColumnName(ClienteTableModel.EXCLUIR), JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {	}

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mousePressed(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { }
		
	}
	
	private class ClienteTableModel extends AbstractTabelCrud <Cliente> {

		private static final long serialVersionUID = 1L;

		public static final int DOCUMENTO = 0;
		public static final int NOME = 1;
		public static final int ENDERECO = 2;
		public static final int TELEFONE = 3;
		public static final int EDITAR = 4;
		public static final int EXCLUIR = 5;
		
		private ArrayList<Cliente> clientes;
		private final String[] colunas = new String[]{"Documento", "Nome", "Endere�o", "Telefone", "Editar", "Excluir"};
		
		public ClienteTableModel() {
			this(new ArrayList<Cliente>());
		}
		
		public ClienteTableModel(ArrayList<Cliente> linhas) {
			this.clientes = linhas;
		}

		@Override
		public int getColumnCount() {
			return colunas.length;
		}

		@Override
		public int getRowCount() {
			return clientes.size();
		}

		@Override
		public Object getValueAt(int linha, int coluna) {
			
			Cliente c = clientes.get(linha);
			switch(coluna){
				case DOCUMENTO: {
					return c.getDocumento();
				}
				case NOME: {
					return c.getNome();
				}
				case ENDERECO: {
					return c.getEndereco();
				}
				case TELEFONE: {
					return c.getTelefone();
				}
				case EDITAR: {
					return AbstractTabelCrud.ICON_EDITAR;
				}
				case EXCLUIR: {
					return AbstractTabelCrud.ICON_EXCLUIR;
				}
				default: {
					return null;
				}
			}
		}

		@Override
		public void setValueAt(Object valor, int linha, int coluna) {
			
			Cliente c = clientes.get(linha);
			switch(coluna){
				case DOCUMENTO: {
					c.setDocumento((int) valor);
				}
				case NOME: {
					c.setNome(valor.toString());
				}
				case ENDERECO: {
					c.setEndereco((Endereco) valor);
				}
				case TELEFONE: {
					c.setTelefone(valor.toString());
				}
				default: {
					break;
				}
			}
		}

		@Override
		public Class<?> getColumnClass(int coluna) {
			
			Cliente c = new Cliente();
			switch(coluna){
				case DOCUMENTO: {
					return c.getDocumento().getClass();
				}
				case NOME: {
					return c.getNome().getClass();
				}
				case ENDERECO: {
					return c.getEndereco().getClass();
				}
				case TELEFONE: {
					return c.getTelefone().getClass();
				}
				case EDITAR: {
					return AbstractTabelCrud.ICON_EDITAR.getClass();
				}
				case EXCLUIR: {
					return AbstractTabelCrud.ICON_EXCLUIR.getClass();
				}
				default: {
					return null;
				}
			}
		}

		@Override
		public String getColumnName(int coluna) {
			return this.colunas[coluna];
		}

		@Override
		public boolean isCellEditable(int linha, int coluna) {
			return (coluna == EDITAR || coluna == EXCLUIR) ? true : false;
		}
		
		@Override
		public Cliente get(int linha){
			return clientes.get(linha);
		}

		@Override
		public void salvar(Cliente e) {
			
			clientes.add(e);
			int indiceLinha = clientes.size() -1;
			fireTableRowsInserted(indiceLinha, indiceLinha);
		}

		@Override
		public void salvar(ArrayList<Cliente> e) {
			clientes.addAll(e);
			int ultimoRegistro = getRowCount();
			fireTableRowsInserted(ultimoRegistro, getRowCount() - 1);
		}

		@Override
		public Cliente alterar(int linha, Cliente e) {
			
			clientes.set(linha, e);
			fireTableRowsUpdated(linha, linha);
			return e;
		}
		
		
		@Override
		public Cliente excluir(int indice) {
			Cliente c = clientes.remove(indice);
			fireTableRowsDeleted(indice, indice);
			return c;
		}		
	}
}
