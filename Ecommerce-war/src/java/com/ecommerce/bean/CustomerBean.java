/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bean;

import com.ecommerce.facade.CustomerFacadeLocal;
import com.ecommerce.model.Customer;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Gembit Soultan
 */
@ManagedBean(name = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {

    @EJB
    private CustomerFacadeLocal customerDao;
   
    private Customer customer=new Customer();
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void submitCustomer(ActionEvent e) {
            if(this.customer.getId() == 0) {
                this.customer = customerDao.create(this.customer);
                System.out.print(this.customer.getId());
            }else {
                customerDao.edit(this.customer);
            }
    }
    
    public String goToInfo() {
        return "info?faces-redirect=true";
    }
}
