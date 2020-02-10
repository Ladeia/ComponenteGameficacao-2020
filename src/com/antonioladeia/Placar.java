package com.antonioladeia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Placar {

	private Armazenamento armazenamento;
	
	public Placar(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}
	
	public void registraPontuacao(String nome, String tipo, int pontuacao) {
		armazenamento.registraPontuacao(nome, tipo, pontuacao);
	}

	public Map<String, Integer> retornaTodosPontosUsuario(String nome) {
		Usuario usuario = armazenamento.getUsuario(nome);
		Map<String, Integer> resultado = new HashMap<String, Integer>();
		
		if(!usuario.getNome().equals("")) {
			List<String> pontuacoes = armazenamento.getTiposPontuacoes(nome);
			
			for(String pontuacao : pontuacoes) {
				resultado.put(pontuacao, armazenamento.retornaPontuacao(nome, pontuacao));
			}
		}
		
		return resultado;
	}

	public Usuario getUsuario(String nome) {
		return armazenamento.getUsuario(nome);
	}

	public List<String> retornaPontosDeUsuario(String nome) {
		return armazenamento.retornaPontosDeUsuario(nome);
	}

	public Map<String, Integer> retornaRankingPontuacaoPorTipo(String tipo) {
		Map<String, Integer> retorno = new HashMap<String, Integer>();
		Map<String, Integer> retornoOrdenado = new HashMap<String, Integer>();

		
		List<Usuario> usuarios = armazenamento.getUsuarios();
		
		for(Usuario usuario : usuarios) {
			Integer pontuacao = armazenamento.retornaPontuacao(usuario.getNome(), tipo);
			if(pontuacao > 0) {
				retorno.put(usuario.getNome(), pontuacao);
			}
		}
		
		retorno.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByKey())
	    .forEachOrdered(x -> retornoOrdenado.put(x.getKey(), x.getValue()));
		
		return retornoOrdenado;
	}
}
