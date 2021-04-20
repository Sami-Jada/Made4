/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.User;
import ServiceEJB.userEJB;
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
@Named("UserBean")
@RequestScoped
public class userBean {
    
    private User user;
    private String loginPassword;
    private String loginUsername;
    
    @EJB
    private userEJB userEJB;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    
    
    @PostConstruct
    public void init()
    {
        user = new User();
    }
    
    public void save()
    {
        userEJB.create(user);
        init();
    }
    
}
