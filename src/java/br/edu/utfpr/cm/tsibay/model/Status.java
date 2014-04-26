/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.model;

/**
 *
 * @author junior
 */
public enum Status {

    EM_ANDAMENTO("Em andamento"),
    CANCELADO("Cancelado"),
    CONCLUIDO("Concluído");

    public String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
