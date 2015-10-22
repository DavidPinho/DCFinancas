package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Tipo_servico;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;


public class ProdutoBD {
	
BDMySql bdMySql = BDMySql.getInstance();
	
	protected int insert(Produto p){
		
		
		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("insert into produto(nome,descricao,quantidade,valor,idfornecedor) values (?,?,?,?,?)");
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setFloat(3, p.getQuantidade());
			ps.setDouble(4,p.getValor());
			ps.setInt(5, p.getIdfornecedor());
			ps.execute();
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	
	}
	
	protected int delete(int idproduto){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("delete from produto where idproduto = ?");
			ps.setInt(1, idproduto);
			ps.execute();
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	
		
	}
	
	
	protected Produto getOne(int idproduto){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from produto where idproduto = ?");
			ps.setInt(1, idproduto);
			ResultSet rs = ps.executeQuery();
			Produto p = new Produto();
			while(rs.next()){
				FornecedorBD f = new FornecedorBD();
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValor(rs.getDouble("valor"));
				p.setDescricao(rs.getString("descricao"));
				p.setIdproduto(rs.getInt("idproduto"));
				p.setIdfornecedor(rs.getInt("idfornecedor"));
				
			}
			
			return p;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected Vector<Produto> getAll(){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from produto");
			ResultSet rs = ps.executeQuery();
			Vector<Produto> all = new Vector();
			
			while(rs.next()){
				
				
				Produto p = new Produto();
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValor(rs.getDouble("valor"));
				p.setDescricao(rs.getString("descricao"));
				p.setIdproduto(rs.getInt("idproduto"));
				p.setIdfornecedor(rs.getInt("idfornecedor"));
				
				
				all.add(p);
				
			}
			
			return all;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected int update(Produto p){
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("update produto set nome = ?, quantidade = ?, valor = ?, descricao = ?, idfornecedor = ? where idproduto = ?");
			ps.setString(1, p.getNome());
			ps.setFloat(2,p.getQuantidade());
			ps.setDouble(3, p.getValor());
			ps.setString(4, p.getDescricao());
			ps.setInt(5, p.getIdfornecedor());
			ps.setInt(6, p.getIdproduto());
			ps.execute();
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
		
	}
	
	 protected Vector<Produto> getPage(int i,String like){
		   Vector<Produto> list = new Vector<Produto>();
		   try {
				PreparedStatement ps = bdMySql
						.getConnection()
						.prepareStatement(
								"select * from produto where descricao like '%"+like+"%' or" +
								" nome like '%"+like+"%' or idfornecedor = (select idfornecedor " +
								"from fornecedor where nome like '%"+like+"%') "+															
								"order by nome limit ?,"+BDUtils.NUM_REG+" ");
				int finalPage=BDUtils.NUM_REG*i;
				int initPage=finalPage-BDUtils.NUM_REG;
				
			
				ps.setInt(1, initPage);
				//ps.setInt(1, finalPage);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Produto p = new Produto();
					p.setNome(rs.getString("nome"));
					p.setQuantidade(rs.getInt("quantidade"));
					p.setValor(rs.getDouble("valor"));
					p.setDescricao(rs.getString("descricao"));
					p.setIdproduto(rs.getInt("idproduto"));
					p.setIdfornecedor(rs.getInt("idfornecedor"));
					
					
					list.add(p);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return list;
	   }
	 
	 protected Vector<Produto> getPageTermino(int i,String like){
		   Vector<Produto> list = new Vector<Produto>();
		   try {
				PreparedStatement ps = bdMySql
						.getConnection()
						.prepareStatement(
								"select * from produto where descricao like '%"+like+"%' or" +
								" nome like '%"+like+"%' or idfornecedor = (select idfornecedor " +
								"from fornecedor where nome like '%"+like+"%') "+															
								"order by quantidade limit ?,"+BDUtils.NUM_REG+" ");
				int finalPage=BDUtils.NUM_REG*i;
				int initPage=finalPage-BDUtils.NUM_REG;
				
			
				ps.setInt(1, initPage);
				//ps.setInt(1, finalPage);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Produto p = new Produto();
					p.setNome(rs.getString("nome"));
					p.setQuantidade(rs.getInt("quantidade"));
					p.setValor(rs.getDouble("valor"));
					p.setDescricao(rs.getString("descricao"));
					p.setIdproduto(rs.getInt("idproduto"));
					p.setIdfornecedor(rs.getInt("idfornecedor"));
					
					
					list.add(p);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return list;
	   }
	   
	   protected int getCount(String like){
			int count=0;
			try {
				PreparedStatement ps=bdMySql.getConnection().prepareStatement("select count(*) as produtos from produto where descricao like '%"+like+"%' or nome like '%"+like+"%' or idfornecedor = (select idfornecedor from fornecedor where nome like '%"+like+"%') ");
				ResultSet rs=ps.executeQuery();
				if(rs.next())
					count=rs.getInt("produtos");
			} catch (SQLException e) {
				
			}
			return count;
			
		}


}
