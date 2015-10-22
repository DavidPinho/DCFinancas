package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Venda;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;


public class VendaBD {


	   BDMySql bdMySql = BDMySql.getInstance();	
		
	   protected void insert(Venda v){
			
			try {
				PreparedStatement ps = bdMySql.getConnection().prepareStatement("insert into venda (data_venda,valor_total,data_pagamento,idcliente) values (now(),?,?,?)");
				ps.setDate(1, v.getData_venda());
				ps.setDouble(2, v.getValor_total());
				ps.setDate(3, v.getData_pagamento());
				ps.setInt(4, v.getIdcliente());
				ps.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	   
	   protected Venda init(){
			
			try {
				PreparedStatement ps = bdMySql.getConnection().prepareStatement("insert into venda (data_venda) values (now())");
				
				ps.execute();
				
				ResultSet rs=bdMySql.getConnection().createStatement().executeQuery("select max(idvenda) as id from venda");
				Venda v=null;
				if(rs.next()){
					v=getOne(rs.getInt("id"));
				}
				
				return v;
				
			} catch (SQLException e) {
				return null;
			}
			
			
		}
	   
	   protected int delete(int idvenda){
		   
		   try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("delete from venda where idvenda = ?");
			ps.setInt(1, idvenda);
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	   }
	   
	   protected Venda getOne(int idvenda){
		   try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from venda where idvenda = ?");
			ps.setInt(1, idvenda);
			ResultSet rs = ps.executeQuery();
			Venda v = new Venda();
			while(rs.next()){
				v.setData_pagamento(rs.getDate("data_pagamento"));
				v.setData_venda(rs.getDate("data_venda"));
				v.setIdcliente(rs.getInt("idcliente"));
				v.setIdvenda(rs.getInt("idvenda"));
				v.setValor_total(rs.getDouble("valor_total"));
				
					
			}
			
			return v;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	   }
	   
	   protected Vector<Venda> getAll(){
		   try {
				PreparedStatement ps = bdMySql.getConnection().prepareStatement("select * from venda");
			    ResultSet rs = ps.executeQuery();
			    Vector<Venda> all = new Vector();
			
				while(rs.next()){
					
					Venda v = new Venda();
					v.setData_pagamento(rs.getDate("data_pagamento"));
					v.setData_venda(rs.getDate("data_venda"));
					v.setIdcliente(rs.getInt("idcliente"));
					v.setIdvenda(rs.getInt("idvenda"));
					v.setValor_total(rs.getDouble("valor_total"));	
					all.add(v);
						
				}
				
				return all;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		   
	   }
	   
	   protected int update(Venda v){
		   try {
			
			   PreparedStatement ps = bdMySql.getConnection().prepareStatement("update venda set data_venda = ?,valor_total = ?, data_pagamento = ?, idcliente = ? where idvenda = ?");
			   ps.setDate(1, v.getData_venda());
			   ps.setDouble(2, v.getValor_total());
			   ps.setDate(3,v.getData_pagamento());
			   ps.setInt(4,v.getIdcliente());
			   ps.setInt(5,v.getIdvenda());
			   
			   ps.execute();
			   
			   return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
		   
	   }
	   
	   protected Vector<Venda> getPage(int i,String like){
		   Vector<Venda> list = new Vector<Venda>();
		   try {
				PreparedStatement ps = bdMySql
						.getConnection()
						.prepareStatement(
								"select * from venda where data_venda like '%"+like+"%' or" +
								" idcliente in (select idcliente " +
								"from cliente where nome like '%"+like+"%') "+															
								"order by data_venda desc limit ?,"+BDUtils.NUM_REG+" ");
				int finalPage=BDUtils.NUM_REG*i;
				int initPage=finalPage-BDUtils.NUM_REG;
				
			
				ps.setInt(1, initPage);
				//ps.setInt(1, finalPage);
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Venda v = new Venda();
					v.setData_pagamento(rs.getDate("data_pagamento"));
					v.setData_venda(rs.getDate("data_venda"));
					v.setIdcliente(rs.getInt("idcliente"));
					v.setIdvenda(rs.getInt("idvenda"));
					v.setValor_total(rs.getDouble("valor_total"));
					
					
					list.add(v);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   return list;
	   }
	   
	   protected int getCount(String like){
			int count=0;
			try {
				PreparedStatement ps=bdMySql.getConnection().prepareStatement("select count(*) as vendas from venda where data_venda like '%"+like+"%' or" +
								" idcliente in (select idcliente from cliente where nome like '%"+like+"%')");
				ResultSet rs=ps.executeQuery();
				if(rs.next())
					count=rs.getInt("vendas");
			} catch (SQLException e) {
				
			}
			return count;
			
		}

	   
	  protected void cleanVendas(){
		  try {
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("select *  from venda where valor_total is null");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GerenteBD.getInstance().deleteFromVenda(rs.getInt("idvenda"));
			}
			ps=bdMySql.getConnection().prepareStatement("delete  from venda where valor_total is null");
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
