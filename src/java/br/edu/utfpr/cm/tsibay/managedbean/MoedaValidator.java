/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.managedbean;

import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("MoedaValidator")
public class MoedaValidator implements Validator {

    /**
     * Método responsável por validar os campos com moeda. Caso ocorra algum
     * erro lança uma ValidatorException.
     */
    public void validate(FacesContext ctx, UIComponent comp, Object val) throws ValidatorException {

        if (val == null) {
            return;
        }

        if (val instanceof Long) {
            Long valor = (Long) val;
            if (valor.intValue() == 0) {
                FacesMessage message = new FacesMessage("Preencha com o valor válido maior que zero");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } else {
            Double valor = (Double) val;
            if (valor.intValue() == 0) {
                FacesMessage message = new FacesMessage("Preencha com o valor válido maior que zero");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }



    }
}
