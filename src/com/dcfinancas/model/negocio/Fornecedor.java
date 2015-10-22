package com.dcfinancas.model.negocio;

public class Fornecedor {
	
	private int idfornecedor;
	private String nome;
	private String endereco;
	private String email;
	private String celular;
	private String telefone;
	
	
	public int getIdfornecedor() {
		return idfornecedor;
	}
	public void setIdfornecedor(int idfornecedor) {
		this.idfornecedor = idfornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular() {
		return celular;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public String toString(){
		return this.nome;
	}

}
