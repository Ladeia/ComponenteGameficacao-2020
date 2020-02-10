package com.antonioladeia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	private String usuario;
	private Map<String, Integer> placar;
	
	public Usuario(String usuario) {
		this.usuario = usuario;
		this.placar = new HashMap<String, Integer>();
	}
	
	public void adicionarPontuacao(String tipo, Integer pontuacao) {
		if(placar.containsKey(tipo)) {
			placar.put(tipo, placar.get(tipo) + pontuacao);
		} else {
			placar.put(tipo, pontuacao);
		}
	}
	
	public String getNome() {
		return this.usuario;
	}
	
	public Boolean temNome(String nome) {
		if(nome.equals(this.usuario)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	public Integer getPontuacao(String tipo){
		if(placar.containsKey(tipo)) {
			return placar.get(tipo);
		} else {
			return 0;
		}
	}

	public Boolean temAlgumaPontuacao() {
		if(placar.size() >= 0) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	public void setNome(String nome) {
		this.usuario = nome;
	}
	
	public List<String> getTiposPontucoes() {
		List<String> retorno = new ArrayList<String>();
		retorno.addAll(placar.keySet());
		
		return retorno;
	}
	
}
