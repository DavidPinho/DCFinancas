package com.dcfinancas.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Encomenda_produto;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Venda;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.WindowManager;
import javax.swing.JTabbedPane;
import java.lang.Object;
import java.lang.String;

public class EncomendaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5326788369294322892L;
	private static EncomendaFrame singleton;
	private JPanel jContentPane = null;
	private JLabel lbl_procurar = null;
	private JTextField txt_pesquisa = null;
	private JButton bt_procurar = null;
	private JButton bt_next = null;
	private JButton bt_back = null;
	private boolean inserir = true;
	private int currentPage = 1;
	private String currentSearch = "";
	private Vector<Produto> currentProdutos; // @jve:decl-index=0:
	private Venda venda;  //  @jve:decl-index=0:
	private JButton bt_add = null;
	private JButton bt_finaliza = null;
	private JTable tb_produtos1 = null;
	private JTable currentTable;
	private JScrollPane jScrollPane = null;
	private JTable tb_produtos = null;
	private boolean confirmado=false;

	/**
	 * This method initializes
	 * 
	 */

	public static EncomendaFrame getInstance() {
		
		
		if (singleton == null) {
			singleton = new EncomendaFrame();
		}

		return singleton;
	}

	private EncomendaFrame() {
		super();
		BDUtils.cleanVendas();
		initialize();
		inserir = true;
		atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage,
				txt_pesquisa.getText()));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton = null;
				
				if(!confirmado)
					GerenteBD.getInstance().deleteVenda(venda.getIdvenda());
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
		this.setTitle("Nova Encomenda");
		currentTable = tb_produtos;
		venda=GerenteBD.getInstance().initVenda();
		
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.gridwidth = 5;
			gridBagConstraints11.weightx = 1.0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
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
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.anchor = GridBagConstraints.WEST;
			gridBagConstraints22.gridy = 0;
			gridBagConstraints22.weightx = 0.7;
			gridBagConstraints22.gridwidth = 2;
			gridBagConstraints22.gridx = 2;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.gridy = 0;
			gridBagConstraints12.weightx = 0.15;
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
			jContentPane.add(getBt_next(), gridBagConstraints41);
			jContentPane.add(getBt_back(), gridBagConstraints51);
			jContentPane.add(getBt_add(), gridBagConstraints);
			jContentPane.add(getBt_finaliza(), gridBagConstraints1);
			jContentPane.add(getJScrollPane(), gridBagConstraints11);
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
					if (e.getKeyChar() == '\n') {
						currentPage = 1;
						currentSearch = txt_pesquisa.getText();
						atualizaTable(GerenteBD.getInstance().getPageProdutos(
								1, currentSearch));
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
					currentPage = 1;
					currentSearch = txt_pesquisa.getText();
					atualizaTable(GerenteBD.getInstance().getPageProdutos(1,
							currentSearch));
				}
			});
		}
		return bt_procurar;
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
					atualizaTable(GerenteBD.getInstance().getPageProdutos(
							currentPage, currentSearch));
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
					currentPage = currentPage - 1;
					atualizaTable(GerenteBD.getInstance().getPageProdutos(
							currentPage, txt_pesquisa.getText()));
				}
			});
		}
		return bt_back;
	}

	public void atualizaTable(Vector<Produto> produtos) {
		Object[][] table = new Object[BDUtils.NUM_REG][5];
		int i = 0;
		for (Produto p : produtos) {
			Fornecedor f = new Fornecedor();
			f = GerenteBD.getInstance().getOneFornecedor(p.getIdfornecedor());
			table[i][0] = p.getNome();
			table[i][1] = p.getDescricao();
			table[i][2] = p.getQuantidade();
			table[i][3] = p.getValor();
			table[i][4] = f.getNome();

			i++;
		}

		currentTable.setModel(new javax.swing.table.DefaultTableModel(table,
				new String[] { "Nome", "Descrição", "Quantidade", "Preço",
						"Fornecedor" }));
		currentTable.updateUI();
		if (currentPage == 1)
			bt_back.setEnabled(false);
		else
			bt_back.setEnabled(true);

		int num_produtos = GerenteBD.getInstance().getCountProdutos(
				currentSearch);
		int maxPage = num_produtos / BDUtils.NUM_REG + 1;

		if (currentPage == maxPage)
			bt_next.setEnabled(false);
		else
			bt_next.setEnabled(true);

		currentProdutos = produtos;
	}

	
	/**
	 * This method initializes bt_add
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt_add() {
		if (bt_add == null) {
			bt_add = new JButton();
			bt_add.setText("Adicionar no carrinho");
			bt_add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l = tb_produtos.getSelectedRow();
					if (l > -1) {
						boolean validado = false;
						while (!validado)
							try {
								String out =JOptionPane
										.showInputDialog(EncomendaFrame.this,
												"Quantidade a ser retirada:",
												"Selecionar quantidade",
												JOptionPane.DEFAULT_OPTION);
								
								if(out==null|out==null)
									return;
								
								int qtd=Integer.parseInt(out);
								Produto p=currentProdutos.get(l);
								if(qtd<=p.getQuantidade()){
									validado=true;
									boolean produtoRepedito=false;
									if(qtd>0){
										p.setQuantidade(p.getQuantidade() - qtd);
										Produto novo=p.clone();
										novo.setQuantidade(qtd);
										
										List<Encomenda_produto> currentProdutos=GerenteBD.getInstance().getEncomendasByVenda(venda.getIdvenda());
										
										Encomenda_produto encomendaExistente=null;
										for(Encomenda_produto encomenda:currentProdutos){
											if(encomenda.getIdproduto()==novo.getIdproduto()){
												produtoRepedito=true;
												encomendaExistente=encomenda;
												break;
											}
										}
										if(!produtoRepedito){
											Encomenda_produto encomenda=new Encomenda_produto();
											encomenda.setIdproduto(novo.getIdproduto());
											encomenda.setIdvenda(venda.getIdvenda());
											encomenda.setQtd(novo.getQuantidade());
											venda.getEncomendas().add(encomenda);
										
											GerenteBD.getInstance().insert(encomenda);
										}else{
											encomendaExistente.setQtd(encomendaExistente.getQtd()+qtd);
											
											
											GerenteBD.getInstance().update(encomendaExistente);
										}
										//carrinho.add(novo);
									}
								}
								else
									JOptionPane.showConfirmDialog(EncomendaFrame.this, "Quantidade indisponível", "Valor inválido", JOptionPane.WARNING_MESSAGE);
							} catch (Exception ex) {

							}
					}
					atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage, currentSearch));
					
				}
			});
		}
		return bt_add;
	}

	/**
	 * This method initializes bt_finaliza
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt_finaliza() {
		if (bt_finaliza == null) {
			bt_finaliza = new JButton();
			bt_finaliza.setText("Finaliza Compra");
			bt_finaliza.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CarrinhoDialog c=CarrinhoDialog.getInstance(EncomendaFrame.this, venda);
					c.setVisible(true);
				}
			});
		}
		return bt_finaliza;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setName("estoque");
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

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public boolean isConfirmado() {
		return confirmado;
	}
	
	public void refreshCurrentPage(){
		atualizaTable(GerenteBD.getInstance().getPageProdutos(currentPage, currentSearch));
	}

}
