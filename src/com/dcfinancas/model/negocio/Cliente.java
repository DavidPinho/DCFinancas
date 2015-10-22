package com.dcfinancas.model.negocio;

import java.sql.Date;
import java.util.List;

public class Cliente {
	
	private int idcliente;
	private String nome;
	private String sobrenome;
	private Date data_nascimento;
	private int CPF;
	private String endereco;
	private String email;
	private String telefone,celular;
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date dataNascimento) {
		data_nascimento = dataNascimento;
	}
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCelular() {
		return celular;
	}
	
	
	

}
