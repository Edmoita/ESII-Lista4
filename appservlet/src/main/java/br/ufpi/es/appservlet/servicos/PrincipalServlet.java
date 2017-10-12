package br.ufpi.es.appservlet.servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrincipalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("usuario") != null){
			request.setAttribute("usuario", session.getAttribute("usuario"));
			request.getRequestDispatcher("telaPrincipal.jsp").forward(request, response);
		}else {
			response.sendRedirect("efetuarlogin");
		}
	}

}
