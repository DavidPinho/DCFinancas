package com.dcfinancas.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.utils.Message;

public class ProdutoForm extends JFrame {

	private Produto produto;
	private boolean inserir = true;
	private static ProdutoForm singleton;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbl_nome = null;
	private JLabel lbl_desc = null;
	private JLabel lbl_preco = null;
	private JLabel lbl_qtd = null;
	private JLabel lbl_fornecedor = null;
	private JButton bt_ok = null;
	private JButton bt_cancelar = null;
	private JTextField txt_nome = null;
	private JTextArea txt_descricao = null;
	private JTextField txt_preco = null;
	private JTextField txt_qtd = null;
	private JButton bt_procurar = null;
	private JTextField txt_fornecedor = null;
	private int idfornecedor;
	private String pagina = "";
	/**
	 * This is the default constructor
	 */
	
	public static ProdutoForm getInstance(){
		if(singleton==null){
			singleton= new ProdutoForm();
		}
		return singleton;
	}
	
	public static ProdutoForm getInstance(int id, String pagina){
		if(singleton==null){
			singleton= new ProdutoForm(id,pagina);
		}
		return singleton;
	}
	private ProdutoForm() {
		super();
		initialize();
		inserir = true;
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
		
	}

	private ProdutoForm(int id, String pagina) {
		super();
		initialize();
		this.pagina = pagina;
		inserir = false;
	    produto = GerenteBD.getInstance().getOneProduto(id);
	    preencheCampos(produto);
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
	 * @return void
	 */
	private void initialize() {
		this.setSize(330, 392);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Produtos");
		this.setResizable(false);
	}
	
	public void preencheCampos(Produto p){
		Fornecedor f = GerenteBD.getInstance().getOneFornecedor(p.getIdfornecedor());
		txt_nome.setText(p.getNome());
		txt_descricao.setText(p.getDescricao());
		txt_preco.setText(Double.toString(p.getValor()));
		txt_qtd.setText(Integer.toString(p.getQuantidade()));
		txt_fornecedor.setText(f.getNome());
		bt_ok.setText("Atualizar");
		idfornecedor = p.getIdfornecedor();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_fornecedor = new JLabel();
			lbl_fornecedor.setBounds(new Rectangle(14, 267, 80, 16));
			lbl_fornecedor.setText("Fornecedor: ");
			lbl_qtd = new JLabel();
			lbl_qtd.setBounds(new Rectangle(16, 231, 78, 16));
			lbl_qtd.setText("Quantidade: ");
			lbl_preco = new JLabel();
			lbl_preco.setText("Preço: ");
			lbl_preco.setLocation(new Point(16, 196));
			lbl_preco.setSize(new Dimension(50, 16));
			lbl_desc = new JLabel();
			lbl_desc.setBounds(new Rectangle(16, 49, 72, 16));
			lbl_desc.setText("Descrição: ");
			lbl_nome = new JLabel();
			lbl_nome.setBounds(new Rectangle(17, 20, 52, 16));
			lbl_nome.setText("Nome: ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbl_nome, null);
			jContentPane.add(lbl_desc, null);
			jContentPane.add(lbl_preco, null);
			jContentPane.add(lbl_qtd, null);
			jContentPane.add(lbl_fornecedor, null);
			jContentPane.add(getBt_ok(), null);
			jContentPane.add(getBt_cancelar(), null);
			jContentPane.add(getTxt_nome(), null);
			jContentPane.add(getTxt_descricao(), null);
			jContentPane.add(getTxt_preco(), null);
			jContentPane.add(getTxt_qtd(), null);
			jContentPane.add(getBt_procurar(), null);
			jContentPane.add(getTxt_fornecedor(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes bt_ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_ok() {
		if (bt_ok == null) {
			bt_ok = new JButton();
			bt_ok.setText("Cadastrar");
			bt_ok.setSize(new Dimension(96, 25));
			bt_ok.setLocation(new Point(116, 307));
			bt_ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result=0;
					if(inserir){
					Produto p = new Produto();
					p.setDescricao(txt_descricao.getText());
					p.setNome(txt_nome.getText());
					p.setValor(Double.parseDouble(txt_preco.getText()));
					p.setQuantidade(Integer.parseInt(txt_qtd.getText()));
					p.setIdfornecedor(idfornecedor);
					result = GerenteBD.getInstance().insert(p);
					}
					else{
						Produto p = new Produto();
						p.setDescricao(txt_descricao.getText());
						p.setNome(txt_nome.getText());
						p.setValor(Double.parseDouble(txt_preco.getText()));
						p.setQuantidade(Integer.parseInt(txt_qtd.getText()));
						p.setIdfornecedor(idfornecedor);
						p.setIdproduto(produto.getIdproduto());
						result = GerenteBD.getInstance().update(p);
					}
					
					if(result==Message.SUCCESS_MENSAGE){
 						JOptionPane.showMessageDialog(ProdutoForm.this, Message.getMensage(result));
 						if(pagina.equals("ProdutosFrame")){
 						   ProdutosFrame frame = ProdutosFrame.getInstance();
 						   if(frame.isVisible())
 								frame.atualizaTable(GerenteBD.getInstance().getPageProdutos(1,""));
 						} else 
 						if(pagina.equals("ProdutosTerminoFrame")){
 							ProdutosTerminoFrame frame = ProdutosTerminoFrame.getInstance();
 							if(frame.isVisible())
 								frame.atualizaTable(GerenteBD.getInstance().getPageTermino(1,""));
 						}
 						
						ProdutoForm.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(ProdutoForm.this, "Erro no cadastro!", "Error!", JOptionPane.ERROR_MESSAGE);
					
					
				}
			});
		}
		return bt_ok;
	}

	/**
	 * This method initializes bt_cancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_cancelar() {
		if (bt_cancelar == null) {
			bt_cancelar = new JButton();
			bt_cancelar.setText("Cancelar");
			bt_cancelar.setSize(new Dimension(85, 25));
			bt_cancelar.setLocation(new Point(216, 309));
			bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txt_nome.setText("");
					txt_descricao.setText("");
					txt_preco.setText("");
					txt_qtd.setText("");
					txt_fornecedor.setText("");
				}
			});
		}
		return bt_cancelar;
	}

	/**
	 * This method initializes txt_nome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_nome() {
		if (txt_nome == null) {
			txt_nome = new JTextField();
			txt_nome.setLocation(new Point(111, 16));
			txt_nome.setSize(new Dimension(170, 25));
		}
		return txt_nome;
	}

	/**
	 * This method initializes txt_descricao	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxt_descricao() {
		if (txt_descricao == null) {
			txt_descricao = new JTextArea();
			txt_descricao.setBounds(new Rectangle(27, 73, 251, 112));
		}
		return txt_descricao;
	}

	/**
	 * This method initializes txt_preco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_preco() {
		if (txt_preco == null) {
			txt_preco = new JTextField();
			txt_preco.setSize(new Dimension(78, 25));
			txt_preco.setLocation(new Point(111, 192));
		}
		return txt_preco;
	}

	/**
	 * This method initializes txt_qtd	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_qtd() {
		if (txt_qtd == null) {
			txt_qtd = new JTextField();
			txt_qtd.setSize(new Dimension(70, 25));
			txt_qtd.setLocation(new Point(111, 229));
		}
		return txt_qtd;
	}

	/**
	 * This method initializes cb_fornecedores	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	

	/**
	 * This method initializes bt_procurar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_procurar() {
		if (bt_procurar == null) {
			bt_procurar = new JButton();
			bt_procurar.setBounds(new Rectangle(216, 264, 85, 25));
			bt_procurar.setText("Procurar");
			bt_procurar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				    ProdutoChooser.open(ProdutoForm.this);
				}
			});
		}
		return bt_procurar;
	}

	/**
	 * This method initializes txt_fornecedor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_fornecedor() {
		if (txt_fornecedor == null) {
			txt_fornecedor = new JTextField();
			txt_fornecedor.setBounds(new Rectangle(111, 263, 104, 28));
		}
		return txt_fornecedor;
	}
	
	public void setFornecedor(Fornecedor f){
		txt_fornecedor.setText(f.getNome());
		idfornecedor = f.getIdfornecedor();
	}

}  //  @jve:decl-index=0:visual-constraint="10,9"
