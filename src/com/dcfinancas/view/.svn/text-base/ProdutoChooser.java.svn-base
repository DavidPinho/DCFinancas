package com.dcfinancas.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.lang.String;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Tipo_servico;
import com.dcfinancas.utils.BDUtils;

public class ProdutoChooser extends JDialog{

	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_search = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_fornecedores = null;
	private JButton bt_search = null;
	private JButton bt_ok = null;
	private JButton bt_back = null;
	private JButton bt_next = null;
	private static ProdutoChooser singleton;
	private Frame owner;
	private static ProdutoChooser current;
	private int currentPage=1;
	private Vector<Fornecedor> currentFornecedores;
	private String currentSearch="";

	/**
	 * This method initializes 
	 * @param parent 
	 * 
	 */
	
	
	
	private ProdutoChooser(Frame owner) {
		super(owner);
		this.owner=owner;
		initialize();
		current=this;
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(601, 350);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("Selecione um Fornecedor");
		this.setContentPane(getJContentPane());
		this.atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage, currentSearch));
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.insets = new Insets(0, 0, 5, 5);
			gridBagConstraints31.gridy = 2;
			gridBagConstraints31.weightx = 0.0;
			gridBagConstraints31.gridx = 4;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.anchor = GridBagConstraints.EAST;
			gridBagConstraints21.gridx = 3;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.weightx = 0.7;
			gridBagConstraints21.insets = new Insets(0, 2, 5, 0);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 2;
			gridBagConstraints11.insets = new Insets(0, 6, 5, 0);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 0.0;
			gridBagConstraints3.insets = new Insets(5, 0, 0, 0);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridwidth = 5;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 100;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.insets = new Insets(5, 10, 0, 5);
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints);
			jContentPane.add(getTxt_search(), gridBagConstraints1);
			jContentPane.add(getJScrollPane(), gridBagConstraints2);
			jContentPane.add(getBt_search(), gridBagConstraints3);
			jContentPane.add(getBt_ok(), gridBagConstraints11);
			jContentPane.add(getBt_back(), gridBagConstraints21);
			jContentPane.add(getBt_next(), gridBagConstraints31);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txt_search	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_search() {
		if (txt_search == null) {
			txt_search = new JTextField();
				txt_search.addKeyListener(new java.awt.event.KeyAdapter() { 
						public void keyPressed(KeyEvent e) {    
							if(e.getKeyChar()=='\n'){
								currentPage=1;
								currentSearch=txt_search.getText();
								atualizaTable(GerenteBD.getInstance().getPageFornecedor(1, currentSearch));
								}
		  				}
					});
			}
			
		return txt_search;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_fornecedores());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_fornecedores	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_fornecedores() {
		if (tb_fornecedores == null) {
			tb_fornecedores = new JTable();
			tb_fornecedores.setModel(new javax.swing.table.DefaultTableModel(
			    new Object [][] {
			    	{null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			        {null, null, null, null,null},
			    },
			    new String [] {
			        "Nome", "Email", "Celular","Telefone", "Endereço"
			    }
			    
			    
			));
			
			tb_fornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tb_fornecedores;
	}


	/**
	 * This method initializes bt_search	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_search() {
		if (bt_search == null) {
			bt_search = new JButton();
			bt_search.setText("Procurar...");
			bt_search.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage=1;
					currentSearch=txt_search.getText();
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(1, currentSearch));
				}
			});
		
		}
		return bt_search;
	}


	/**
	 * This method initializes bt_o	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Selecionar");
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int row = tb_fornecedores.getSelectedRow();
					if(row>-1){
						Fornecedor f =currentFornecedores.get(row);
						
						if(owner instanceof ProdutoForm){
							ProdutoForm p=(ProdutoForm)owner;
							p.setFornecedor(f);
						}
						
						ProdutoChooser.this.dispose();
					}else{
						JOptionPane.showMessageDialog(ProdutoChooser.this,  "Selecione um fornecedor por favor!","Atenção!", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
		}
		return bt_ok;
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
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage,currentSearch));	
				}
			});
			
		}
		return bt_back;
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
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage,currentSearch));
				}
			});
			
		}
		return bt_next;
	}

	public static void open(final JFrame parent){
		
		
		ProdutoChooser chooser=new ProdutoChooser(parent);
		Dimension paneSize = chooser.getSize();
        JFrame current=parent; 
		Dimension screenSize = current.getSize();
         chooser.setLocation( current.getLocation().x+(screenSize.width - paneSize.width) / 2, current.getLocation().y+(screenSize.height - paneSize.height) / 2);
		chooser.setVisible(true);
		
			
	}
	
	public void atualizaTable(Vector<Fornecedor> fornecedores){
		Object[][]table=new Object[BDUtils.NUM_REG][5];
		int i=0;
		for(Fornecedor f:fornecedores){
			table[i][0]= f.getNome();
			table[i][1]= f.getEmail();
			table[i][2]= f.getEndereco();
			table[i][3]= f.getCelular();
			table[i][4]= f.getTelefone();
			
			
			i++;
		}
		
		tb_fornecedores.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Nome", "E-mail","Endereço","Celular","Telefone"
				    }
		));
		tb_fornecedores.updateUI();
		if(currentPage==1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);
		
		
		int num_fornecedores=GerenteBD.getInstance().getCount(currentSearch);
		int maxPage=num_fornecedores/BDUtils.NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentFornecedores=fornecedores;
	}
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
