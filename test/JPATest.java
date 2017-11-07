/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import atelierjpa.Film;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author Formation
 */
public class JPATest {
    @Test
    public void JPATestAjout() {
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager myEm = myPersistence.createEntityManager();
        myEm.getTransaction().begin();
        
        Film film = new Film("mon titre1 ","Réalisateur 1" , 1978);
        myEm.persist(film);
        
                
        
    }
    
}
