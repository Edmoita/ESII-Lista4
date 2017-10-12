package br.ufpi.es.appservlet.dados;

import java.util.List;

import br.ufpi.es.appservlet.entidades.Usuario;

public interface IRepositorioUsuarios {
	
	public void inserir(Usuario u);
	public Usuario buscar(String username, String senha);
	public void alterar(Usuario original, Usuario alterado);
	public void remover(Usuario u);
	public List <Usuario> listar();
	public void popularRepositorio();
	public List<Usuario> buscarPorCampo(String consulta, String campo);
	public Usuario buscarPorId(int id);
	public int proximoId();
	
}
