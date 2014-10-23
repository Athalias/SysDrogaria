package br.com.Drogaria.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.Drogaria.Domain.FabricanteDM;
import br.com.Drogaria.Repository.FabricanteRP;
import br.com.Drogaria.Repository.FabricanteSelect;
import br.com.Drogaria.Util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private FabricanteDM fabricante;
	private List<FabricanteDM> itens;
	private List<FabricanteDM> itensFiltrados;
	
	public FabricanteDM getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(FabricanteDM fabricante) {
		this.fabricante = fabricante;
	}
	
	public List<FabricanteDM> getItens() {
		return itens;
	}

	public void setItens(List<FabricanteDM> itens) {
		this.itens = itens;
	}

	public List<FabricanteDM> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<FabricanteDM> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa(){
		FabricanteSelect fbs = new FabricanteSelect();
		itens = fbs.listar();
	}
	
	public void prepararNovo(){
		fabricante = new FabricanteDM();
	}
	
	public void novo(){
		FabricanteRP rp = new FabricanteRP();
		rp.Insert(fabricante);	
		
		FabricanteSelect fbs = new FabricanteSelect();
		itens = fbs.listar();

		JSFUtil.addMensagemSucesso("Registro salvo com Sucesso!"); 
	}

	public void excluir(){
		FabricanteRP rp = new FabricanteRP();
		rp.Delete(fabricante);
		
		FabricanteSelect fbs = new FabricanteSelect();
		itens = fbs.listar();

		JSFUtil.addMensagemSucesso("Registro removido com sucesso");
	}
		
	public void editar(){
		FabricanteRP rp = new FabricanteRP();
		rp.Update(fabricante);
		
		FabricanteSelect fbs = new FabricanteSelect();
		itens = fbs.listar();

		JSFUtil.addMensagemSucesso("Registro alterado com sucesso");
	}
}
