package com.antonioladeia;

import java.util.ArrayList;
import java.util.List;

public class ArmazenamentoMock implements Armazenamento{

	@Override
	public void registraPontuacao(String nome, String tipo, int pontuacao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer retornaPontuacao(String nome, String tipo) {
		if(nome.equals("luis") && tipo.equals("like")) {
			return 9;
		} else if(nome.equals("vanessa") && tipo.equals("like")) {
			return 6;
		} else if(nome.equals("marilia") && tipo.equals("like")) {
			return 3;
		} else if(tipo.equals("curtida")) {
			return 1;
		} else if(tipo.equals("vidas")) {
			return 3;
		} else {
			return 5;
		}
	}

	@Override
	public List<String> retornaUsuariosComPontuacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> retornaPontosDeUsuario(String nome) {
		List<String> retorno = new ArrayList<String>();
		retorno.add("curtida");
		retorno.add("vidas");
		retorno.add("estrela");
		return retorno;
	}

//	@Override
//	public Usuario getUsuario(String nome) {
//		Usuario usuario = new Usuario(nome);
//		usuario.adicionarPontuacao("curtida", 1);
//		return usuario;
//	}
//
//	@Override
//	public List<String> getTiposPontuacoes(String nome) {
//		List<String> retorno = new ArrayList<String>();
//		retorno.add("curtida");
//		retorno.add("vidas");
//		retorno.add("estrela");
//		return retorno;
//	}

	@Override
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario antonio = new Usuario("luis");
		Usuario vanessa = new Usuario("vanessa");
		Usuario marilia = new Usuario("marilia");
		
		antonio.adicionarPontuacao("like", 9);
		vanessa.adicionarPontuacao("like", 6);
		marilia.adicionarPontuacao("like", 3);

		usuarios.add(antonio);
		usuarios.add(vanessa);
		usuarios.add(marilia);
		
		return usuarios;
	}

}
