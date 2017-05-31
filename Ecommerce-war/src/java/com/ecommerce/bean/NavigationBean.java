/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bean;

import com.ecommerce.facade.CustomerFacadeLocal;
import com.ecommerce.model.Customer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Gembit Soultan
 */
@ManagedBean(name = "navigationBean")
@RequestScoped
public class NavigationBean {
    
    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }
    
    public String goToCustomerInfoForm() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String path = ctx.getExternalContext().getRequestContextPath();
        return path + "/customer/form.xhtml?faces-redirect=true";
    }
    
    public String goToCustomerListForm() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String path = ctx.getExternalContext().getRequestContextPath();
        System.out.print(path);
        return path + "/customer/index.xhtml?faces-redirect=true";
    }
}
