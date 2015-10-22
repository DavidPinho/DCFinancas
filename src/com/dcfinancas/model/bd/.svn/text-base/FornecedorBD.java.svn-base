package com.dcfinancas.model.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;


public class FornecedorBD {
	
	BDMySql bdMySql = BDMySql.getInstance();
	
	protected int insert(Fornecedor f){
		
		
		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("insert into fornecedor (nome,endereco,email,celular,telefone) values (?,?,?,?,?)");
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEndereco());
			ps.setString(3, f.getEmail());
			ps.setString(4,f.getCelular());
			ps.setString(5,f.getTelefone());
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	
	}
	
	protected int delete(int idfornecedor){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("delete from fornecedor where idfornecedor = ?");
			ps.setInt(1, idfornecedor);
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	
		
	}
	
	
	protected Fornecedor getOne(int idfornecedor){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from fornecedor where idfornecedor = ?");
			ps.setInt(1, idfornecedor);
			ResultSet rs = ps.executeQuery();
			Fornecedor f = new Fornecedor();
			while(rs.next()){
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setCelular(rs.getString("celular"));
				f.setTelefone(rs.getString("telefone"));
				f.setIdfornecedor(rs.getInt("idfornecedor"));
			}
			
			return f;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected Vector<Fornecedor> getAll(){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from fornecedor");
			ResultSet rs = ps.executeQuery();
			Vector<Fornecedor> all = new Vector();
			
			while(rs.next()){
				Fornecedor f = new Fornecedor();
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setCelular(rs.getString("celular"));
				f.setTelefone(rs.getString("telefone"));
				f.setIdfornecedor(rs.getInt("idfornecedor"));
				
				all.add(f);
				
			}
			
			return all;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected int update(Fornecedor f){
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("update fornecedor set nome = ?, endereco = ?, email = ?, celular =?, telefone = ? where idfornecedor = ?");
			ps.setString(1, f.getNome());
			ps.setString(2,f.getEndereco());
			ps.setString(3,f.getEmail());
			ps.setInt(6,f.getIdfornecedor());
			ps.setString(4, f.getCelular());
			ps.setString(5, f.getTelefone());
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
		
	}
	protected Vector<Fornecedor> getPage(int i,String like) {
		Vector<Fornecedor> list = new Vector<Fornecedor>();
		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"select * from fornecedor where nome like '%"+like+"%'  or " +
							"endereco like '%"+like+"%' or " +
							"email like '%"+like+"%' or " +
							"telefone like '%"+like+"%' or " +
							"celular like '%"+like+"%'" +
							"order by nome limit ?,"+BDUtils.NUM_REG+" ");
			int finalPage=BDUtils.NUM_REG*i;
			int initPage=finalPage-BDUtils.NUM_REG;
			
		
			ps.setInt(1, initPage);
			//ps.setInt(2, finalPage);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Fornecedor f = new Fornecedor();
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setEndereco(rs.getString("endereco"));
				f.setCelular(rs.getString("celular"));
				f.setTelefone(rs.getString("telefone"));
				f.setIdfornecedor(rs.getInt("idfornecedor"));
				
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	protected int getCount(String like){
		int count=0;
		try {
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("select count(*) as fornecedores from fornecedor where nome like '%"+like+"%'  or " +
					"endereco like '%"+like+"%' or " +
					"email like '%"+like+"%' or " +
					"telefone like '%"+like+"%' or " +
					"celular like '%"+like+"%'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				count=rs.getInt("fornecedores");
		} catch (SQLException e) {
			
		}
		return count;
		
	}
	
	
	


}
