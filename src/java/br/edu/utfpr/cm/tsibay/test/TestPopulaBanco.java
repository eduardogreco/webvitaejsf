package br.edu.utfpr.cm.tsibay.test;

import br.edu.utfpr.cm.tsibay.controller.HibernateConfiguration;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestPopulaBanco {

    public static void main(String[] args) throws SQLException {

        Connection com = HibernateConfiguration.getConnection();
        com.setAutoCommit(false);
    
        // leitura do arquivo com script sql
        String arquivo = TestPopulaBancoArquivoScript.lerArquivo1("ScriptPopulacaoBanco.sql");
        String[] listaComandoSql = arquivo.split(";");
        String comandoSql = "";
        for (int i = 0; i < listaComandoSql.length - 1; i++) {
            comandoSql = (listaComandoSql[i] + ";");
            // execução dos comandos sql
            PreparedStatement pst = (PreparedStatement) com.prepareStatement(comandoSql);
            pst.executeUpdate(comandoSql);
        }
        
        com.commit();
      
    }
}