package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class Ajouter
 */
@WebServlet("/ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Ajouter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/ajout.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tache = request.getParameter("tache");
		HttpSession session = request.getSession(true);

		User connectedUser = (User) session.getAttribute("connectedUser");
		Tache tacheAAjouter = new Tache(tache);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager em = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
			em = entityManagerFactory.createEntityManager();
			
			User user = em.find(User.class, connectedUser.getId_user());
			// on peut récuperer aussi la liste des taches  tachesUser de la session
			//et ajouter la nouvelle tache dans cette liste
			tacheAAjouter.setUser(user);
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			em.persist(tacheAAjouter);
			
			connectedUser.addTache(tacheAAjouter);
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

}
