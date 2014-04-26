/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.test;

import br.edu.utfpr.cm.tsibay.controller.HibernateConfiguration;

/**
 *
 * @author junior
 */
public class TestCreateTables {

    public static void main(String[] args) {
        HibernateConfiguration.createSchema();
    }
}
