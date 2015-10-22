package com.dcfinancas.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.utils.Message;
import com.dcfinancas.utils.WindowManager;

public class ProdutoInfoFrame extends JFrame{

	private JPanel jContentPane = null;
	private JLabel lbl_nome = null;
	private JLabel lbl_nome_produto = null;
	private JLabel lbl_descricao = null;
	private JLabel lbl_descricao_produto = null;
	private JLabel lbl_quantidade = null;
	private JLabel lbl_quantidade_produto = null;
	private JLabel lbl_valor = null;
	private JLabel lbl_valor_produto = null;
	private JLabel lbl_fornecedor = null;
	private JLabel lbl_fornecedor_produto = null;
	private JButton bt_editar = null;
	private JButton bt_deletar = null;
	private static ProdutoInfoFrame singleton;
	private Produto p;
	private int idproduto;
	private String pagina = "";  //  @jve:decl-index=0:

	/**
	 * This method initializes 
	 * 
	 */
	
	public static ProdutoInfoFrame getInstance(int id,String pagina){
		if(singleton ==null)
			singleton = new ProdutoInfoFrame(id,pagina);
		
		return singleton;
	}
	
	
	private ProdutoInfoFrame(int id, String pagina) {
		super();
		initialize();
		this.pagina = pagina;
		p = GerenteBD.getInstance().getOneProduto(id);
		this.setTitle("Informações do "+p.getNome());
		preencheCampos();
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
        this.setSize(new Dimension(310, 271));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("Informações do");
        this.setResizable(false);
			
	}
	
	public void preencheCampos(){
		Fornecedor f = GerenteBD.getInstance().getOneFornecedor(p.getIdfornecedor());
		lbl_nome_produto.setText(p.getNome());
		lbl_descricao_produto.setText(p.getDescricao());
		lbl_valor_produto.setText(Double.toString(p.getValor()));
		lbl_quantidade_produto.setText(Float.toString(p.getQuantidade()));
		lbl_fornecedor_produto.setText(f.getNome());
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 6;
			gridBagConstraints11.ipadx = 0;
			gridBagConstraints11.insets = new Insets(7, 2, 10, 0);
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints12.gridy = 6;
			gridBagConstraints12.weighty = 0.0;
			gridBagConstraints12.gridx = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.gridy = 4;
			gridBagConstraints9.insets = new Insets(7, 7, 10, 0);
			lbl_fornecedor_produto = new JLabel();
			lbl_fornecedor_produto.setText("JLabel");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 4;
			gridBagConstraints8.insets = new Insets(7, 10, 10, 0);
			lbl_fornecedor = new JLabel();
			lbl_fornecedor.setText("Fornecedor:");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 3;
			gridBagConstraints7.insets = new Insets(7, 7, 10, 0);
			lbl_valor_produto = new JLabel();
			lbl_valor_produto.setText("JLabel");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 3;
			gridBagConstraints6.insets = new Insets(7, 10, 10, 0);
			lbl_valor = new JLabel();
			lbl_valor.setText("Preço:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.insets = new Insets(7, 7, 10, 0);
			lbl_quantidade_produto = new JLabel();
			lbl_quantidade_produto.setText("JLabel");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.insets = new Insets(7, 10, 10, 0);
			lbl_quantidade = new JLabel();
			lbl_quantidade.setText("Quantidade:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.insets = new Insets(7, 7, 10, 0);
			lbl_descricao_produto = new JLabel();
			lbl_descricao_produto.setText("JLabel");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.insets = new Insets(7, 10, 10, 0);
			lbl_descricao = new JLabel();
			lbl_descricao.setText("Descrição:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.insets = new Insets(7, 7, 10, 0);
			lbl_nome_produto = new JLabel();
			lbl_nome_produto.setText("JLabel");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.insets = new Insets(7, 10, 10, 0);
			lbl_nome = new JLabel();
			lbl_nome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_nome, gridBagConstraints);
			jContentPane.add(lbl_nome_produto, gridBagConstraints1);
			jContentPane.add(lbl_descricao, gridBagConstraints2);
			jContentPane.add(lbl_descricao_produto, gridBagConstraints3);
			jContentPane.add(lbl_quantidade, gridBagConstraints4);
			jContentPane.add(lbl_quantidade_produto, gridBagConstraints5);
			jContentPane.add(lbl_valor, gridBagConstraints6);
			jContentPane.add(lbl_valor_produto, gridBagConstraints7);
			jContentPane.add(lbl_fornecedor, gridBagConstraints8);
			jContentPane.add(lbl_fornecedor_produto, gridBagConstraints9);
			jContentPane.add(getBt_editar(), gridBagConstraints12);
			jContentPane.add(getBt_deletar(), gridBagConstraints11);
		}
		return jContentPane;
	}

	/**
	 * This method initializes bt_editar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_editar() {
		if (bt_editar == null) {
			bt_editar = new JButton();
			bt_editar.setText("Editar");
			bt_editar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					idproduto = p.getIdproduto();
					ProdutoForm frame = ProdutoForm.getInstance(idproduto,pagina);
					WindowManager.open(frame);
					ProdutoInfoFrame.this.dispose();
				}
			});
		}
		return bt_editar;
	}

	/**
	 * This method initializes bt_deletar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_deletar() {
		if (bt_deletar == null) {
			bt_deletar = new JButton();
			bt_deletar.setText("Deletar");
			bt_deletar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int result =0;
					result = GerenteBD.getInstance().deleteProduto(p.getIdproduto());
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(ProdutoInfoFrame.this, Message.getMensage(result));
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
						
						ProdutoInfoFrame.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(ProdutoInfoFrame.this, "Erro no Exclusão", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			});
			
		}
		return bt_deletar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
