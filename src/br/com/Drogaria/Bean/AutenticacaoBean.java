package br.com.Drogaria.Bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import br.com.Drogaria.Domain.UsuarioDM;
import br.com.Drogaria.Repository.UsuarioSelect;
import br.com.Drogaria.Util.JSFUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	private UsuarioDM usuarioLogado;
	
	public UsuarioDM getUsuarioLogado() {
		if(usuarioLogado == null){
			usuarioLogado = new UsuarioDM();
		}
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(UsuarioDM usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public void autenticar(){
		RequestContext context = RequestContext.getCurrentInstance();
		boolean loggedIn = false;
		UsuarioSelect uss = new UsuarioSelect();
		List<UsuarioDM> usuList = uss.listarLogin(usuarioLogado.getLogin(), usuarioLogado.getSenha());
		
		if(usuList.size()==0){
				JSFUtil.addMensagemErro("Login ou Senha inválidos");	
		}else{
			JSFUtil.addMensagemSucesso("Logado com sucesso");
			loggedIn = true;
		}
		context.addCallbackParam("loggedIn", loggedIn);	
	}
}
