/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsibay.controller;

import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;  
  
import org.primefaces.event.FileUploadEvent;  
/**
 *
 * @author junior
 */
public class FileManager {
  
    public void handleFileUpload(FileUploadEvent event) {  
        
        System.out.println("IMAGEM ENVIADA"+event.getFile().getFileName());
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
} 

