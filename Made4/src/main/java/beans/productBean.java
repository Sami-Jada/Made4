/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Products;
import ServiceEJB.productEJB;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Sami Elias Jada
 */
@ManagedBean
@Named("productBean")
@RequestScoped
public class productBean {
    
    private Products product;
    private List<Products> products;
    
    @EJB
    private productEJB productEJB;
    
    public Products getProduct() {
        return product;
    }
    
     public List<Products> getProducts() {
        return products;
    }
    
    @PostConstruct
    public void init() 
    {
        product = new Products();
        products = productEJB.List();
    }
    
    public void save()
    {
        productEJB.create(product);
        init();
    }
    
    
}    
  
