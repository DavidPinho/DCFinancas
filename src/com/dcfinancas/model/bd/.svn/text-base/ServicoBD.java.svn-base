package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Servico;

public class ServicoBD {

	BDMySql bdMySql = BDMySql.getInstance();

	protected void insert(Servico s) {

		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"insert into servico (idvenda, idtipo_servico) values (?,?)");
			ps.setInt(1, s.getIdvenda());
			ps.setInt(2, s.getIdtipo_servico());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void delete(int idservico) {

		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"delete from servico where idservico = ?");
			ps.setInt(1, idservico);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Servico getOne(int idservico) {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from servico where idservico = ?");
			ps.setInt(1, idservico);
			ResultSet rs = ps.executeQuery();
			Servico s = new Servico();
			while (rs.next()) {

				s.setIdservico(rs.getInt("idservico"));
				s.setIdvenda(rs.getInt("idvenda"));
				s.setIdtipo_servico(rs.getInt("idtipo_servico"));

			}

			return s;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Vector<Servico> getAll() {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from servico");
			ResultSet rs = ps.executeQuery();
			Vector<Servico> all = new Vector();

			while (rs.next()) {

				Servico s = new Servico();
				s.setIdservico(rs.getInt("idservico"));
				s.setIdvenda(rs.getInt("idvenda"));
				s.setIdtipo_servico(rs.getInt("idtipo_servico"));

				all.add(s);

			}

			return all;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected void update(Servico s) {
		try {

			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"update servico set idvenda = ?,idtipo_servico = ? where idservico = ?");
			ps.setInt(1, s.getIdvenda());
			ps.setInt(2, s.getIdtipo_servico());
			ps.setInt(3, s.getIdservico());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
