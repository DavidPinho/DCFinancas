package com.dcfinancas.view;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import com.dcfinancas.model.bd.GerenteBD;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.utils.Message;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

public class FornecedorForm extends JFrame{
	
	private int idFornecedor;
	private static FornecedorForm singleton;
	private JPanel jPanel = null;  //  @jve:decl-index=0:visual-constraint="406,172"
	private JPanel jContentPane = null;
	private JLabel lbl_nome = null;
	private JTextField txt_nome = null;
	private JLabel lbl_email = null;
	private JTextField txt_email = null;
	private JLabel lbl_endereco = null;
	private JTextField txt_endereco = null;
	private JLabel lbl_telefone = null;
	private JTextField txt_telefone = null;
	private JLabel lbl_celular = null;
	private JTextField txt_celular = null;
	private JButton bt_cadastrar = null;
	private JButton bt_cancelar = null;
	private boolean inserir = true;
	
	
	public static FornecedorForm getInstance(){
		if(singleton == null){
			singleton = new FornecedorForm();
		}
		
		return singleton;
		
	}
	
	public static FornecedorForm getInstance(int id){
		if(singleton== null){
			singleton = new FornecedorForm(id);
		}
		
		return singleton;
	}
	/**
	 * This method initializes 
	 * 
	 */
	public FornecedorForm() {
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

	public FornecedorForm(int id) {
		super();
		initialize();
		inserir = false;
		this.idFornecedor = id;
		preencherCampos(GerenteBD.getInstance().getOneFornecedor(id));
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent arg0) {
				singleton=null;
			}
			
		});
	}
	
	private void preencherCampos(Fornecedor f){
		txt_nome.setText(f.getNome());
		txt_email.setText(f.getEmail());
		txt_endereco.setText(f.getEndereco());
		txt_telefone.setText(f.getTelefone());
		txt_celular.setText(f.getCelular());
		bt_cadastrar.setText("Atualizar");
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(396, 303);
		this.setContentPane(getJContentPane());
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//this.setContentPane(getJContentPane());
		this.setTitle("Cadastro Fornecedor");
		this.setResizable(false);
	
			
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbl_celular = new JLabel();
			lbl_celular.setBounds(new Rectangle(11, 173, 68, 16));
			lbl_celular.setText("Celular:");
			lbl_telefone = new JLabel();
			lbl_telefone.setBounds(new Rectangle(12, 137, 72, 16));
			lbl_telefone.setText("Telefone:");
			lbl_endereco = new JLabel();
			lbl_endereco.setBounds(new Rectangle(11, 101, 73, 16));
			lbl_endereco.setText("Endereço:");
			lbl_email = new JLabel();
			lbl_email.setBounds(new Rectangle(12, 65, 61, 16));
		    lbl_email.setLocation(11, 60);
			lbl_email.setText("Email:");
			lbl_nome = new JLabel();
			lbl_nome.setText("Nome:");
			lbl_nome.setBounds(new Rectangle(15, 22, 58, 17));
			lbl_nome.setLocation(11, 20);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbl_nome, null);
			jContentPane.add(getTxt_nome(), null);
			jContentPane.add(lbl_email, null);
			jContentPane.add(getTxt_email(), null);
			jContentPane.add(lbl_endereco, null);
			jContentPane.add(getTxt_endereco(), null);
			jContentPane.add(lbl_telefone, null);
			jContentPane.add(getTxt_telefone(), null);
			jContentPane.add(lbl_celular, null);
			jContentPane.add(getTxt_celular(), null);
			jContentPane.add(getBt_cadastrar(), null);
			jContentPane.add(getBt_cancelar(), null);
		}
		return jContentPane;
	}
	/**
	 * This method initializes txt_nome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_nome() {
		if (txt_nome == null) {
			txt_nome = new JTextField();
			txt_nome.setBounds(new Rectangle(89, 16, 260, 28));
			
		}
		return txt_nome;
	}
	/**
	 * This method initializes txt_email	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_email() {
		if (txt_email == null) {
			txt_email = new JTextField();
			txt_email.setBounds(new Rectangle(89, 55, 209, 28));
			
		}
		return txt_email;
	}
	/**
	 * This method initializes txt_endereco	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_endereco() {
		if (txt_endereco == null) {
			txt_endereco = new JTextField();
			txt_endereco.setBounds(new Rectangle(89, 94, 274, 28));
		}
		return txt_endereco;
	}
	/**
	 * This method initializes txt_telefone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_telefone() {
		if (txt_telefone == null) {
			try {
				txt_telefone = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			txt_telefone.setBounds(new Rectangle(89, 133, 160, 28));
		}
		return txt_telefone;
	}
	/**
	 * This method initializes txt_celular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxt_celular() {
		if (txt_celular == null) {
			try {
				txt_celular = new JFormattedTextField(new MaskFormatter("(##)####-####"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txt_celular.setBounds(new Rectangle(89, 172, 160, 28));
		}
		return txt_celular;
	}
	/**
	 * This method initializes bt_cadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_cadastrar() {
		if (bt_cadastrar == null) {
			bt_cadastrar = new JButton();
			bt_cadastrar.setBounds(new Rectangle(165, 222, 100, 25));
			bt_cadastrar.setText("Cadastrar");
			bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					if(txt_nome.getText().equals("")){
				       JOptionPane.showMessageDialog(FornecedorForm.this, "Nome obrigatório", "Atenção", JOptionPane.WARNING_MESSAGE);   
					   return;
					}
					int result=0;
					if(inserir){
					  Fornecedor f = new Fornecedor();
					  f.setNome(txt_nome.getText());
					  f.setEmail(txt_email.getText());
					  f.setEndereco(txt_endereco.getText());
					  f.setCelular(txt_celular.getText());
					  f.setTelefone(txt_telefone.getText());
					  result = GerenteBD.getInstance().insert(f);
					}
					else{
						  Fornecedor f = new Fornecedor();
						  f.setNome(txt_nome.getText());
						  f.setEmail(txt_email.getText());
						  f.setEndereco(txt_endereco.getText());
						  f.setCelular(txt_celular.getText());
						  f.setTelefone(txt_telefone.getText());
						  f.setIdfornecedor(idFornecedor);
						  result = GerenteBD.getInstance().update(f);
						
					}
					
					if(result==Message.SUCCESS_MENSAGE){
						JOptionPane.showMessageDialog(FornecedorForm.this, Message.getMensage(result));
						FornecedoresFrame frame = FornecedoresFrame.getInstance();
						if(frame.isVisible()){
							frame.setCurrentPage(1);
							frame.atualizaTable(GerenteBD.getInstance().getPageFornecedor(1,""));
						}
						FornecedorForm.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(FornecedorForm.this, "Erro no cadastro de um fornecedor", "Error!", JOptionPane.ERROR_MESSAGE);
					
					
				}
			});
		}
		return bt_cadastrar;
	}
	/**
	 * This method initializes bt_cancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBt_cancelar() {
		if (bt_cancelar == null) {
			bt_cancelar = new JButton();
			bt_cancelar.setBounds(new Rectangle(270, 222, 100, 25));
			bt_cancelar.setText("Cancelar");
			bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txt_nome.setText("");
					txt_email.setText("");
					txt_endereco.setText("");
					txt_telefone.setText("");
					txt_celular.setText("");
					
				
				}
			});
			
		}
		return bt_cancelar;
	}

	

}  //  @jve:decl-index=0:visual-constraint="10,10"
