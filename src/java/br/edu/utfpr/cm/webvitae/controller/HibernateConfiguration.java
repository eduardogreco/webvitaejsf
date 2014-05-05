/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.webvitae.controller;

import br.edu.utfpr.cm.webvitae.model.Email;
import br.edu.utfpr.cm.webvitae.model.Endereco;
import br.edu.utfpr.cm.webvitae.model.Experiencia;
import br.edu.utfpr.cm.webvitae.model.Formacao;
import br.edu.utfpr.cm.webvitae.model.Localidade;
import br.edu.utfpr.cm.webvitae.model.Objetivo;
import br.edu.utfpr.cm.webvitae.model.Pessoa;
import br.edu.utfpr.cm.webvitae.model.PessoaVaga;
import br.edu.utfpr.cm.webvitae.model.Telefone;
import br.edu.utfpr.cm.webvitae.model.Vagas;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author eduardo
 */
public class HibernateConfiguration {
    // configuracões somente uma vez 
    // build  valida somente uma vez
    // Session uma sessão para cada transação ou um conjunto de transações

    private static AnnotationConfiguration cfg = null;
    private static SessionFactory factory = null;

    public static SessionFactory getSessionFactory() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/webvitae");
            cfg.setProperty("hibernate.show_sql", "true");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.autocommit", "true");
            cfg.addAnnotatedClass(Endereco.class);
            cfg.addAnnotatedClass(Localidade.class);
            cfg.addAnnotatedClass(Pessoa.class);
            cfg.addAnnotatedClass(Telefone.class);
            cfg.addAnnotatedClass(Experiencia.class);
            cfg.addAnnotatedClass(Objetivo.class);
            cfg.addAnnotatedClass(Formacao.class);
            cfg.addAnnotatedClass(Vagas.class);
            cfg.addAnnotatedClass(Email.class);                                
            cfg.addAnnotatedClass(PessoaVaga.class); 
            
            factory = cfg.buildSessionFactory();// construindo uma fabrica de sessão

        }

        return factory;
    }
    //podemos setar o autocomit como true e nao precisa usar begin tansaction

    public static void createSchema() {
        getSessionFactory().close();
        org.hibernate.tool.hbm2ddl.SchemaExport schemaEx = new SchemaExport(cfg);
        schemaEx.create(true, true);
    }

    public static List<Object> runHQLQuery(String hql) {
        Session session = TransactionManager.getCurrentSession();
        return session.createQuery(hql).list();
    }

    public static Connection getConnection() {
        Session session = TransactionManager.getCurrentSession();
        return session.connection();
    }

    public static Query rHQLQuery(String hql) {
        Session session = TransactionManager.getCurrentSession();
        return session.createQuery(hql);
    }

    public static ArrayList<Class> getEntityClasses() {
        ArrayList<Class> classes = new ArrayList<Class>();

        if (cfg == null) {
            getSessionFactory();
        }

        Iterator i = cfg.getClassMappings();
        while (i.hasNext()) {
            Class mappedClass = ((PersistentClass) i.next()).getMappedClass();
        }
        return classes;
    }
}