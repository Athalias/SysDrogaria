package br.com.Drogaria.Bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.Drogaria.Domain.FabricanteDM;
import br.com.Drogaria.Repository.FabricanteSelect;
import br.com.Drogaria.Util.JSFUtil;

@ManagedBean(name = "loginBean")
public class LoginBean {

	private String username;

	private String password;
	private FabricanteDM fabricante = new FabricanteDM(); 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public FabricanteDM getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(FabricanteDM fabricante) {
		this.fabricante = fabricante;
	}
	

	public void login(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		//FacesMessage message = null;
		boolean loggedIn = false;

		if (username != null && username.equals("admin") && password != null
				&& password.equals("admin")) {
			loggedIn = true;
			//message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",username);
			JSFUtil.addMensagemSucesso("Seja bem vindo "+username);

		} else {
			loggedIn = false;
			//message = new FacesMessage(FacesMessage.SEVERITY_WARN,
			//		"Loggin Error", "Invalid credentials");
			JSFUtil.addAlertMessage("Login ou senha inválidos");
		}

		//FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}

}
