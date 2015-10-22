package com.dcfinancas.model.negocio;

import java.sql.Date;
import java.util.Vector;

public class Venda {
	
	private int idvenda;
	private double valor_total;
	private Date data_venda;
	private Date data_pagamento;
	private int idcliente;
	private Vector<Encomenda_produto> encomendas=new Vector<Encomenda_produto>();
	
	public int getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valorTotal) {
		valor_total = valorTotal;
	}
	public Date getData_venda() {
		return data_venda;
	}
	public void setData_venda(Date dataVenda) {
		data_venda = dataVenda;
	}
	public Date getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(Date dataPagamento) {
		data_pagamento = dataPagamento;
	}
	
	
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setEncomendas(Vector<Encomenda_produto> encomendas) {
		this.encomendas = encomendas;
	}
	public Vector<Encomenda_produto> getEncomendas() {
		return encomendas;
	}
	
	

}
