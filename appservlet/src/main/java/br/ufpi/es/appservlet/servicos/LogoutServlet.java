package br.ufpi.es.appservlet.servicos;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Date tempoUltimaSessao = new Date(session.getLastAccessedTime());
		System.out.println("Usuário" + session.getAttribute("email") + " deslogado as " + tempoUltimaSessao);
		
		if (session.getAttribute("usuario") != null){
			session.invalidate();
		}
		response.sendRedirect("formularioLogin.jsp");
	}

}
