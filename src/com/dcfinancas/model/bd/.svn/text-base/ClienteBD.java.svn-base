package com.dcfinancas.model.bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.utils.BDUtils;
import com.dcfinancas.utils.Message;
import com.dcfinancas.view.ClienteForm;

public class ClienteBD {

	BDMySql bdMySql = BDMySql.getInstance();

	protected int insert(Cliente c) {

		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"insert into cliente (nome,sobrenome,endereco,data_nascimento,cpf,email,telefone,celular) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getSobrenome());
			ps.setString(3, c.getEndereco());
			ps.setDate(4, c.getData_nascimento());
			ps.setInt(5, c.getCPF());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getTelefone());
			ps.setString(8,c.getCelular());

			ps.execute();

			return Message.SUCCESS_MENSAGE;
			// JOptionPane.showMessageDialog(ClienteForm.getInstance(),
			// "Cliente cadastrado com sucesso!");

		} catch (SQLException e) {
			return Message.ERRO_MENSAGE;
			// JOptionPane.showMessageDialog(ClienteForm.getInstance(),
			// "Erro no cadastro de um cliente", "Error!",
			// JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void delete(int idcliente) {

		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"delete from cliente where idcliente = ?");
			ps.setInt(1, idcliente);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected Cliente getOne(int idcliente) {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from cliente where idcliente = ?");
			ps.setInt(1, idcliente);
			ResultSet rs = ps.executeQuery();
			Cliente c = new Cliente();
			while (rs.next()) {
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getInt("cpf"));
				c.setData_nascimento(rs.getDate("data_nascimento"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));

			}

			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected Vector<Cliente> getAll() {
		try {
			PreparedStatement ps = bdMySql.getConnection().prepareStatement(
					"select * from cliente");
			ResultSet rs = ps.executeQuery();
			Vector<Cliente> all = new Vector<Cliente>();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getInt("cpf"));
				c.setData_nascimento(rs.getDate("data_nascimento"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				
				all.add(c);

			}

			return all;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected int update(Cliente c) {
		try {

			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"update cliente set nome = ?,sobrenome = ?, endereco = ?, cpf = ?, data_nascimento = ? , telefone=?, celular=?,email=? where idcliente = ?");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getSobrenome());
			ps.setString(3, c.getEndereco());
			ps.setInt(4, c.getCPF());
			ps.setDate(5, c.getData_nascimento());
			ps.setString(6, c.getTelefone());
			ps.setString(7, c.getCelular());
			ps.setString(8, c.getEmail());
			ps.setInt(9, c.getIdcliente());
			ps.execute();

			return Message.SUCCESS_MENSAGE;

		} catch (SQLException e) {
			return Message.SUCCESS_MENSAGE;
		}

	}

	protected Vector<Cliente> getPage(int i,String like) {
		Vector<Cliente> list = new Vector<Cliente>();
		try {
			PreparedStatement ps = bdMySql
					.getConnection()
					.prepareStatement(
							"select * from cliente where concat(nome,' ',sobrenome) like '%"+like+"%'  or " +
							"endereco like '%"+like+"%' or " +
							"cpf like '%"+like+"%' or " +
							"email like '%"+like+"%'" +
							"order by nome limit ?,"+BDUtils.NUM_REG+" ");
			int finalPage=BDUtils.NUM_REG*i;
			int initPage=finalPage-BDUtils.NUM_REG;
			
		
			ps.setInt(1, initPage);
			//ps.setInt(2, finalPage);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getInt("cpf"));
				c.setData_nascimento(rs.getDate("data_nascimento"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	protected int getCount(String like){
		int count=0;
		try {
			PreparedStatement ps=bdMySql.getConnection().prepareStatement("select count(*) as clientes from cliente where concat(nome,' ',sobrenome) like '%"+like+"%'  or " +
							"endereco like '%"+like+"%' or " +
							"cpf like '%"+like+"%' or " +
							"email like '%"+like+"%'");
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				count=rs.getInt("clientes");
		} catch (SQLException e) {
			
		}
		return count;
		
	}
	
	protected Vector<Cliente> getPageAniversariantes(){
		Vector<Cliente> list = new Vector();
		try {
			PreparedStatement ps = bdMySql
			.getConnection()
			.prepareStatement(
					"select * from cliente where RIGHT(data_nascimento,5) >= right(curdate(),5)" +
					" order by RIGHT(data_nascimento,5)" );
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Cliente c = new Cliente();
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCPF(rs.getInt("cpf"));
				c.setData_nascimento(rs.getDate("data_nascimento"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				
				list.add(c);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
