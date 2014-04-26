/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.daos.DaoComissao;
import br.edu.utfpr.cm.tsibay.daos.DaoGenerics;
import br.edu.utfpr.cm.tsibay.model.Comissao;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author junior
 */
@ManagedBean(name = "comissaoBean")
@RequestScoped
public class ComissaoBean implements Serializable {

    private DaoComissao daoComissao;
    private Comissao comissao;

    public ComissaoBean() {
        this.comissao = new Comissao();
        this.comissao.setData(new Date());
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    public void addComissao() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (comissao.getPorcentagem() <= 50) {
                daoComissao = new DaoComissao();
                daoComissao.persistir(this.comissao);
                this.comissao = new Comissao();
                this.comissao.setData(new Date());

                context.addMessage(null, new FacesMessage("Sucesso", "O valor da comissão foi inserido com sucesso."));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "A porcentagem da comissão não pode ser maior que 50%."));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao gravar"));
            e.printStackTrace();
        }
    }

    public Double getPorcentagemAtual() {
        daoComissao = new DaoComissao();
        return daoComissao.obterComissaoAtual();
    }
}
