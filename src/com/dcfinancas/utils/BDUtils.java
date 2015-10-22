package com.dcfinancas.utils;

import com.dcfinancas.model.bd.GerenteBD;

public class BDUtils {

	public final static int NUM_REG=40; 
	
	public static void cleanVendas(){
		GerenteBD.getInstance().cleanVendas();
	}
}
