package com.dcfinancas.model.bd;

import java.sql.Date;
import java.util.Vector;

import com.dcfinancas.model.negocio.Cliente;
import com.dcfinancas.model.negocio.Encomenda_produto;
import com.dcfinancas.model.negocio.Fornecedor;
import com.dcfinancas.model.negocio.ItemHistoricoAtendimento;
import com.dcfinancas.model.negocio.Produto;
import com.dcfinancas.model.negocio.Reserva;
import com.dcfinancas.model.negocio.Tipo_servico;
import com.dcfinancas.model.negocio.Venda;

public class GerenteBD {
	
	private static GerenteBD singleton;
	private ClienteBD clienteBD;
	private Tipo_servicoBD tiposervicoBD;
	private ReservaBD reservaBD;
	private HistoricoAtendimentoBD historicoAtendimentoBD;
	private FornecedorBD fornecedorBD;
	private ProdutoBD produtoBD;
	private VendaBD vendaBD;
	private Encomenda_produtoBD encomendaBD;
	
	public static GerenteBD getInstance(){
		if(singleton==null)
			singleton=new GerenteBD();
		
		return singleton;
	}
	
	private GerenteBD(){
		clienteBD=new ClienteBD();
		tiposervicoBD=new Tipo_servicoBD();
		reservaBD=new ReservaBD();
		historicoAtendimentoBD=new HistoricoAtendimentoBD();
		fornecedorBD=new FornecedorBD();
		produtoBD = new ProdutoBD();
		vendaBD=new VendaBD();
		encomendaBD=new Encomenda_produtoBD();
	}
	
	public int insert(Produto p){
		return produtoBD.insert(p);
	}
	
	public int deleteProduto(int id){
		return produtoBD.delete(id);
	}
	
	public Produto getOneProduto(int id){
		return produtoBD.getOne(id);
	}
	
	public Vector<Produto> getAllProdutos(){
		return produtoBD.getAll();
	}
	
	public int update(Produto p){
		return produtoBD.update(p);
	}
	
	public Vector<Produto> getPageProdutos(int i, String like){
		return produtoBD.getPage(i, like);
	}
	
	public Vector<Produto> getPageTermino(int i, String like){
		return produtoBD.getPageTermino(i, like);
	}
	
	public int getCountProdutos(String like){
		return produtoBD.getCount(like);
	}
	
	public int insert(Fornecedor f){
		return fornecedorBD.insert(f);
	}
	
	public int update(Fornecedor f){
		return fornecedorBD.update(f);
	}
	
	public Fornecedor getOneFornecedor(int idfornecedor){
		return fornecedorBD.getOne(idfornecedor);
	}
	
	public Vector<Fornecedor> getAll(){
		return fornecedorBD.getAll();
	}
	
	public int delete(int idfornecedor){
		return fornecedorBD.delete(idfornecedor);
	}
	
	public Vector<Fornecedor> getPageFornecedor(int i, String like){
		return fornecedorBD.getPage(i, like);
	}
	
	public int getCount(String like){
		return fornecedorBD.getCount(like);
	}
	
	public int insert(Cliente c){
		return clienteBD.insert(c);
	}
	
	 public Cliente getOneCliente(int idcliente){
		 return clienteBD.getOne(idcliente);
	 }
	 
	 public int update(Cliente c){
		 return clienteBD.update(c);
	 }
	
	 public Vector<Cliente> getPage(int i,String like){
		 return clienteBD.getPage(i,like);
	 } 
	 
	 public Vector<Cliente>getPageAniversariantes(){
		 return clienteBD.getPageAniversariantes();
	 }
	 
	 public int getCountClientes(String like){
		 return clienteBD.getCount(like);
	 }
	 
	 public int insert(Tipo_servico ts){
		 return tiposervicoBD.insert(ts);
	 }
	 
	 public int update(Tipo_servico ts){
		 return tiposervicoBD.update(ts);
	 }
	 
	 public Tipo_servico getOneTipoServico(int id){
		 return tiposervicoBD.getOne(id);	 
	 }
	 
	 public Vector<Tipo_servico> getPageServico(int i,String like){
		 return tiposervicoBD.getPage(i, like);
	 }
	 
	 public int getCountServico(String like){
		 return tiposervicoBD.getCount(like);
	 }
	 
	 public int deleteServico(int idservico){
		 return tiposervicoBD.delete(idservico);
	 } 
	 
	 public int insert(Reserva r){
		 return reservaBD.insert(r);
	 }
	 
	 public int update(Reserva r){
		 return reservaBD.update(r);
	 }
	 
	 public Reserva getOneReserva(int idreserva){
		 return reservaBD.getOne(idreserva);
	 }
	 
	 public Vector<Reserva> getNextReserva(String like,int i,boolean atendido,Date data){
		 return reservaBD.getNext(like, i, atendido,data);
	 }
	 
	 public int getCountReserva(String like,boolean atendido,Date data){
		 return reservaBD.getCount(like, atendido,data);
	 }
	 
	 public int insert(ItemHistoricoAtendimento i){
		 return historicoAtendimentoBD.insert(i);
	 }
	 
	 public int deleteItemHistoricoAtendimento(int id){
		 return historicoAtendimentoBD.delete(id);
	 }
	 
	 public ItemHistoricoAtendimento getOne(int id){
		 return historicoAtendimentoBD.getOne(id);
	 }
	 
	 public int deleteItemHistoricoAtendimentoByReserva(int id){
		 return historicoAtendimentoBD.deleteByReserva(id);
	 }
	 
	 public Venda initVenda(){
		 return vendaBD.init();
	 }
	 
	 public int insert(Encomenda_produto e){
		 return encomendaBD.insert(e);
	 }
	 
	 public int update(Encomenda_produto e){
		 return encomendaBD.update(e);
	 }
	 
	 public Vector<Encomenda_produto> getPageProdutos(int idvenda,int i){
		 return encomendaBD.getPage(idvenda, i);
	 }
	 
	 
	 public int deleteVenda(int id){
		 encomendaBD.deleteFromVenda(id);
		 return vendaBD.delete(id);
		 
	 }
	 
	 public int update(Venda v){
		 return vendaBD.update(v);
	 }
	 
	 public Vector<Venda> getPageVendas(int i, String like){
		 return vendaBD.getPage(i, like);		 
	 }
	 
	 public Venda getOneVenda(int idVenda){
		 return vendaBD.getOne(idVenda);
	 }
	 
	 public int getCountVendas(String like){
		 return vendaBD.getCount(like);
	 }
	 
	 public int deleteEncomenda(int idvenda,int idproduto){
		 return encomendaBD.delete(idvenda, idproduto);
	 }
	 
	 public int deleteFromVenda(int idvenda){
		 return encomendaBD.deleteFromVenda(idvenda);
	 }

	public void cleanVendas() {
	
		vendaBD.cleanVendas();		
	}
	
	public Vector<Encomenda_produto> getEncomendasByVenda(int idvenda){
		return encomendaBD.getEncomendasByVenda(idvenda);
	}
}
