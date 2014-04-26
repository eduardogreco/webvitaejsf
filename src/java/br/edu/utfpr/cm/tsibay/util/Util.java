package br.edu.utfpr.cm.tsibay.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marcos
 */
public class Util {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    /**
     * Metodo utilitario que abre um formulario posicionado no centro da tela.
     * @param dialog Objeto de formulario JDialog a abrir centralizado.
     */
    public static void abrirDialogCentralizado(JDialog dialog) {
        dialog.setLocation((dialog.getParent().getWidth() - dialog.getWidth()) / 2,
                (dialog.getParent().getHeight() - dialog.getHeight()) / 2);
        dialog.setVisible(true);
    }

    /**
     * Mostra seletor de arquivo com filtro para imagem e devolve objeto ImageIcon com imagem redimensionada
     * para o tamanho informado.
     * @param larguraParaImagem Largura para a imagem devolvida.
     * @param alturaParaImagem Altura para a imagem devolvida.
     * @return ImageIcon com a imagem redimensionada.
     */
    public static String selecionarIconeParaLabel() {
        // abre seletor de arquivo
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);

        // somente queremos selecionar arquivos, mas nao pastas
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // filtra para somente arquivos de imagem
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de imagens",
                "png", "jpeg", "jpg", "bmp", "gif");
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(true);

        // se houve arquivo valido selecionado
        if (chooser.getSelectedFile() != null) {
            // carrega arquivo de imagem
//            ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
            // redimensiona para o tamanho do JLabelFoto
//            icon.setImage(icon.getImage().getScaledInstance(
//                    larguraParaImagem, alturaParaImagem, Image.SCALE_SMOOTH));
            // colocar imagem icone no label de exibicao no formulario
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    private static int calcularDigito(String str, int[] peso) {

        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    private static boolean isValidCPF(String cpf) {
        if (verificaIgualdade(cpf)) {
            return false;
        }
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    private static boolean isValidCNPJ(String cnpj) {
        if (verificaIgualdade(cnpj)) {
            return false;
        }
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    /**
     * Verifica se existem cadeias de caracters como: 111.111.111-11 ou 
     * 222.222.222-22 onde a verificação do digito seria true.
     * @param str
     * @return boolean
     */
    private static boolean verificaIgualdade(String str) {
        String comp = str.substring(0, 1);
        for (int i = 1; i < str.length(); i++) {
            if (!comp.equals(str.substring(i, (i + 1)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valida um numero de cpf ou cnpj. A string passada deve ser
     * um numero.
     * @param str
     * @return boolean 
     */
    public static boolean isValidCpfCnpj(String str) {
        if (str.length() == 11) {
            return isValidCPF(str);
        } else {
            return isValidCNPJ(str);
        }

    }

    /**
     * Este metodo é responsável por validá as datas, pevenindo que datas como
     * 29/02/2011 não seja aceita, pois 2011 não é ano bicesto.
     * @param String
     * @return boolean
     * @throws ParseException 
     */
    public static boolean isValidDate(String stg) {
         String x = stg.replaceAll("/", "").trim();
        if (x.equals("")) {
            return false;
        }
        String[] dta = stg.split("/");
//        System.out.println(dta.length);
        if (Integer.valueOf(dta[1]) <= 12) {
            int dia = Integer.parseInt(dta[0].trim());
            /*Janeiro é o mês 0(zero) no calenda por isso o -1*/
            int mes = Integer.parseInt(dta[1].trim()) - 1;
            int ano = Integer.parseInt(dta[2].trim());

            Calendar data = new GregorianCalendar(ano, mes, dia);

            if (data.get(Calendar.MONTH) == mes) {
                return true;
            }
        }
        return false;
    }

    public static String padronizaNome(String s) {
        s = s.trim();
        String[] vet = s.split(" ");
        StringBuilder s1 = new StringBuilder();
        String nome1;

        for (int i = 0; i < vet.length; i++) {
            nome1 = vet[i].substring(0, 1).toUpperCase().concat(vet[i].substring(1).toLowerCase());
            s1.append(nome1);
            if (i < (vet.length - 1)) {
                s1.append(" ");
            }
        }
        return s1.toString();
    }

    public static boolean isValidNome(String nome) {
        if (!Pattern.matches("[A-Za-zçéêáãâóõüöô]+(\\s[A-Za-zçéêáãâóõüöô]+)+", nome)) {
            return false;
        }

        return true;
    }

    public static boolean isValidPalavra(String palavra) {
        if (!Pattern.matches("[A-Za-zçéêáãâóõüöô\\s]+", palavra)) {
            return false;
        }

        return true;
    }

    public static String padronizaPalavra(String palavra) {
        return Util.padronizaNome(palavra.replaceAll("\\s+", " ").trim());
    }

    public static boolean isValidaNumero(String numero) {
        if (!Pattern.matches("[0-9]+", numero)) {
            return false;
        }

        return true;
    }

    public static Calendar convertCalendar(String stg) {
        if (!isValidDate(stg)) {
            return null;
        }

        String x = stg.replaceAll("/", "").trim();
        if (x.equals("")) {
            return null;
        }
        String[] dta = stg.split("/");

        int dia = Integer.parseInt(dta[0].trim());
        /*Janeiro é o mês 0(zero) no calenda por isso o -1*/
        int mes = Integer.parseInt(dta[1].trim()) - 1;
        int ano = Integer.parseInt(dta[2].trim());

        Calendar data = new GregorianCalendar(ano, mes, dia);

        if (data.get(Calendar.DAY_OF_MONTH) == dia) {
            return data;
        }
        return null;
    }

    public static String convertDateMySql(String data) {
        data = data.replaceAll("/", "-");
        String dia = data.substring(0, 2);
        String ano = data.substring(6, 10);
        return data.replace(ano, dia).replaceFirst(dia, ano);
    }

    public static boolean isValidPalavraNumero(String palavra) {
        if (!Pattern.matches("[A-Za-zçéêáãâóõüöô\\s0-9]+", palavra)) {
            return false;
        }

        return true;
    }

    public static boolean isValidEmail(String email) {
        if (!Pattern.matches("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})", email)) {
            return false;
        }

        return true;
    }

    public static String convertDateCalender(Calendar date) {
        Date d = date.getTime();
        SimpleDateFormat stm = new SimpleDateFormat("dd/MM/yyyy");
        return stm.format(d);
    }

    public static String getDate() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    public static String getDateSQL(Calendar c) {
        Date data = c.getTime();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(data);
    }

    public static String getDateSQL(Date d) {
        Date data = d;
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(data);
    }

    public static String removeMaskCpfCnpj(String cpf) {
        return cpf.replaceAll("\\.", "").replaceAll("-", "").replaceAll("/", "");
    }

    public static String tiraMaskaraData(String data) {
        data = data.replaceAll("/", "").trim();
        return "".equals(data) ? null : data;
    }
    public static String tiraMaskaraTelefone(String telefone){
        telefone = telefone.replaceAll(" ", "");
        if(telefone.equals("()-")){
            return null;
        }
        return telefone.substring(1, 3).concat(telefone.substring(4, 8)).concat(telefone.substring(9, 13));
    }

    public static String removeMaskTelefone(String t) {
        String tel = t.replaceAll("\\-", "");
        tel = tel.replaceAll("\\s+", "");
        tel = tel.replaceAll("\\(", "");
        tel = tel.replaceAll("\\)", "");
        return tel;
    }

    public static String removeMaskCnpj(String cnpj1) {
        String cnpj = cnpj1.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("\\s+", "");
        cnpj = cnpj.replaceAll("\\/", "");
        cnpj = cnpj.replaceAll("\\-", "");
        return cnpj;
    }

    public static String removeSpace(String text) {
        return text.replaceAll("\\s+", "");
    }
//    public static Telefone parseTelefone(String telefone){
//        String dat1 = telefone.substring(0, 2);
//        String dat2 = telefone.substring(2, 10);
//        return new Telefone(Long.valueOf(dat2), Integer.valueOf(dat1));
//    }
//    public static void main(String[] args) {
//        System.out.println(removeMaskCpfCnpj("12.301.350/0001-77"));
//    }
}
