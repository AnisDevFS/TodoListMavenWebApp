package servlets;

import java.io.IOException;

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
 * Servlet implementation class Supprimer
 */
@WebServlet("/supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Supprimer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_tache = request.getParameter("idTache");
		int idTacheInt = Integer.parseInt(id_tache);
		HttpSession session = request.getSession(true);
		User connectedUser = (User) session.getAttribute("connectedUser");

		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;
		
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
			em = entityManagerFactory.createEntityManager();
			
			Tache tacheASupprimer = em.find(Tache.class, idTacheInt);
			
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			
			em.remove(tacheASupprimer);
			connectedUser.deleteTache(idTacheInt);
			session.setAttribute( "connectedUser", connectedUser);

			trans.commit();
			
			request.getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
