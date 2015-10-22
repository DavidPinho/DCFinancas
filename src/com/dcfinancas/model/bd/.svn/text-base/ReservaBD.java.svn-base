package com.dcfinancas.model.bd;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.dcfinancas.model.bd.BDMySql;
import com.dcfinancas.model.negocio.Reserva;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;

public class ReservaBD {
	
BDMySql bdMySql = BDMySql.getInstance();
	
	protected int insert(Reserva r){
		
		
		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("insert into reserva(hora,data,idcliente,idtipo_servico) values (?,?,?,?)");
			ps.setTime(1, r.getHora());
			ps.setDate(2, r.getData());
			ps.setInt(3, r.getIdcliente());
			ps.setInt(4,r.getIdtipo_servico());
			
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	
	}
	
	protected void delete(int idreserva){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("delete from reserva where idreserva = ?");
			ps.setInt(1, idreserva);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	protected Reserva getOne(int idreserva){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from reserva where idreserva = ?");
			ps.setInt(1, idreserva);
			ResultSet rs = ps.executeQuery();
			Reserva r = new Reserva();
			while(rs.next()){
				
				r = new Reserva();
				r.setHora(rs.getTime("hora"));
				r.setData(rs.getDate("data"));
				r.setIdtipo_servico(rs.getInt("idtipo_servico"));
				r.setIdcliente(rs.getInt("idcliente"));
				r.setIdreserva(rs.getInt("idreserva"));
				r.setAtendido(rs.getBoolean("atendido"));
				
			}
			
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected Vector<Reserva> getAll(){

		try {
			PreparedStatement ps;
			ps = bdMySql.getConnection().prepareStatement("select * from reserva");
			ResultSet rs = ps.executeQuery();
			Vector<Reserva> all = new Vector<Reserva>();
			
			while(rs.next()){
				
				Reserva r = new Reserva();
				r.setHora(rs.getTime("hora"));
				r.setData(rs.getDate("data"));
				r.setIdtipo_servico(rs.getInt("idtipo_servico"));
				r.setIdcliente(rs.getInt("idcliente"));
				r.setIdreserva(rs.getInt("idreserva"));
				r.setAtendido(rs.getBoolean("atendido"));
				
				
				
				all.add(r);
				
			}
			
			return all;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	protected int update(Reserva r){
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement("update reserva set hora = ?, data = ?, idcliente = ?, idtipo_servico = ?, atendido=? where idreserva = ?");
			ps.setTime(1, r.getHora());
			ps.setDate(2, r.getData());
			ps.setInt(3, r.getIdcliente());
			ps.setInt(4,r.getIdtipo_servico());
			ps.setBoolean(5, r.isAtendido());
			ps.setInt(6, r.getIdreserva());
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
		
	}
	
	protected Vector<Reserva> getNext(String like,int i,boolean atendido,Date data){
		Vector<Reserva> all=new Vector<Reserva>();
		try {
			PreparedStatement ps = bdMySql
			.getConnection()
			.prepareStatement(
					"select * from reserva inner join cliente on reserva.idcliente=cliente.idcliente " +
					"where concat(cliente.nome,' ',cliente.sobrenome) like '%"+like+"%' " +
					"and reserva.atendido=? and data=?" +
					"order by reserva.hora,reserva.data limit ?,"+BDUtils.NUM_REG+" ");
		
		int finalPage=BDUtils.NUM_REG*i;
		int initPage=finalPage-BDUtils.NUM_REG;
		
		ps.setBoolean(1, atendido);
		ps.setDate(2, data);
		ps.setInt(3, initPage);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			
			Reserva r = new Reserva();
			r.setHora(rs.getTime("hora"));
			r.setData(rs.getDate("data"));
			r.setIdtipo_servico(rs.getInt("idtipo_servico"));
			r.setIdcliente(rs.getInt("idcliente"));
			r.setIdreserva(rs.getInt("idreserva"));
			r.setAtendido(rs.getBoolean("atendido"));
			
			
			all.add(r);
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
	
	protected int getCount(String like,boolean atendido,Date data){
		int count=0;
		try {
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("select count(*) as reservas from reserva inner join cliente on reserva.idcliente=cliente.idcliente " +
					"where concat(cliente.nome,' ',cliente.sobrenome) like '%"+like+"%' " +
					"and reserva.atendido=? and data=?");
			ps.setBoolean(1, atendido);
			ps.setDate(2, data);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				count=rs.getInt("reservas");
		} catch (SQLException e) {
			
		}
		return count;
		
	}


}
