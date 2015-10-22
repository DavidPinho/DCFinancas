package com.dcfinancas.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Encomenda_produto;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Venda;
import com.dcfinancas.utils.BDUtils;

public class HistoricoVendaInfoFrame extends JFrame{

	private JPanel jContentPane = null;
	private JLabel lbl_cliente = null;
	private JLabel lbl_cliente_venda = null;
	private JLabel lbl_ValorTotal = null;
	private JLabel lbl_ValorTotal_venda = null;
	private JLabel lbl_endereco = null;
	private JLabel lbl_DataVenda_venda = null;
	private JLabel lbl_status = null;
	private JLabel lbl_status_venda = null;
	private JLabel lbl_DataPagamento = null;
	private JLabel lbl_DataPagamento_venda = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_ProdutosVenda = null;
	private static HistoricoVendaInfoFrame singleton;
	private int currentPage = 1;
	private int idVenda;
	/**
	 * This method initializes 
	 * 
	 */
	
	public static HistoricoVendaInfoFrame getInstance(int id){
		if(singleton == null)
			singleton = new HistoricoVendaInfoFrame(id);
		return singleton;
	}
	
	private HistoricoVendaInfoFrame(int idVenda) {
		super();
		initialize();
		this.idVenda = idVenda;
		atualizaTable(GerenteBD.getInstance().getPageProdutos(this.idVenda,currentPage));
		PreencheCampos(idVenda);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
		});
	}
	
	private void PreencheCampos(int idVenda){
		Venda v = GerenteBD.getInstance().getOneVenda(idVenda);
		Cliente c = GerenteBD.getInstance().getOneCliente(v.getIdcliente());
		if(c.getNome()!= null){
		 lbl_cliente_venda.setText(c.getNome());
		}else{
			lbl_cliente_venda.setText("Cliente não cadastrado");
		}
		lbl_ValorTotal_venda.setText(Double.toString(v.getValor_total()));
		lbl_DataVenda_venda.setText(new SimpleDateFormat ("dd/MM/yyyy").format(v.getData_venda()));
		if(v.getData_pagamento() == null){
		lbl_status_venda.setText("Em aberto");
		}
		else{
			lbl_status_venda.setText("Pago");
		}
		if(v.getData_pagamento() == null){
			lbl_DataPagamento_venda.setText("Em aberto");
			}
			else{
				lbl_DataPagamento_venda.setText(new SimpleDateFormat ("dd/MM/yyyy").format(v.getData_pagamento()));
			}

		
		
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setSize(new Dimension(522, 405));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Informações da venda");
        this.setContentPane(getJContentPane());
        this.setResizable(false);       
			
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = GridBagConstraints.BOTH;
			gridBagConstraints31.gridy = 6;
			gridBagConstraints31.weightx = 1.0;
			gridBagConstraints31.weighty = 1.0;
			gridBagConstraints31.gridwidth = 2;
			gridBagConstraints31.gridx = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 4;
			gridBagConstraints9.insets = new Insets(7, 7, 10, 0);
			lbl_DataPagamento_venda = new JLabel();
			lbl_DataPagamento_venda.setText("JLabel");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 4;
			gridBagConstraints8.insets = new Insets(7, 10, 10, 0);
			lbl_DataPagamento = new JLabel();
			lbl_DataPagamento.setText("Data do Pagamento:");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 3;
			gridBagConstraints7.insets = new Insets(7, 7, 10, 0);
			lbl_status_venda = new JLabel();
			lbl_status_venda.setText("JLabel");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 3;
			gridBagConstraints6.insets = new Insets(7, 10, 10, 0);
			lbl_status = new JLabel();
			lbl_status.setText("Status:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.insets = new Insets(7, 7, 10, 0);
			lbl_DataVenda_venda = new JLabel();
			lbl_DataVenda_venda.setText("JLabel");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.insets = new Insets(7, 10, 10, 0);
			lbl_endereco = new JLabel();
			lbl_endereco.setText("Data da Venda:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.insets = new Insets(7, 7, 10, 0);
			lbl_ValorTotal_venda = new JLabel();
			lbl_ValorTotal_venda.setText("JLabel");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.insets = new Insets(7, 10, 10, 0);
			lbl_ValorTotal = new JLabel();
			lbl_ValorTotal.setText("Valor Total:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.insets = new Insets(7, 7, 10, 0);
			lbl_cliente_venda = new JLabel();
			lbl_cliente_venda.setText("JLabel");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.insets = new Insets(10, 10, 10, 0);
			lbl_cliente = new JLabel();
			lbl_cliente.setText("Cliente:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_cliente, gridBagConstraints);
			jContentPane.add(lbl_cliente_venda, gridBagConstraints1);
			jContentPane.add(lbl_ValorTotal, gridBagConstraints2);
			jContentPane.add(lbl_ValorTotal_venda, gridBagConstraints3);
			jContentPane.add(lbl_endereco, gridBagConstraints4);
			jContentPane.add(lbl_DataVenda_venda, gridBagConstraints5);
			jContentPane.add(lbl_status, gridBagConstraints6);
			jContentPane.add(lbl_status_venda, gridBagConstraints7);
			jContentPane.add(lbl_DataPagamento, gridBagConstraints8);
			jContentPane.add(lbl_DataPagamento_venda, gridBagConstraints9);
			jContentPane.add(getJScrollPane(), gridBagConstraints31);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_ProdutosVenda());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_ProdutosVenda	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_ProdutosVenda() {
		if (tb_ProdutosVenda == null) {
			tb_ProdutosVenda = new JTable();
			tb_ProdutosVenda.setModel(new DefaultTableModel(new Object[19][1], new String[]{"Produto", "Quantidade"}));
			tb_ProdutosVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tb_ProdutosVenda;
	}

	public void atualizaTable(Vector<Encomenda_produto> list){
		Object[][]table=new Object[BDUtils.NUM_REG][2];
		int i=0;
		for(Encomenda_produto ep : list){
			Produto p = new Produto();
			p = GerenteBD.getInstance().getOneProduto(ep.getIdproduto());
			table[i][0]=p.getNome();
			table[i][1]=ep.getQtd();
			
			
			i++;
		}
		
		tb_ProdutosVenda.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Produto", "Quantidade"
				    }
		));
		tb_ProdutosVenda.updateUI();
				
		/*int num_produtos=GerenteBD.getInstance().getCountProdutos(currentSearch);
		int maxPage=num_produtos/BDUtils.NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentProdutos=produtos;
	}*/
	
	}	
		
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
