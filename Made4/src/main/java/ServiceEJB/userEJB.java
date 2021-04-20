/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEJB;

import Model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class userEJB {
    
    @PersistenceContext
    private EntityManager em;
    
    public User find(String username)
    {
        return em.find(User.class, username);
    }
    
    public void create(User user)
    {
        em.persist(user);
    }
    
    public void update(User user)
    {
        em.merge(user);
    }
    
    public void delete(User user)
    {
        em.remove(em.contains(user) ? user : em.merge(user));
    }
    
}
