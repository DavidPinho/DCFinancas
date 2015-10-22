package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Encomenda_produto;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;

public class Encomenda_produtoBD {

	BDMySql bdMySql = BDMySql.getInstance();

	protected int insert(Encomenda_produto ep) {

		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"insert into encomenda_produto (idvenda,idproduto,qtd) values (?,?,?)");
			ps.setInt(1, ep.getIdvenda());
			ps.setInt(2, ep.getIdproduto());
			ps.setFloat(3, ep.getQtd());
			ps.execute();

			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}

	}

	protected int delete(int idvenda, int idproduto) {

		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"delete from encomenda_produto where idvenda = ? and idproduto=?");
			ps.setInt(1, idvenda);
			ps.setInt(2, idproduto);
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	}

	protected int deleteFromVenda(int idvenda) {

		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement("delete from encomenda_produto where idvenda = ?");
			ps.setInt(1, idvenda);
			
			ps.execute();
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
		
	}

	protected Encomenda_produto getOne(int idencomenda_produto) {
		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"select * from encomenda_produto where idencomenda_produto = ?");
			ps.setInt(1, idencomenda_produto);
			ResultSet rs = ps.executeQuery();
			Encomenda_produto ep = new Encomenda_produto();

			while (rs.next()) {

				ep.setIdencomenda_produto(rs.getInt("idencomenda_produto"));
				ep.setIdproduto(rs.getInt("idproduto"));
				ep.setIdvenda(rs.getInt("idvenda"));

			}

			return ep;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Vector<Encomenda_produto> getAll() {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from encomenda_produto");
			ResultSet rs = ps.executeQuery();
			Vector<Encomenda_produto> all = new Vector<Encomenda_produto>();

			while (rs.next()) {

				Encomenda_produto ep = new Encomenda_produto();
				ep.setIdencomenda_produto(rs.getInt("idencomenda_produto"));
				ep.setIdproduto(rs.getInt("idproduto"));
				ep.setIdvenda(rs.getInt("idvenda"));

				all.add(ep);

			}

			return all;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected int update(Encomenda_produto ep) {
		try {

			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"update encomenda_produto set qtd=? where idvenda = ? and idproduto = ?");
			
			ps.setFloat(1, ep.getQtd());
			ps.setInt(2, ep.getIdvenda());
			ps.setInt(3, ep.getIdproduto());
	

			ps.execute();

			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}

	}
	
	
	protected Vector<Encomenda_produto> getPage(int idvenda, int i){
		Vector<Encomenda_produto> list = new Vector();
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from encomenda_produto where idvenda = ? limit  ? ," +BDUtils.NUM_REG+"");
			int finalPage=BDUtils.NUM_REG*i;
			int initPage=finalPage-BDUtils.NUM_REG;
			
			ps.setInt(1, idvenda);
			ps.setInt(2, initPage);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Encomenda_produto ep = new Encomenda_produto();
				
				ep.setIdproduto(rs.getInt("idproduto"));
				ep.setQtd(rs.getInt("qtd"));
				ep.setIdvenda(idvenda);
				
				list.add(ep);
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	protected Vector<Encomenda_produto> getEncomendasByVenda(int idvenda){
		Vector<Encomenda_produto> list = new Vector<Encomenda_produto>();
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from encomenda_produto where idvenda = ? ");
			
			
			ps.setInt(1, idvenda);
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Encomenda_produto ep = new Encomenda_produto();
				
				ep.setIdproduto(rs.getInt("idproduto"));
				ep.setQtd(rs.getInt("qtd"));
				ep.setIdvenda(idvenda);
				//ep.setIdencomenda_produto(rs.getInt(""))
				
				list.add(ep);
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
	}

}
