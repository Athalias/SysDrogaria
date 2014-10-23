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
		
		fbrp.Delete(f);
		
		
	}
}
