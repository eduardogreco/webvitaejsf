/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.controller;

import java.util.List;

/**
 *
 * @author ehrickwilliam
 */
public interface Dao<T> {

    /**
     * Persiste o Elemento na base de dados.
     * @param o Elemento a ser persistido na base.
     * @return False caso nao obteve sucesso. True caso obteve.
     */
     public void persistir(T entidade);

    /**
     * Remove o Elemento da base de dados
     * @param o Elemento a ser removido da base
     * @return False caso nao obteve sucesso. True caso obteve.
     */
    public void remover(T entidade);

    /**
     * Pesquisa um elemento na base de dados
     * @param id Identificador do elemento
     * @return Elemento do identificador recebedido por parametro
     */
    public T obterPorId(int id);

    /**
     * Obtem uma lista de elementos da base de dados
     * @param filtro Faz a filtratem dos elementos a serem obtidos
     * @return Uma lista com todos os elementos obtidos
     */
    public List<T> listar(String filtro);

    /**
     * Obtem uma lista de elementos da base de dados
     * @return Uma lista com todos os elmentos da base
     */
}