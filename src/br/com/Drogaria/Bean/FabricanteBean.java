package br.com.Drogaria.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.Drogaria.Domain.FabricanteDM;
import br.com.Drogaria.Repository.FabricanteRP;
import br.com.Drogaria.Repository.FabricanteSelect;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private FabricanteDM fabricante;
	private ListDataModel<FabricanteDM> itens;
	
	public FabricanteDM getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(FabricanteDM fabricante) {
		this.fabricante = fabricante;
	}
	
	public ListDataModel<FabricanteDM> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<FabricanteDM> itens) {
		this.itens = itens;
	}

	@PostConstruct
	public void prepararPesquisa(){
		FabricanteSelect fbs = new FabricanteSelect();
		List<FabricanteDM> lista = fbs.listar();
		itens = new ListDataModel<FabricanteDM>(lista);
	}
	
	public void prepararNovo(){
		fabricante = new FabricanteDM();
	}
	
	public void novo(){
		FabricanteRP rp = new FabricanteRP();
		rp.Insert(fabricante);	
		FabricanteSelect fbs = new FabricanteSelect();
		List<FabricanteDM> lista = fbs.listar();
		itens = new ListDataModel<FabricanteDM>(lista);
	}
}
