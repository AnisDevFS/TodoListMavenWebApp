package console;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.User;
import entities.Tache;


public class Console {
	

    public static void main(String[] args) throws Exception {
    	
        EntityManagerFactory entityManagerFactory = null;
        EntityManager em = null;

        User seb = new User( "Sebastien", "seb@pop.fr", "0000", 40);
        User anis = new User( "Anis", "anis@pop.fr", "0000", 40);
        
        Tache t1 = new Tache("Acheter du lait");
        Tache t2 = new Tache("Acheter du pain");

        List<Tache> TachesDeSeb = new ArrayList<>();
        TachesDeSeb.add(t1);   TachesDeSeb.add(t2);  
        
        seb.setTaches(TachesDeSeb);
        
        Tache cmd3 = new Tache("Acheter Chaussure de sport");
        Tache cmd4 = new Tache("les chaussures doivent etre des NIKE");

        List<Tache> TachesDeAnis = new ArrayList<>();
        TachesDeAnis.add(cmd3);   TachesDeAnis.add(cmd4);  
        
        anis.setTaches(TachesDeAnis);

        
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
            em = entityManagerFactory.createEntityManager();
            
            EntityTransaction trans = em.getTransaction();

            trans.begin();
            em.persist(seb);
            em.persist(anis);
            trans.commit();

        } finally {
            if ( em != null ) em.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}





























//List<User> Users = em.createQuery( "from User", User.class ).getResultList();
//
//for (User User : Users) {
//	
//  	System.out.println(User);		
//}  
//User sebb= em.find(User.class, 2);
//System.out.println("--------------------");
//System.out.println(sebb);
//em.remove(sebb);
//em.persist(nga);
//em.persist(seb);
//em.persist(anis);
//em.flush();

