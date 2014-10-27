package br.com.Drogaria.Util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.Drogaria.Domain.FabricanteDM;
import br.com.Drogaria.Repository.FabricanteSelect;

@FacesConverter(value="TabConverter")
public class TableConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		FabricanteSelect fbs = new FabricanteSelect();
		FabricanteDM fab = new FabricanteDM();
		List<FabricanteDM> lstFabricante = fbs.listarByName(arg2);  
		
		for(FabricanteDM fbdm :lstFabricante){
	
			fab = fbdm; 
			}
			return fab; 
		}
		//FabricanteDM fabricante = (FabricanteDM) lstFabricante;
		
	

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		FabricanteDM fabricante = new FabricanteDM();
		fabricante = (FabricanteDM) arg2;
		return fabricante.getDescricao();
	}
	
	

}
