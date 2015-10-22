package com.dcfinancas.model.negocio;

public class Imagem {
	
	private int idimagem;
	private String imagem;
	private int idproduto;
	
	
	public int getIdimagem() {
		return idimagem;
	}
	public void setIdimagem(int idimagem) {
		this.idimagem = idimagem;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	 
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	public int getIdproduto() {
		return idproduto;
	}

}
