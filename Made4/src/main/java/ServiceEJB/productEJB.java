package ServiceEJB;

import Model.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

@Stateless
public class productEJB {
    
    @PersistenceContext
    private EntityManager em;
    
    public Products find(long productID)
    {
        return em.find(Products.class, productID);
    }
    
    public List<Products> List()
    {
        return em.createNamedQuery("Products.findBystallTitle",Products.class).getResultList();
    }
    
    public void create(Products product)
    {
        em.persist(product);
    }
    
    public void update(Products product)
    {
        em.merge(product);
    }
    
    public void delete(Products product)
    {
        em.remove(em.contains(product) ? product : em.merge(product));
    }
}
