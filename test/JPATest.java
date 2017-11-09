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
        
        Film film1 = new Film("mon titre1 ","Réalisateur 1" , 1911);
        Film film2 = new Film("mon titre2 ","Réalisateur 2" , 1922);
        Film film3 = new Film("mon titre3 ","Réalisateur 3" , 1933);
        Film film4 = new Film("mon titre4 ","Réalisateur 4" , 1944);
        Film film5 = new Film("mon titre5 ","Réalisateur 5" , 1955);
        
        myEm.persist(film1);
        myEm.persist(film2);
        myEm.persist(film3);
        myEm.persist(film4);
        myEm.persist(film5);
        
        //film2.setId(film3.getId());
        //myEm.merge(film2);
        Film filmToSuppress = myEm.find(Film.class, 1L);
        System.err.println("Titre1 = "+filmToSuppress.getTitre());
       //myEm.remove(filmToSuppress);
       //String qlString="UPDATE APP.MESFILMS SET NOM_TITRE='Titre modif' where ID=1";
       myEm.createQuery("UPDATE APP.MESFILMS SET NOM_TITRE='Titre modif' where ID=1").executeUpdate();
       
        myEm.getTransaction().commit();
                
        
    }
    
}



//TRUNCATE TABLE APP.MESFILMS;
//INSERT INTO APP.MESFILMS (ID,ANNEE_DE_SORTIE, NOM_REALISATEUR, NOM_TITRE)
// VALUES
// (1,1234, 'Armand', 'Saint-Didier-des-Bois'),
// (2,4567, 'Hebert', 'Marigny-le-Châtel'),
// (3,7890, 'Ribeiro', 'Maillères'),
// (4,2144, 'Savary', 'Conie-Molitard');
//UPDATE APP.MESFILMS SET NOM_TITRE='Titre modif' where ID=1;
//SELECT * FROM APP.MESFILMS FETCH FIRST 100 ROWS ONLY;