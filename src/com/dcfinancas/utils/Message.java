package com.dcfinancas.utils;

public class Message {

	public static final int SUCCESS_MENSAGE=0;
	public static final int ERRO_MENSAGE=1;
	public static final int WARRAING_MENSAGE=2;
	
	
	private static final String[] MENSAGES=new String[]{"A��o executada com sucesso!","Ocorreu um erro na execu��o desta a��o!","Aten&ccedil;&atilde;o, algumas tarefas n&atilde;o sairam como esperado!"};
	
	public static String getMensage(int m){
		return MENSAGES[m];
	}
	
}
