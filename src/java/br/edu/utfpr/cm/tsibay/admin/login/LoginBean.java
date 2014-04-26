package br.edu.utfpr.cm.tsibay.admin.login;

import br.edu.utfpr.cm.tsibay.daos.DaoComissao;
import br.edu.utfpr.cm.tsibay.daos.DaoPessoa;
import br.edu.utfpr.cm.tsibay.model.Comissao;
import br.edu.utfpr.cm.tsibay.model.Pessoa;
import br.edu.utfpr.cm.tsibay.model.Telefone;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Simple login bean.
 *
 * @author itcuties
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 7765876811740798583L;
    private String username;
    private String password;
    public static Pessoa usuario;
    private boolean loggedIn = false;
    private static DaoPessoa daoPessoa = new DaoPessoa();
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    /**
     * Login operation.
     *
     * @return
     */
    public String doLogin() {

        if (setPessoa()) {
            if (usuario.getSenha().equals(password)) {
                loggedIn = true;
                DaoComissao daoComissao = new DaoComissao();
                if (daoComissao.listar().isEmpty()) {
                    Comissao c = new Comissao();
                    c.setData(new Date());
                    c.setPorcentagem(5D);
                    daoComissao.persistir(c);
                }
                return navigationBean.redirectAdmin();
            }
        }
//        }

        FacesMessage msg = new FacesMessage("Usuário ou senha incorretos!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.login();

    }

    /**
     * Logout operation.
     *
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
        username = "";
        password = "";
        usuario = null;
        // Set logout message
//		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
////		msg.setSeverity(FacesMessage.SEVERITY_INFO);
//		FacesContext.getCurrentInstance().addMessage(null, msg);

        return navigationBean.login();
    }

    // ------------------------------
    // Getters & Setters 
    private boolean setPessoa() {
        usuario = daoPessoa.obterPorLogin(username);
        if (usuario != null) {
            return true;
        }
        return false;
    }

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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public static Long getIdPessoa() {
        return usuario.getId();
    }

    public String getTipoPessoa() {
        return usuario.getTipo();
    }

    public static void updatePessoa() {
        usuario = daoPessoa.obterPorId(usuario.getId().intValue());
    }

    public void atualizaPerfil() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(usuario.getEmail());
            if (m.matches()) {
                daoPessoa.persistir(usuario);
                context.addMessage(null, new FacesMessage("Sucesso", "Dados atualizados com sucesso"));
            } else {
                updatePessoa();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Endereço de email inválido."));
            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao gravar"));
            e.printStackTrace();
        }
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        LoginBean.usuario = usuario;
    }
}
