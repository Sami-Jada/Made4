/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Model.Stall;
import ServiceEJB.stallEJB;
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
@Named("stallBean")
@RequestScoped
public class stallBean {
    
    private Stall stall;
    private List<Stall> stalls;
    
    @EJB
    private stallEJB stallEJB;
    
    public Stall getStall() {
        return stall;
    }

    public List<Stall> getStalls() {
        return stalls;
    }
    
    @PostConstruct
    public void init()
    {  
         stall = new Stall();
         stalls = stallEJB.List();
    }
        
    public void save()
    {
        stallEJB.create(stall);
        init();
    }

}
