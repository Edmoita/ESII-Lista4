package br.ufpi.es.appservlet.controles;

import java.util.List;

import br.ufpi.es.appservlet.dados.IRepositorioUsuarios;
import br.ufpi.es.appservlet.entidades.Usuario;

public class ControladorUsuarios {

	private IRepositorioUsuarios repositorio;
	
	public ControladorUsuarios(IRepositorioUsuarios tipo){
		this.repositorio = tipo;
	}
	
	public void insere(Usuario u){
		repositorio.inserir(u);
	}
	
	public Usuario busca(String username, String senha) {
		return repositorio.buscar(username, senha);
	}
	
	public void altera(Usuario original, Usuario alterado) {
		repositorio.alterar(original, alterado);
	}
	
	public void remove(Usuario u) {
		repositorio.remover(u);
	}
	
	public List<Usuario> lista(){
		return repositorio.listar();
	}
	
	public List<Usuario> buscaPorCampo(String consulta, String campo) {
		return repositorio.buscarPorCampo(consulta, campo);
	}
	
	public Usuario buscaPorId(int id) {
		return repositorio.buscarPorId(id);
	}
	
	public int proximoId() {
		return repositorio.proximoId();
	}
	
}
