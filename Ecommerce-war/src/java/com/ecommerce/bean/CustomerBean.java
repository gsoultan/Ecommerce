/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.bean;

import com.ecommerce.facade.CustomerFacadeLocal;
import com.ecommerce.model.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    
    private List<Customer> customers=new ArrayList<>();
   
    private Customer customer;
    
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
    
    public List<Customer> getCustomers() {
        customers = customerDao.findAll();
        return customers;
    }
    
    public void submitCustomer(ActionEvent e) {
        try {
            if(this.getCustomer().getId() == 0) { customerDao.create(this.getCustomer()); return;}
            customerDao.edit(this.getCustomer());
        }catch(Exception ex) {
            System.out.print(ex.toString());
        }
    }
    
    public void edit(Customer c){
      this.customer=c;
    }
    
    public void add(ActionEvent e) {
        this.customer=new Customer();
    }
    
    
    
}
