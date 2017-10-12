package br.ufpi.es.appservlet.servicos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufpi.es.appservlet.controles.ControladorUsuarios;
import br.ufpi.es.appservlet.entidades.Usuario;

public class ListarUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControladorUsuarios controlador;
       
    public ListarUsuariosServlet() {
        super();
        controlador = new ControladorUsuarios(LoginServlet.repositorio);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("usuario") != null) {
			List<Usuario> lista = controlador.lista();
			
			request.setAttribute("usuarios", lista);
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}else {
			response.sendRedirect("principal");
		}
	}

}
