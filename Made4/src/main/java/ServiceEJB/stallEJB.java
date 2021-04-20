/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEJB;

import Model.Stall;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

@Stateless
public class stallEJB 
{
    
    @PersistenceContext
    private EntityManager em;
    
    public Stall find(String stallTitle)
    {
        return em.find(Stall.class, stallTitle);
    }
    
    public List<Stall> List()
    {
        return em.createNamedQuery("Stall.findAll", Stall.class).getResultList();
    }
    
    public void create(Stall stall)
    {
        em.persist(stall);
    }
    
    public void update(Stall stall)
    {
        em.merge(stall);
       
    }
    
    public void delete(Stall stall)
    {
        em.remove(em.contains(stall) ? stall : em.merge(stall));
    }   
}
