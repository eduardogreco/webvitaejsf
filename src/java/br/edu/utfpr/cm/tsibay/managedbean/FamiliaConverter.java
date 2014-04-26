/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import br.edu.utfpr.cm.tsibay.daos.DaoFamilia;
import br.edu.utfpr.cm.tsibay.daos.DaoGenerics;
import br.edu.utfpr.cm.tsibay.model.Familia;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

/**
 *
 * @author Junior
 */
@ManagedBean(name = "familiaBean")
@FacesConverter("familiaConverter")
@SessionScoped
public class FamiliaConverter implements Converter {

    private static List<Familia> familias;

    public FamiliaConverter() {
        familias = new DaoGenerics<Familia>(Familia.class).listar();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(value);

                for (Familia f : familias) {
                    if (f.getId() == number) {
                        return f;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Familia) value).getId());
        }
    }

    public List<Familia> completaFamilia(String nome) {
        return new DaoFamilia().listar(nome);
    }

    public List<Familia> getFamilias() {
        return new DaoFamilia().listar();
    }
}
