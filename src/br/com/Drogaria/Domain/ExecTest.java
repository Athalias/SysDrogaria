package br.com.Drogaria.Domain;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.Drogaria.Repository.FabricanteRP;
import br.com.Drogaria.Repository.GenericRepo;
import br.com.Drogaria.Repository.ProdutoRP;

public class ExecTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FabricanteDM f = new FabricanteDM();
		ProdutoDM pr = new ProdutoDM();
		FabricanteRP fbrp = new FabricanteRP();
		ProdutoRP prp = new ProdutoRP();
		f.setCodigo(23);
		f.setDescricao("Fabricante 03 generic");
		//pr.setCodigo(4);
		pr.setDescricao("Produto 04 para SELECT");
		pr.setQuantidade(20);
		pr.setPreco(5.50);
		pr.setCodigoFabricante(f);
		prp.Insert(pr);
		
		
		List<ProdutoDM> getProdList = prp.Select();
		
		for(ProdutoDM pro : getProdList ){
			
			JOptionPane.showMessageDialog(null, pro.getDescricao());
			
		}
		
	}
}
