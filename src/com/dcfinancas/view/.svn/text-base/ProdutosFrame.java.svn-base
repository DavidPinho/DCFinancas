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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ListSelectionModel;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.WindowManager;

public class ProdutosFrame extends JFrame {

	private static ProdutosFrame singleton;
	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_pesquisa = null;
	private JButton bt_procurar = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_produtos = null;
	private JButton bt_novo = null;
	private JButton bt_informacoes = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private boolean inserir = true;
	private int currentPage = 1;
	private String currentSearch = ""; 
	private Vector<Produto> currentProdutos; //  @jve:decl-index=0:
	private JButton btn_terminando = null;
	private String pagina = "ProdutosFrame";

	/**
	 * This method initializes 
	 * 
	 */
	
	public static ProdutosFrame getInstance(){
		if(singleton==null){
			singleton=new ProdutosFrame();
		}
		
		return singleton;
	}
	
	
	private ProdutosFrame() {
		super();
		initialize();
		inserir = true;
		atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage,txt_pesquisa.getText()));
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
		this.setTitle("Produtos");
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
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridy = 2;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.anchor = GridBagConstraints.EAST;
			gridBagConstraints51.gridx = 3;
			gridBagConstraints51.gridy = 2;
			gridBagConstraints51.insets = new Insets(5, 0, 5, 0);
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.anchor = GridBagConstraints.WEST;
			gridBagConstraints41.gridx = 4;
			gridBagConstraints41.gridy = 2;
			gridBagConstraints41.insets = new Insets(5, 0, 5, 5);
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.gridy = 2;
			gridBagConstraints31.weightx = 0.1;
			gridBagConstraints31.insets = new Insets(5, 0, 5, 0);
			GridBagConstraints gridBagConstraints211 = new GridBagConstraints();
			gridBagConstraints211.insets = new Insets(5, 7, 5, 0);
			gridBagConstraints211.gridy = 2;
			gridBagConstraints211.gridx = 0;
			GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
			gridBagConstraints111.fill = GridBagConstraints.BOTH;
			gridBagConstraints111.gridx = 0;
			gridBagConstraints111.gridy = 1;
			gridBagConstraints111.weightx = 1.0;
			gridBagConstraints111.weighty = 1.0;
			gridBagConstraints111.gridwidth = 5;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.anchor = GridBagConstraints.WEST;
			gridBagConstraints22.gridy = 0;
			gridBagConstraints22.weightx = 0.7;
			gridBagConstraints22.gridx = 2;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.gridy = 0;
			gridBagConstraints12.weightx = 0.0;
			gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(7, 0, 5, 0);
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.weightx = 0.0;
			gridBagConstraints6.gridx = 0;
			lbl_procurar = new JLabel();
			lbl_procurar.setText("Procurar: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_procurar, gridBagConstraints6);
			jContentPane.add(getTxt_pesquisa(), gridBagConstraints12);
			jContentPane.add(getBt_procurar(), gridBagConstraints22);
			jContentPane.add(getJScrollPane(), gridBagConstraints111);
			jContentPane.add(getBt_novo(), gridBagConstraints211);
			jContentPane.add(getBt_informacoes(), gridBagConstraints31);
			jContentPane.add(getBt_next(), gridBagConstraints41);
			jContentPane.add(getBt_back(), gridBagConstraints51);
			jContentPane.add(getBtn_terminando(), gridBagConstraints);
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
						atualizaTable(GerenteBD.getInstance().getPageProdutos(1, currentSearch));
					}
				}
			});
}
return txt_pesquisa;
}

	/**
	 * This method initializes bt_procurar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_procurar() {
		if (bt_procurar == null) {
			bt_procurar = new JButton();
			bt_procurar.setText("Procurar...");
			bt_procurar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentPage=1;
					currentSearch=txt_pesquisa.getText();
					atualizaTable(GerenteBD.getInstance().getPageProdutos(1, currentSearch));
				}
			});
		}
		return bt_procurar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTb_produtos());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_produtos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_produtos() {
		if (tb_produtos == null) {
			tb_produtos = new JTable();
			tb_produtos.setModel(new DefaultTableModel(new Object[][] {{null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}}, new String[] {"Nome", "Descrição", "Quantidade", "Valor", "Fornecedor"}));
			tb_produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tb_produtos;
	}

	/**
	 * This method initializes bt_novo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_novo() {
		if (bt_novo == null) {
			bt_novo = new JButton();
			bt_novo.setText("Novo");
			bt_novo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					WindowManager.open(ProdutoForm.getInstance());
				}
			});
		}
		return bt_novo;
	}

	/**
	 * This method initializes bt_informacoes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_informacoes() {
		if (bt_informacoes == null) {
			bt_informacoes = new JButton();
			bt_informacoes.setText("Informações");
			bt_informacoes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				 int row = tb_produtos.getSelectedRow();
				 if(row > -1){
					 Produto p = currentProdutos.get(row);
					 if(p!=null){
					 ProdutoInfoFrame frame = ProdutoInfoFrame.getInstance(p.getIdproduto(),pagina);
					 WindowManager.open(frame);
					 }
				 }
				}
			});
		}
		return bt_informacoes;
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
					atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage,currentSearch));
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
					currentPage= currentPage - 1;
					atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage,txt_pesquisa.getText()));
				}
			});
		}
		return bt_back;
	}
	
	public void atualizaTable(Vector<Produto> produtos){
		Object[][]table=new Object[BDUtils.NUM_REG][5];
		int i=0;
		for(Produto p:produtos){
			Fornecedor f = new Fornecedor();
			f = GerenteBD.getInstance().getOneFornecedor(p.getIdfornecedor());
			table[i][0]=p.getNome();
			table[i][1]=p.getDescricao();
			table[i][2]=p.getQuantidade();
			table[i][3]=p.getValor();
			table[i][4]=f.getNome();
			
			
			i++;
		}
		
		tb_produtos.setModel(new javax.swing.table.DefaultTableModel(table,
				    new String [] {
				        "Nome", "Descrição", "Quantidade", "Preço","Fornecedor"
				    }
		));
		tb_produtos.updateUI();
		if(currentPage==1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);
		
		
		int num_produtos=GerenteBD.getInstance().getCountProdutos(currentSearch);
		int maxPage=num_produtos/BDUtils.NUM_REG+1;
		
		if(currentPage==maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);
		
		currentProdutos=produtos;
	}


	/**
	 * This method initializes btn_terminando	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtn_terminando() {
		if (btn_terminando == null) {
			btn_terminando = new JButton();
			btn_terminando.setText("Produtos em Termino");
			btn_terminando.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					WindowManager.open(ProdutosTerminoFrame.getInstance());
				}
			});
		}
		return btn_terminando;
	}


	
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
