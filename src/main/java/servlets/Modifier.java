package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Tache;
import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Modifier
 */
@WebServlet("/modifier")
public class Modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Modifier() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_tache = request.getParameter("idTache");
		int idTacheInt = Integer.parseInt(id_tache);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
			em = entityManagerFactory.createEntityManager();
			
			Tache tacheAModifier = em.find(Tache.class, idTacheInt);
			request.setAttribute("tacheAModifier", tacheAModifier);
			
			request.getRequestDispatcher( "/WEB-INF/modif.jsp" ).forward( request, response );

		} finally {
			if (em != null)
				em.close();
			if (entityManagerFactory != null)
				entityManagerFactory.close();
		}	

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id_tache = request.getParameter("idTache");
		String newText = request.getParameter("tacheAModifier");
		int idTacheInt = Integer.parseInt(id_tache);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;
		HttpSession session = request.getSession(true);


		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
			em = entityManagerFactory.createEntityManager();
			
			Tache tacheAModifier = em.find(Tache.class, idTacheInt);
			tacheAModifier.setTexte(newText);
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(tacheAModifier);

			User user = em.find(User.class, ((User) session.getAttribute("connectedUser")).getId_user());

			trans.commit();
			session.setAttribute( "connectedUser", user);
			
			request.getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );

			
		} finally {
			if (em != null)
				em.close();
			if (entityManagerFactory != null)
				entityManagerFactory.close();
		}
			
	}

}
