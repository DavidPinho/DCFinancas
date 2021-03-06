package com.dcfinancas.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;




public class BDMySql {

	private static BDMySql singleton = null;
	private Connection con;

	public static BDMySql getInstance() {
		if (singleton == null) {
			singleton = new BDMySql();
		}
		return singleton;
	}

	private BDMySql() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/dcfinancasbd","root","1234");

		} catch (Exception e) {
			//Utilidade.SOP(Mensagem.getMensagem(Mensagem.NAO_FOI_POSSIVEL_CONECTAR_AO_BANCO));
		}
	}
	
	public Connection getConnection(){
		return con;
	}

	
	public void fecharConexao() {
		try {
			con.close();
		} catch (Exception e) {
			//Utilidade.SOP(Mensagem.getMensagem(Mensagem.NAO_FOI_POSSIVEL_FECHAR_A_CONEXAO));
		}

	}
	
	@Override
	protected void finalize() throws Throwable {
		fecharConexao();
		super.finalize();
	}

}
