package br.com.Drogaria.Bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Drogaria.Domain.ProdutoDM;
import br.com.Drogaria.Repository.ProdutoRP;
import br.com.Drogaria.Repository.ProdutoSelect;
import br.com.Drogaria.Util.JSFUtil;

@ManagedBean(name="MBProduto")
@ViewScoped
public class ProdutoBean {
	
	private ProdutoDM produtos;
	private List<ProdutoDM> ListProd;
	private List<ProdutoDM> ListProdFiltrados;
	
	public ProdutoDM getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ProdutoDM produtos) {
		this.produtos = produtos;
	}
	
	public List<ProdutoDM> getListProd() {
		return ListProd;
	}
	
	public void setListProd(List<ProdutoDM> listProd) {
		ListProd = listProd;
	}
	
	public List<ProdutoDM> getListProdFiltrados() {
		return ListProdFiltrados;
	}
	
	public void setListProdFiltrados(List<ProdutoDM> listProdFiltrados) {
		ListProdFiltrados = listProdFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa(){
		ProdutoSelect prs = new ProdutoSelect();
		ListProd = prs.listar();
	}
	
	public void prepararNovo(){
		produtos = new ProdutoDM();
	}
	
	public void novo(){
		ProdutoRP rp = new ProdutoRP();
		rp.Insert(produtos);
		ProdutoSelect prs = new ProdutoSelect();
		ListProd = prs.listar();
		JSFUtil.addMensagemSucesso("Registro salvo com sucesso");
	}
	
	public void excluir(){
		ProdutoRP rp = new ProdutoRP();
		rp.Delete(produtos);
		ProdutoSelect prs = new ProdutoSelect();
		ListProd = prs.listar();
		JSFUtil.addMensagemSucesso("Registro removido com sucesso");
	}
	
	public void editar(){
		ProdutoRP rp = new ProdutoRP();
		rp.Update(produtos);
		ProdutoSelect prs = new ProdutoSelect();
		ListProd = prs.listar();	
		JSFUtil.addMensagemSucesso("Registro alterado com sucesso");
	}	
}
