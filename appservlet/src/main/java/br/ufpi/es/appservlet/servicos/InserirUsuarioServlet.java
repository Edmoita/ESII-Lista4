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

public class InserirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControladorUsuarios controlador;
    
       
    public InserirUsuarioServlet() {
        super();
        controlador = new ControladorUsuarios(LoginServlet.repositorio);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	
    	if (session.getAttribute("usuario") != null) {
    		response.sendRedirect("inserirUsuario.jsp");
    	}else {
    		response.sendRedirect("principal");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("usuario") != null) {
			
			
			int id = controlador.proximoId();
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String senha = request.getParameter("senha");
			
			Usuario novoUsuario = new Usuario();
			
			novoUsuario.setId(id);
			novoUsuario.setNome(nome);
			novoUsuario.setEmail(email);
			novoUsuario.setUsername(username);
			novoUsuario.setSenha(senha);
			
			controlador.insere(novoUsuario);
			
			List<Usuario> lista = controlador.lista();
			
			request.setAttribute("usuarios", lista);
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		}else {
			response.sendRedirect("principal");
		}
	}

}
