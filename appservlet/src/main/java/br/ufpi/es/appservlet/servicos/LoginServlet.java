package br.ufpi.es.appservlet.servicos;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufpi.es.appservlet.controles.ControladorUsuarios;
import br.ufpi.es.appservlet.dados.RepositorioListaUsuarios;
import br.ufpi.es.appservlet.entidades.Usuario;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static RepositorioListaUsuarios repositorio;
	private ControladorUsuarios controlador;
       
    public LoginServlet() {
        super();
        repositorio = new RepositorioListaUsuarios();
        repositorio.popularRepositorio();
        controlador = new ControladorUsuarios(repositorio);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("usuario") != null){
			response.sendRedirect("principal");
		}else{
			response.sendRedirect("formularioLogin.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		String senha;
		
		username = request.getParameter("username");
		senha = request.getParameter("senha");
		Usuario usuario = controlador.busca(username, senha);
		
		
		if (usuario != null){
			HttpSession session = request.getSession();
			session.setAttribute("email", usuario.getEmail());
			Date criacaoSessaoUsuario = new Date(session.getCreationTime());
			session.setAttribute("usuario", usuario);
			System.out.println("Usuario " + session.getAttribute("email") + " logado as" + criacaoSessaoUsuario);
			response.sendRedirect("principal");
		}else{
			response.sendRedirect("formularioLogin.jsp");
		}
		
	}

}
