package com.dcfinancas.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.utils.Message;
import com.dcfinancas.utils.WindowManager;

public class FornecedorInfoFrame extends JFrame {

	private Fornecedor fornecedor;
	private JPanel jContentPane = null;
	private static FornecedorInfoFrame singleton;
	private JLabel lbl_nome = null;
	private JLabel lbl_nome_fornecedor = null;
	private JLabel lbl_email = null;
	private JLabel lbl_email_fornecedor = null;
	private JLabel lbl_endereco = null;
	private JLabel lbl_endereco_fornecedor = null;
	private JLabel lbl_celular = null;
	private JLabel lbl_celular_fornecedor = null;
	private JLabel lbl_telefone = null;
	private JLabel lbl_telefone_fornecedor = null;
	private JButton bt_editar = null;
	private JButton bt_deletar = null;
	/**
	 * This method initializes 
	 * 
	 */
	
	public static FornecedorInfoFrame getInstance(int id){
		if(singleton == null){
			singleton = new FornecedorInfoFrame(id);
		}
		
		return singleton;
	}
	
	private FornecedorInfoFrame(int id) {
		super();
		initialize();
		fornecedor = GerenteBD.getInstance().getOneFornecedor(id);
		this.setTitle("Informações de "+fornecedor.getNome());
		preencheCampos();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}

	private void preencheCampos() {
		lbl_nome_fornecedor.setText(fornecedor.getNome());
		lbl_email_fornecedor.setText(fornecedor.getEmail());
		lbl_endereco_fornecedor.setText(fornecedor.getEndereco());
		lbl_celular_fornecedor.setText(fornecedor.getCelular());
		lbl_telefone_fornecedor.setText(fornecedor.getTelefone());
		
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setSize(new Dimension(301, 271));
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("Informações de ");
		this.setResizable(false);	
	}
	
	
	

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.insets = new Insets(7, 2, 10, 0);
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.ipadx = 0;
			gridBagConstraints11.gridy = 6;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.weighty = 0.0;
			gridBagConstraints12.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints12.gridy = 6;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.anchor = GridBagConstraints.WEST;
			gridBagConstraints9.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints9.gridy = 4;
			lbl_telefone_fornecedor = new JLabel();
			lbl_telefone_fornecedor.setText("JLabel");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.insets = new Insets(7, 10, 10, 0);
			gridBagConstraints8.gridy = 4;
			lbl_telefone = new JLabel();
			lbl_telefone.setText("Telefone:");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.gridy = 3;
			lbl_celular_fornecedor = new JLabel();
			lbl_celular_fornecedor.setText("JLabel");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.insets = new Insets(7, 10, 10, 0);
			gridBagConstraints6.gridy = 3;
			lbl_celular = new JLabel();
			lbl_celular.setText("Celular:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 2;
			lbl_endereco_fornecedor = new JLabel();
			lbl_endereco_fornecedor.setText("JLabel");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(7, 10, 10, 0);
			gridBagConstraints4.gridy = 2;
			lbl_endereco = new JLabel();
			lbl_endereco.setText("Endereço:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints3.gridy = 1;
			lbl_email_fornecedor = new JLabel();
			lbl_email_fornecedor.setText("JLabel");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.insets = new Insets(7, 10, 10, 0);
			gridBagConstraints2.gridy = 1;
			lbl_email = new JLabel();
			lbl_email.setText("Email:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.weightx = 0.5;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(7, 7, 10, 0);
			gridBagConstraints1.gridy = 0;
			lbl_nome_fornecedor = new JLabel();
			lbl_nome_fornecedor.setText("JLabel");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(10, 10, 10, 0);
			gridBagConstraints.weightx = 0.0;
			gridBagConstraints.weighty = 0.0;
			gridBagConstraints.gridy = 0;
			lbl_nome = new JLabel();
			lbl_nome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(lbl_nome, gridBagConstraints);
			jContentPane.add(lbl_nome_fornecedor, gridBagConstraints1);
			jContentPane.add(lbl_email, gridBagConstraints2);
			jContentPane.add(lbl_email_fornecedor, gridBagConstraints3);
			jContentPane.add(lbl_endereco, gridBagConstraints4);
			jContentPane.add(lbl_endereco_fornecedor, gridBagConstraints5);
			jContentPane.add(lbl_celular, gridBagConstraints6);
			jContentPane.add(lbl_celular_fornecedor, gridBagConstraints7);
			jContentPane.add(lbl_telefone, gridBagConstraints8);
			jContentPane.add(lbl_telefone_fornecedor, gridBagConstraints9);
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
					
					FornecedorForm f = FornecedorForm.getInstance(fornecedor.getIdfornecedor());
					WindowManager.open(f);
					FornecedorInfoFrame.this.dispose();
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
					int id = fornecedor.getIdfornecedor();
					int result = GerenteBD.getInstance().delete(id);
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(FornecedorInfoFrame.this, Message.getMensage(result));
						FornecedoresFrame frame = FornecedoresFrame.getInstance();
						if(frame.isVisible()){
							frame.setCurrentPage(1);
							frame.atualizaTable(GerenteBD.getInstance().getPageFornecedor(1,""));
						}
						FornecedorInfoFrame.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(FornecedorInfoFrame.this, "Erro na exclusão!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			});
			
		}
		return bt_deletar;
	}

}  //  @jve:decl-index=0:visual-constraint="16,22"
