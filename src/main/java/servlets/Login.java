package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
 * Servlet implementation class Login
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Login() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );	
		
		if (email == null && password == null)
			request.getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );

		else {
			
			List<Tache> tachesUser = new ArrayList<Tache>();
			User connectedUser = null ;
			
	        EntityManagerFactory entityManagerFactory = null;
	        EntityManager em = null;
			HttpSession session = request.getSession( true );

	        
	        try {
	            entityManagerFactory = Persistence.createEntityManagerFactory("usertasks");
	            em = entityManagerFactory.createEntityManager();
	            
	            List<User> users = em.createQuery( "from User", User.class ).getResultList();

	            for (User user : users) {
					
	            	if ( email.equals(user.getEmail()) && password.equals(user.getPassword())) {
	            		connectedUser = user;
	        			session.setAttribute( "connectedUser", connectedUser );
	        			tachesUser = user.getTaches();
	        			session.setAttribute( "error", "");
	        			request.getRequestDispatcher( "/WEB-INF/logged.jsp" ).forward( request, response );
	            	}

				}
	            
	            
	        } finally {
	            if ( em != null ) em.close();
	            if ( entityManagerFactory != null ) entityManagerFactory.close();
	        }
	            
			if (connectedUser == null) {
				session.setAttribute( "error", "mail ou mot de passe incorrect");
				request.getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
			}
			
		}
		
		
	}

}
