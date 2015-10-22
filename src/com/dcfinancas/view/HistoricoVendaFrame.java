package com.dcfinancas.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.lang.String;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ListSelectionModel;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Venda;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.WindowManager;

public class HistoricoVendaFrame extends JFrame {

	
	
	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_pesquisa = null;
	private JButton btn_procurar = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_HistoricoVenda = null;
	private JButton bt_infomacao = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private static HistoricoVendaFrame singleton;
	private int currentPage = 1;
	private Vector<Venda> currentVendas;  //  @jve:decl-index=0:
	private String currentSearch = "";  //  @jve:decl-index=0:
	private JButton btn_FechaVenda = null;
	

	/**
	 * This method initializes 
	 * 
	 */
	
	
	public static HistoricoVendaFrame getInstance(){
		if(singleton == null)
			singleton = new HistoricoVendaFrame();
		
		return singleton;
	}
	
	private HistoricoVendaFrame() {
		super();
		initialize();
		atualizaTable(GerenteBD.getInstance().getPageVendas(currentPage, txt_pesquisa.getText()));
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(830, 350);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Histórico de Vendas");
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});

			
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.anchor = GridBagConstraints.CENTER;
			gridBagConstraints12.gridy = 2;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridy = 2;
			gridBagConstraints6.gridx = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.ipadx = 0;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridwidth = 4;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 0.7;
			gridBagConstraints2.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.weightx = 0.15;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 3;
			gridBagConstraints.ipady = 6;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.insets = new Insets(7, 0, 9, 0);
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints);
			jContentPane.add(getTxt_pesquisa(), gridBagConstraints1);
			jContentPane.add(getBtn_procurar(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints11);
			jContentPane.add(getBt_infomacao(), gridBagConstraints4);
			jContentPane.add(getBt_next(), gridBagConstraints5);
			jContentPane.add(getBt_back(), gridBagConstraints6);
			jContentPane.add(getBtn_FechaVenda(), gridBagConstraints12);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txt_pesquisa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_pesquisa() {
		if (txt_pesquisa == null) {
			txt_pesquisa = new JTextField();
			txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() { 
				public void keyPressed(KeyEvent e) {    
					if(e.getKeyChar()=='\n'){
						currentPage=1;
						currentSearch=txt_pesquisa.getText();
						atualizaTable(GerenteBD.getInstance().getPageVendas(1, currentSearch));
					}
				}
			});
		}
		return txt_pesquisa;
	}

	/**
	 * This method initializes btn_procurar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_procurar() {
		if (btn_procurar == null) {
			btn_procurar = new JButton();
			btn_procurar.setText("Procurar...");
			btn_procurar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage=1;
					currentSearch=txt_pesquisa.getText();
					atualizaTable(GerenteBD.getInstance().getPageVendas(1, currentSearch));
				}
			});
		}
		return btn_procurar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_HistoricoVenda());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_HistoricoVenda	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_HistoricoVenda() {
		if (tb_HistoricoVenda == null) {
			tb_HistoricoVenda = new JTable();
			tb_HistoricoVenda.setModel(new DefaultTableModel(new Object[][] {
					{null, null, null,null}, 
					{null, null, null,null },
					{null, null, null,null}, 
					{null, null, null,null},
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null}, 
					{null, null, null,null},
					{null, null, null,null},
					{null, null, null,null},
					{null, null, null,null}},
					new String[] {"Cliente", "Valor Total", "Data da Venda","Status"}));			
			tb_HistoricoVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tb_HistoricoVenda.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				}
				
			});
		}
		return tb_HistoricoVenda;
	}

	/**
	 * This method initializes bt_infomacao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_infomacao() {
		if (bt_infomacao == null) {
			bt_infomacao = new JButton();
			bt_infomacao.setText("Informação");
			bt_infomacao.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int row = tb_HistoricoVenda.getSelectedRow();
					if(row>-1){
					  Venda v = currentVendas.get(row);
					  WindowManager.open(HistoricoVendaInfoFrame.getInstance(v.getIdvenda()));
					}
				}
			});
		}
		return bt_infomacao;
	}

	/**
	 * This method initializes bt_next	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_next() {
		if (bt_next == null) {
			bt_next = new JButton();
			bt_next.setText(">");
			bt_next.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage++;
					atualizaTable(GerenteBD.getInstance().getPageVendas(currentPage, currentSearch));
				}
			});
		}
		return bt_next;
	}

	/**
	 * This method initializes bt_back	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_back() {
		if (bt_back == null) {
			bt_back = new JButton();
			bt_back.setText("<");
			bt_back.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage--;
					atualizaTable(GerenteBD.getInstance().getPageVendas(currentPage, currentSearch));
				}
			});
		}
		return bt_back;
	}
	
	public void atualizaTable(Vector<Venda> vendas){
		Object[][]table=new Object[BDUtils.NUM_REG][4];
		int i=0;
		for(Venda v:vendas){
			Cliente c = GerenteBD.getInstance().getOneCliente(v.getIdcliente());
			if(c.getNome()!= null){
			  table[i][0]= c.getNome();
			}
			else{
				table[i][0]= "Cliente não cadastrado";
			}
				
			table[i][1]= v.getValor_total();
			table[i][2]= new SimpleDateFormat ("dd/MM/yyyy").format(v.getData_venda());
			
			if(v.getData_pagamento()!= null){
				table[i][3]= "Pago";
			}
			else{
			  table[i][3]= "Em aberto";
			}
			
			
			i++;
		}
		
		tb_HistoricoVenda.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Cliente","Valor Total","Data da Venda","Status"
				    }
		));
		tb_HistoricoVenda.updateUI();
		if(currentPage==1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);
		
		
		int num_vendas=GerenteBD.getInstance().getCountVendas(currentSearch);
		int maxPage=num_vendas/BDUtils.NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentVendas=vendas;
	}

	/**
	 * This method initializes btn_FechaVenda	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_FechaVenda() {
		if (btn_FechaVenda == null) {
			btn_FechaVenda = new JButton();
			btn_FechaVenda.setText("Fechar Venda");
			btn_FechaVenda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int row = tb_HistoricoVenda.getSelectedRow();
					if(row > -1){
						Venda v = currentVendas.get(row);
						if(v.getData_pagamento()== null){
						v.setData_pagamento(new Date(System.currentTimeMillis()));
						GerenteBD.getInstance().update(v); 
						atualizaTable(GerenteBD.getInstance().getPageVendas(currentPage, txt_pesquisa.getText()));
						}
					}
				}
			});
		}
		return btn_FechaVenda;
	}

}  //  @jve:decl-index=0:visual-constraint="14,8"
