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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.WindowManager;

public class FornecedoresFrame extends JFrame{
	
	private static FornecedoresFrame singleton;
	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_procurar = null;
	private JButton btn_procurar = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_fornecedores = null;
	private JButton bt_new = null;
	private JButton bt_infomacao = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private int currentPage=1;
	private Vector<Fornecedor> currentFornecedores;  
	private String currentSearch="";

	/**
	 * This method initializes 
	 * 
	 */
	public static FornecedoresFrame getInstance(){
		if(singleton==null)
			singleton=new FornecedoresFrame();
		
		return singleton;
	}
	
	private FornecedoresFrame() {
		super();
		initialize();
		atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage,txt_procurar.getText()));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(830, 350);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.setTitle("Fornecedores");
        
			
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridy = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 2;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridwidth = 4;
			gridBagConstraints11.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.weightx = 0.7;
			gridBagConstraints2.gridy = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.15;
			gridBagConstraints1.weighty = 0.0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.ipady = 6;
			gridBagConstraints.ipadx = 3;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.insets = new Insets(7, 0, 9, 0);
			gridBagConstraints.gridy = 0;
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints);
			jContentPane.add(getTxt_procurar(), gridBagConstraints1);
			jContentPane.add(getBtn_procurar(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints11);
			jContentPane.add(getBt_new(), gridBagConstraints3);
			jContentPane.add(getBt_infomacao(), gridBagConstraints4);
			jContentPane.add(getBt_next(), gridBagConstraints5);
			jContentPane.add(getBt_back(), gridBagConstraints6);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txt_procurar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_procurar() {
		if (txt_procurar == null) {
			txt_procurar = new JTextField();
				txt_procurar.addKeyListener(new java.awt.event.KeyAdapter() { 
						public void keyPressed(KeyEvent e) {    
							if(e.getKeyChar()=='\n'){
								currentPage=1;
								currentSearch=txt_procurar.getText();
								atualizaTable(GerenteBD.getInstance().getPageFornecedor(1, currentSearch));
								}
		  				}
					});
			}
			
		return txt_procurar;
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
					currentSearch=txt_procurar.getText();
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(1, currentSearch));
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
	 * This method initializes bt_new	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_new() {
		if (bt_new == null) {
			bt_new = new JButton();
			bt_new.setText("Novo");
			bt_new.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					WindowManager.open(FornecedorForm.getInstance());
				}
			});
		}
		return bt_new;
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
					int row = tb_fornecedores.getSelectedRow();
					Fornecedor fornecedor = currentFornecedores.get(row);
					if(fornecedor!=null){
						FornecedorInfoFrame f = FornecedorInfoFrame.getInstance(fornecedor.getIdfornecedor());
						WindowManager.open(f);
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
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage,currentSearch));
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
					atualizaTable(GerenteBD.getInstance().getPageFornecedor(currentPage,currentSearch));	
				}
			});
			
		}
		return bt_back;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

}  //  @jve:decl-index=0:visual-constraint="10,50"
