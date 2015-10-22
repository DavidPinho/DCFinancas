package com.dcfinancas.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.SplashScreen;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.DefaultDesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import com.dcfinancas.model.bd.BDMySql;
import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Reserva;
import com.dcfinancas.model.negocio.Tipo_servico;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.WindowManager;

public class MainFrame extends JFrame {

	private static MainFrame current;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_newEncomenda = null;
	private JLabel lbl_agendarAtendimento = null;
	private JLabel lbl_fluxoCaixa = null;
	private JLabel lbl_cliente = null;
	private JLabel lbl_servico = null;
	private JLabel lbl_produto = null;
	private JLabel lbl_agenda = null;
	private JLabel lbl_fornecedor = null;
	private JScrollPane jScrollPane = null;
	private JTable tb_aniversariantes = null;
	private JLabel lbl_aniversariantes = null;
	private JMenuBar jJMenuBar = null;
	private JMenu arquivo = null;
	private JMenu clienteMenu = null;
	private JMenu produtoMenu = null;
	private JMenu servicoMenu = null;
	private JMenu ajudaMenu = null;
	private JLabel lbl_fornecedor1 = null;
	/**
	 * This is the default constructor
	 */
	
	
	

	public static MainFrame getCurrent(){
		return current;
	}
	
	private MainFrame() {
		super();
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				BDMySql.getInstance().fecharConexao();
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		initialize();
		AtualizaTable(GerenteBD.getInstance().getPageAniversariantes());
		current=this;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 600);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("DC Finanças");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowManager.centralizaTela(this);
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
			gridBagConstraints.gridy = 1;
			lbl_fornecedor = new JLabel(new ImageIcon(getClass().getResource("/images/fornecedor.png")));
			lbl_fornecedor.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_fornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(FornecedoresFrame.getInstance());
				}
			});
			
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints20.gridx = 1;
			gridBagConstraints20.gridy = 3;
			gridBagConstraints20.weighty = 0.25;
			gridBagConstraints20.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints20.gridwidth = 1;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints19.gridwidth = 3;
			gridBagConstraints19.gridx = 0;
			gridBagConstraints19.gridy = 4;
			gridBagConstraints19.weightx = 0.0;
			gridBagConstraints19.weighty = 0.25;
			gridBagConstraints19.insets = new Insets(0, 0, 0, 0);
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints18.gridx = 2;
			gridBagConstraints18.gridy = 1;
			gridBagConstraints18.gridwidth = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.insets = new Insets(3, 3, 2, 2);
			gridBagConstraints17.gridx = 2;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.weightx = 0.3;
			gridBagConstraints17.gridwidth = 1;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.insets = new Insets(4, 0, 0, 0);
			gridBagConstraints16.gridx = 1;
			gridBagConstraints16.gridy = 2;
			gridBagConstraints16.gridwidth = 1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.insets = new Insets(5, 3, 2, 7);
			gridBagConstraints15.gridy = 1;
			gridBagConstraints15.gridx = 1;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.insets = new Insets(6, 3, 4, 2);
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.gridy = 0;
			gridBagConstraints14.weightx = 0.3;
			gridBagConstraints14.gridwidth = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.insets = new Insets(9, 3, 6, 2);
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridy = 2;
			gridBagConstraints13.weighty = 0.25;
			gridBagConstraints13.gridwidth = 1;
			GridBagConstraints gridBagConstraints121 = new GridBagConstraints();
			gridBagConstraints121.insets = new Insets(9, 3, 6, 2);
			gridBagConstraints121.gridy = 1;
			gridBagConstraints121.weighty = 0.25;
			gridBagConstraints121.gridx = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.insets = new Insets(6, 7, 4, 2);
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 0.3;
			gridBagConstraints11.weighty = 0.25;
			gridBagConstraints11.gridx = 0;
			lbl_aniversariantes = new JLabel();
			lbl_aniversariantes.setFont(new java.awt.Font("Tahoma", 0, 24));
			lbl_aniversariantes.setText("Aniversariantes");
			
			
			lbl_agenda = new JLabel(new ImageIcon(getClass().getResource("/images/fila.png")));
			lbl_agenda.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					WindowManager.open(AgendaView.getInstance());
				}
			});
			lbl_agenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_produto = new JLabel(new ImageIcon(getClass().getResource("/images/addProduto.png")));
			lbl_produto.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_produto.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(ProdutosFrame.getInstance());
				}
			});
			lbl_servico = new JLabel(new ImageIcon(getClass().getResource("/images/servico.png")));
			lbl_servico.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_servico.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(ServicoView.getInstance());
				}
			});
			lbl_cliente = new JLabel(new ImageIcon(getClass().getResource("/images/addUsuario.png")));
						lbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {   
							public void mouseClicked(java.awt.event.MouseEvent e) {    
								WindowManager.open(ClientesFrame.getInstance());
							} 
						
			});
			lbl_cliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_fluxoCaixa = new JLabel(new ImageIcon(getClass().getResource("/images/caixa.png")));
			lbl_fluxoCaixa.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//lbl_fluxoCaixa.setText("JLabel");
			lbl_fluxoCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(HistoricoVendaFrame.getInstance());
				}
			});
			lbl_agendarAtendimento = new JLabel(new ImageIcon(getClass().getResource("/images/agendador.png")));
			lbl_agendarAtendimento.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//lbl_agendarAtendimento.setText("JLabel");
			lbl_agendarAtendimento.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(AgendarClienteForm.getInstance());
					
				}
			});
			lbl_newEncomenda = new JLabel(new ImageIcon(getClass().getResource("/images/newSell.png")));
			lbl_newEncomenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lbl_newEncomenda.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					WindowManager.open(EncomendaFrame.getInstance());
				}
			});
			
			//lbl_newEncomenda.setText("JLabel");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_newEncomenda, gridBagConstraints11);
			jContentPane.add(lbl_agendarAtendimento, gridBagConstraints121);
			jContentPane.add(lbl_fluxoCaixa, gridBagConstraints13);
			jContentPane.add(lbl_cliente, gridBagConstraints14);
			jContentPane.add(lbl_servico, gridBagConstraints15);
			jContentPane.add(lbl_produto, gridBagConstraints16);
			jContentPane.add(lbl_agenda, gridBagConstraints17);
			jContentPane.add(lbl_fornecedor, gridBagConstraints18);
			jContentPane.add(getJScrollPane(), gridBagConstraints19);
			jContentPane.add(lbl_aniversariantes, gridBagConstraints20);
			
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
			jScrollPane.setPreferredSize(new Dimension(453, 120));
			jScrollPane.setViewportView(getTb_aniversariantes());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tb_aniversariantes	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTb_aniversariantes() {
		if (tb_aniversariantes == null) {
			tb_aniversariantes = new javax.swing.JTable();

			tb_aniversariantes.setModel(new javax.swing.table.DefaultTableModel(
			    new Object [][] {
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null}
			    },
			    new String [] {
			        "Cliente", "Data Aniversário", "Telefone", "Endereço"
			    }
			));



			

			tb_aniversariantes.getColumnModel().getColumn(2).setResizable(false);
			tb_aniversariantes.getColumnModel().getColumn(3).setResizable(false);
		}
		return tb_aniversariantes;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getArquivo());
			jJMenuBar.add(getClienteMenu());
			jJMenuBar.add(getProdutoMenu());
			jJMenuBar.add(getServicoMenu());
			jJMenuBar.add(getAjudaMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes arquivo	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getArquivo() {
		if (arquivo == null) {
			arquivo = new JMenu();
			arquivo.setText("Arquivo");
		}
		return arquivo;
	}

	/**
	 * This method initializes clienteMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getClienteMenu() {
		if (clienteMenu == null) {
			clienteMenu = new JMenu();
			clienteMenu.setText("Clientes");
		}
		return clienteMenu;
	}

	/**
	 * This method initializes produtoMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getProdutoMenu() {
		if (produtoMenu == null) {
			produtoMenu = new JMenu();
			produtoMenu.setText("Produtos");
		}
		return produtoMenu;
	}

	/**
	 * This method initializes servicoMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getServicoMenu() {
		if (servicoMenu == null) {
			servicoMenu = new JMenu();
			servicoMenu.setText("Serviços");
		}
		return servicoMenu;
	}

	/**
	 * This method initializes ajudaMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getAjudaMenu() {
		if (ajudaMenu == null) {
			ajudaMenu = new JMenu();
			ajudaMenu.setText("Ajuda");
		}
		return ajudaMenu;
	}

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	
		
	}
	
	

	public void AtualizaTable(Vector<Cliente> cliente){
		Object[][] table = new Object[5][4];
		int i = 0;
		for (Cliente c : cliente) {
			
			table[i][0] = c.getNome() + " " + c.getSobrenome();
			table[i][1] = new SimpleDateFormat("dd/MM/yyyy").format(c.getData_nascimento());
			table[i][2] = c.getTelefone();
			table[i][3] = c.getEndereco();

			i++;
		}

		tb_aniversariantes.setModel(new javax.swing.table.DefaultTableModel(table,
				new String[] { "Cliente", "Data Aniversário", "Telefone", "Endereço" }));
	    tb_aniversariantes.updateUI();


		
	}	
	
	
	
}
