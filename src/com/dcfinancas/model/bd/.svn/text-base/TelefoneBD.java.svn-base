package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Telefone;


public class TelefoneBD {
	
	 BDMySql bdMySql = BDMySql.getInstance();	
		
	   protected void insert(Telefone t){
			
			try {
				PreparedStatement ps = bdMySql.getConnection().prepareStatement("insert into telefone (numero) values (?)");
				ps.setString(1, t.getNumero());
				
				ps.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	   
	   protected void delete(int idtelefone){
		   
		   try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("delete from telfone where idtelefone = ?");
			ps.setInt(1, idtelefone);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   protected Telefone getOne(int idtelefone){
		   try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from telefone where idtelefone = ?");
			ps.setInt(1, idtelefone);
			ResultSet rs = ps.executeQuery();
			Telefone t = new Telefone();
			while(rs.next()){
				
				t.setIdcliente(rs.getInt("idcliente"));
				t.setIdfornecedor(rs.getInt("idfornecedor"));
				t.setIdtelefone(rs.getInt("idtelefone"));
				t.setNumero(rs.getString("numero"));		
			}
			
			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	   }
	   
	   protected Vector<Telefone> getAll(){
		   try {
				PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from telefone");
			    ResultSet rs = ps.executeQuery();
			    Vector<Telefone> all = new Vector();
			
				while(rs.next()){
					Telefone t = new Telefone();
					t.setIdcliente(rs.getInt("idcliente"));
					t.setIdfornecedor(rs.getInt("idfornecedor"));
					t.setIdtelefone(rs.getInt("idtelefone"));
					t.setNumero(rs.getString("numero"));
					all.add(t);
						
				}
				
				return all;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		   
	   }
	   
	   protected void update(Telefone t){
		   try {
			
			   PreparedStatement ps = bdMySql.getConnection().prepareStatement("update telefone set numero = ? where idtelefone = ?");
			   ps.setString(1, t.getNumero());
			   ps.setInt(2,t.getIdtelefone());
			   ps.execute();
			   
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }

}
