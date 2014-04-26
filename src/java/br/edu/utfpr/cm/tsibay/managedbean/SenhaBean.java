/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.admin.login.LoginBean;
import br.edu.utfpr.cm.tsibay.daos.DaoPessoa;
import br.edu.utfpr.cm.tsibay.model.Pessoa;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author junior
 */
@ManagedBean(name = "senhaBean")
@RequestScoped
public class SenhaBean implements Serializable {

    private Pessoa pessoa;
    private String senhaAtual;
    private String senhaNova;
    private String senhaConfirmacao;

    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }
    
    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }

    public void atualizaSenha() {
        DaoPessoa daoPessoa = new DaoPessoa();
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            pessoa = daoPessoa.obterPorId(LoginBean.getIdPessoa().intValue());

            if (pessoa.getSenha().equals(senhaAtual)) {
                if (senhaNova.equals(senhaConfirmacao)) {
                    pessoa.setSenha(senhaNova);
                    daoPessoa.persistir(pessoa);
                    LoginBean.updatePessoa();
                    context.addMessage(null, new FacesMessage("Sucesso", "Senha atualizada com sucesso"));
                }else{
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "A confirmação está incorreta."));
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "A senha atual está incorreta."));
            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao gravar"));
            e.printStackTrace();
        }
    }
}
