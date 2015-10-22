package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Tipo_servico;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;

public class Tipo_servicoBD {

	BDMySql bdMySql = BDMySql.getInstance();

	protected int insert(Tipo_servico ts) {

		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"insert into tipo_servico (descricao,preco) values (?,?)");
			ps.setString(1, ts.getDescricao());
			ps.setDouble(2, ts.getPreco());

			ps.execute();

			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}

	}

	protected int delete(int idtipo_servico) {

		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"delete from tipo_servico where idtipo_servico = ?");
			ps.setInt(1, idtipo_servico);
			ps.execute();
			
			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
		}
	}

	protected Tipo_servico getOne(int idtipo_servico) {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from tipo_servico where idtipo_servico = ?");
			ps.setInt(1, idtipo_servico);
			ResultSet rs = ps.executeQuery();
			Tipo_servico ts = new Tipo_servico();
			while (rs.next()) {
				ts.setDescricao(rs.getString("descricao"));
				ts.setPreco(rs.getDouble("preco"));
				ts.setIdtipo_servico(rs.getInt("idtipo_servico"));

			}

			return ts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Vector<Tipo_servico> getAll() {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from tipo_servico");
			ResultSet rs = ps.executeQuery();
			Vector<Tipo_servico> all = new Vector();

			while (rs.next()) {
				Tipo_servico ts = new Tipo_servico();
				ts.setDescricao(rs.getString("descricao"));
				ts.setPreco(rs.getDouble("preco"));
				ts.setIdtipo_servico(rs.getInt("idtipo_servico"));
				all.add(ts);

			}

			return all;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected int update(Tipo_servico ts) {
		try {

			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"update tipo_servico set descricao = ?,preco = ? where idtipo_servico = ?");
			ps.setString(1, ts.getDescricao());
			ps.setDouble(2, ts.getPreco());
			ps.setInt(3, ts.getIdtipo_servico());
			ps.execute();

			return Message.SUCCESS_MENSAGE;
		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
			// e.printStackTrace();
		}

	}

	protected Vector<Tipo_servico> getPage(int i, String like) {
		Vector<Tipo_servico> list = new Vector<Tipo_servico>();
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from tipo_servico where descricao like '%" + like
							+ "%' " + "order by descricao limit ?,"
							+ BDUtils.NUM_REG + " ");
			int finalPage = BDUtils.NUM_REG * i;
			int initPage = finalPage - BDUtils.NUM_REG;

			ps.setInt(1, initPage);
			// ps.setInt(1, finalPage);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tipo_servico ts = new Tipo_servico();
				ts.setDescricao(rs.getString("descricao"));
				ts.setPreco(rs.getDouble("preco"));
				ts.setIdtipo_servico(rs.getInt("idtipo_servico"));

				list.add(ts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	protected int getCount(String like) {
		int count = 0;
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select count(*) as clientes from tipo_servico where descricao like '%"
							+ like + "%'");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				count = rs.getInt("clientes");
		} catch (SQLException e) {

		}
		return count;

	}

}
