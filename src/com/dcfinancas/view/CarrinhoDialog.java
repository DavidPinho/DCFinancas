package com.dcfinancas.view;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Window;

import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.lang.String;
import java.sql.Date;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Encomenda_produto;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Venda;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class CarrinhoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private static CarrinhoDialog singleton;
	private JPanel jContentPane = null;
	private JPanel jContentPane1 = null;
	private JButton bt_add = null;
	private JButton bt_finaliza = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_produtos = null;
	private JLabel lbl_total = null;
	private Venda venda;
	private Vector<Encomenda_produto> currentEncomendas = new Vector<Encomenda_produto>();
	private JButton bt_alterarQtd = null;
	private float total;
	private JLabel lbl_cliente = null;
	private JTextField txt_cliente = null;
	private JButton bt_search = null;
	private JLabel lbl_debito = null;
	private JRadioButton ck_aberto = null;
	private JRadioButton ck_finalizado = null;
	

	public static CarrinhoDialog getInstance(JFrame owner, Venda v) {
		if (singleton == null)
			singleton = new CarrinhoDialog(owner, v);
		else
			singleton.atualizaTable(GerenteBD.getInstance().getEncomendasByVenda(v.getIdvenda()));
		return singleton;
	}
	

	public static CarrinhoDialog getInstance() {
		return singleton;
	}

	/**
	 * @param owner
	 */
	public CarrinhoDialog(JFrame owner, Venda venda) {
		super(owner);
		this.venda = venda;
		initialize();
		Dimension paneSize = this.getSize();
		JFrame current = owner;
		Dimension screenSize = current.getSize();
		this.setLocation(current.getLocation().x
				+ (screenSize.width - paneSize.width) / 2,
				current.getLocation().y + (screenSize.height - paneSize.height)
						/ 2);
		this.addWindowListener(new WindowAdapter() {

			
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
				singleton = null;
			}

		});
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(643, 354);
		this.setTitle("Carrinho de Compras");
		this.setContentPane(getJContentPane());
		ButtonGroup group = new ButtonGroup();
		group.add(ck_aberto);
		group.add(ck_finalizado);
		atualizaTable(GerenteBD.getInstance().getEncomendasByVenda(venda.getIdvenda()));
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJContentPane1(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jContentPane1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 4;
			gridBagConstraints6.gridy = 4;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.gridy = 4;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridy = 4;
			lbl_debito = new JLabel();
			lbl_debito.setText("Pagamento: ");
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 4;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridy = 3;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints21.gridy = 3;
			gridBagConstraints21.weightx = 0.0;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.ipadx = 180;
			gridBagConstraints21.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridy = 3;
			lbl_cliente = new JLabel();
			lbl_cliente.setText("Cliente: ");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 2;
			gridBagConstraints3.insets = new Insets(0, 3, 5, 0);
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridy = 5;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(4, 0, 3, 0);
			gridBagConstraints.gridy = 2;
			lbl_total = new JLabel();
			lbl_total.setText("Total: ");
			GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
			gridBagConstraints111.fill = GridBagConstraints.BOTH;
			gridBagConstraints111.gridx = 0;
			gridBagConstraints111.gridy = 1;
			gridBagConstraints111.weightx = 1.0;
			gridBagConstraints111.weighty = 1.0;
			gridBagConstraints111.gridwidth = 5;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 4;
			gridBagConstraints11.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.gridy = 5;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 5;
			gridBagConstraints2.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints2.gridwidth = 2;
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(new GridBagLayout());
			jContentPane1.add(getBt_add(), gridBagConstraints2);
			jContentPane1.add(getBt_finaliza(), gridBagConstraints11);
			jContentPane1.add(getJScrollPane(), gridBagConstraints111);
			jContentPane1.add(lbl_total, gridBagConstraints);
			jContentPane1.add(getBt_alterarQtd(), gridBagConstraints3);
			jContentPane1.add(lbl_cliente, gridBagConstraints1);
			jContentPane1.add(getTxt_cliente(), gridBagConstraints21);
			jContentPane1.add(getBt_search(), gridBagConstraints31);
			jContentPane1.add(lbl_debito, gridBagConstraints4);
			jContentPane1.add(getCk_aberto(), gridBagConstraints5);
			jContentPane1.add(getCk_finalizado(), gridBagConstraints6);
		}
		return jContentPane1;
	}

	/**
	 * This method initializes bt_add
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt_add() {
		if (bt_add == null) {
			bt_add = new JButton();
			bt_add.setText("Remover do Carrinho");
			bt_add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int l=tb_produtos.getSelectedRow();
					if(l>-1){
						Encomenda_produto encomenda=currentEncomendas.get(l);
						if(e!= null){
							
							GerenteBD.getInstance().deleteEncomenda(encomenda.getIdvenda(), encomenda.getIdproduto());
							
							atualizaTable(GerenteBD.getInstance().getEncomendasByVenda(venda.getIdvenda()));
							EncomendaFrame.getInstance().refreshCurrentPage();
						}
					}
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
					venda.setValor_total(total);
					if(ck_finalizado.isSelected())
						venda.setData_pagamento(new Date(System.currentTimeMillis()));
					
					int r=GerenteBD.getInstance().update(venda);
					EncomendaFrame frame=EncomendaFrame.getInstance();
					CarrinhoDialog.this.dispose();
					if(r==Message.SUCCESS_MENSAGE){
						frame.setConfirmado(true);
						JOptionPane.showMessageDialog(CarrinhoDialog.this, "Compra filaizada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
					}
					frame.dispose();
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
			tb_produtos.setModel(new DefaultTableModel(new Object[15][3],
					new String[] { "Produto", "Preço", "Quantidade" }));
			tb_produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tb_produtos;
	}

	public void atualizaTable(Vector<Encomenda_produto> encomendas) {
		total = 0;
		Object[][] table = new Object[BDUtils.NUM_REG][3];
		int i = 0;
		for (Encomenda_produto encomenda : encomendas) {
			Produto p = GerenteBD.getInstance().getOneProduto(
					encomenda.getIdproduto());
			table[i][0] = p.getNome();
			table[i][1] = p.getValor();
			table[i][2] = encomenda.getQtd();

			total += encomenda.getQtd() * p.getValor();
			i++;
		}

		tb_produtos.setModel(new javax.swing.table.DefaultTableModel(table,
				new String[] { "Nome", "Valor", "Quantidade" }));
		tb_produtos.updateUI();

		currentEncomendas = encomendas;
		lbl_total.setText("Total: R$"+Float.toString(total));

	}

	/**
	 * This method initializes bt_alterarQtd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBt_alterarQtd() {
		if (bt_alterarQtd == null) {
			bt_alterarQtd = new JButton();
			bt_alterarQtd.setText("Alterar quantidade");
			bt_alterarQtd
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							int l = tb_produtos.getSelectedRow();
							if (l > -1) {
								Encomenda_produto encomenda = currentEncomendas
										.get(l);
								if (encomenda != null) {
									boolean validado = false;
									while (!validado)
										try {
											String out = JOptionPane
													.showInputDialog(
															CarrinhoDialog.this,
															"Informa a nova quantidade:",
															"Atualizar quantidade",
															JOptionPane.DEFAULT_OPTION);

											if (out == null | out == null)
												return;

											int qtd = Integer.parseInt(out);
											Produto p = GerenteBD
													.getInstance()
													.getOneProduto(
															encomenda
																	.getIdproduto());
											if (qtd <= p.getQuantidade()+encomenda.getQtd()) {
												validado = true;
												if (qtd > 0) {

													encomenda.setQtd(qtd);
													GerenteBD.getInstance()
															.update(encomenda);
													// carrinho.add(novo);
												}
											} else
												JOptionPane
														.showConfirmDialog(
																CarrinhoDialog.this,
																"Quantidade indisponível",
																"Valor inválido",
																JOptionPane.WARNING_MESSAGE);
										} catch (Exception ex) {

										}

								}
								atualizaTable(GerenteBD.getInstance().getEncomendasByVenda(venda.getIdvenda()));
								EncomendaFrame.getInstance().refreshCurrentPage();
							}
						}
					});
		}
		return bt_alterarQtd;
	}

	/**
	 * This method initializes txt_cliente	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_cliente() {
		if (txt_cliente == null) {
			txt_cliente = new JTextField();
		}
		return txt_cliente;
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
					ClienteChooser.open(EncomendaFrame.getInstance());
				}
			});
		}
		return bt_search;
	}
	
	public void setCliente(Cliente c){
		venda.setIdcliente(c.getIdcliente());
		txt_cliente.setText(c.getNome()+" "+c.getSobrenome());
	}


	/**
	 * This method initializes ck_aberto	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getCk_aberto() {
		if (ck_aberto == null) {
			ck_aberto = new JRadioButton();
			ck_aberto.setText("Em aberto");
			ck_aberto.setSelected(true);
		}
		return ck_aberto;
	}


	/**
	 * This method initializes ck_finalizado	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getCk_finalizado() {
		if (ck_finalizado == null) {
			ck_finalizado = new JRadioButton();
			ck_finalizado.setText("Efetuado");
		}
		return ck_finalizado;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
