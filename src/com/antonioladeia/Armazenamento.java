package com.antonioladeia;

import java.util.List;

public interface Armazenamento {
	public void registraPontuacao(String nome, String tipo, int pontuacao);
	
	public Integer retornaPontuacao(String nome, String tipo);

	public List<String> retornaUsuariosComPontuacao();
	
	public List<String> retornaPontosDeUsuario(String nome);
	
	public Usuario getUsuario(String nome);

	public List<String> getTiposPontuacoes(String nome);
	
	public List<Usuario> getUsuarios();
}
