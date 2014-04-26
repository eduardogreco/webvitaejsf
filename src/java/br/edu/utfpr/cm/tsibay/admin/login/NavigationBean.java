package br.edu.utfpr.cm.tsibay.admin.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	public String redirectLogin() {
		return "/faces/admin/login.xhtml?faces-redirect=true";
	}
	

	public String login() {
		return "/faces/admin/login.xhtml";
	}
	
	/**
	 * Redirect to info page.
	 * @return Info page name.
	 */
	public String redirectCadastro() {
		return "/faces/home.jsp?faces-redirect=true";
	}
	
	public String cadastro() {
		return "/faces/home.jsp";
	}
	
	public String redirectAdmin() {
		return "/faces/admin.xhtml?faces-redirect=true";
	}

	public String admin() {
		return "/faces/admin.xhtml";
	}
	
}
