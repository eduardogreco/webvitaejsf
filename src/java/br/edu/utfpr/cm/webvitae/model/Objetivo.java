/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author eduardogreco
 */
@Entity
@Table(name = "OBJETIVO")
public class Objetivo implements Serializable {

    @ManyToOne
    private Pessoa pessoa;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String principal;
    private String secundario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getSecundario() {
        return secundario;
    }

    public void setSecundario(String secundario) {
        this.secundario = secundario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
