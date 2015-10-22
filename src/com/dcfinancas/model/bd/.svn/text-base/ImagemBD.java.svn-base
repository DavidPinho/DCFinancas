package com.dcfinancas.model.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Imagem;
import com.dcfinancas.model.negocio.Produto;


public class ImagemBD {
	
	BDMySql bd = BDMySql.getInstance();
	
	protected void insert(Imagem i){
		
		
		try {
			PreparedStatement ps;
			ps = bd.getConnection().prepareStatement("insert into imagem (imagem,idproduto) values (?,?)");
			ps.setString(1,i.getImagem());
			ps.setInt(2, i.getIdproduto());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	protected void delete(int idimagem){

		try {
			PreparedStatement ps;
			ps = bd.getConnection().prepareStatement("delete from imagem where idimagem = ?");
			ps.setInt(1, idimagem);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	protected Imagem getOne(int idimagem){

		try {
			PreparedStatement ps;
			ps = bd.getConnection().prepareStatement("select * from imagem where idimagem = ?");
			ps.setInt(1, idimagem);
			ResultSet rs = ps.executeQuery();
			Imagem i = new Imagem();
			while(rs.next()){
				i.setImagem(rs.getString("imagem"));
				i.setIdproduto(rs.getInt("idproduto"));
			}
			
			return i;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected Vector<Imagem> getAll(){

		try {
			PreparedStatement ps;
			ps = bd.getConnection().prepareStatement("select * from imagem");
			ResultSet rs = ps.executeQuery();
			Vector<Imagem> all = new Vector();
			
			while(rs.next()){
				Imagem i = new Imagem();
				i.setImagem(rs.getString("imagem"));
				i.setIdproduto(rs.getInt("idproduto"));
				
				all.add(i);
				
			}
			
			return all;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected void update(Imagem i){
		try {
			PreparedStatement ps = bd.getConnection().prepareStatement("update imagem set imagem = ?, idproduto = ? where idimagem = ?");
			ps.setString(1, i.getImagem());
			ps.setInt(2,i.getIdproduto());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
