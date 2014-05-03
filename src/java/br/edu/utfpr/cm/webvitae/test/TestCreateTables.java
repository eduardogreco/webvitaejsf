/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.test;

import br.edu.utfpr.cm.webvitae.controller.HibernateConfiguration;

/**
 *
 * @author eduardo
 */
public class TestCreateTables {

    public static void main(String[] args) {
        HibernateConfiguration.createSchema();
    }
}
