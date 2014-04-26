package br.edu.utfpr.cm.tsibay.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestPopulaBancoArquivoScript {

    public static String lerArquivo1(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        String conteudo = "";
        try {
            Scanner input = new Scanner(arquivo);
            while (input.hasNextLine()) {
                conteudo += input.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
            conteudo = null;
        }
        return conteudo;
    }

}
