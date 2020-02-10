package com.antonioladeia;

import java.util.ArrayList;
import java.util.List;

public class ArmazenamentoConcreto implements Armazenamento {
	
		List<Usuario> usuarios;

		public ArmazenamentoConcreto() {
			usuarios = new ArrayList<Usuario>();
		}
		
		public void registraPontuacao(String nome, String tipo, int pontuacao) {
		
			Usuario usuario = this.getUsuario(nome);
			
			if(usuario.getNome().equals("")) {
				usuario.setNome(nome);
			}
			
			usuario.adicionarPontuacao(tipo, pontuacao);
					
			this.usuarios.add(usuario);
		}
		
		public Integer retornaPontuacao(String nome, String tipo){
			
			Usuario usuario = this.getUsuario(nome);
			return usuario.getPontuacao(tipo);
		}
		
		public List<String> retornaUsuariosComPontuacao() {
			List<String> retorno = new ArrayList<String>();
			for (Usuario usuario :usuarios){
				if(usuario.temAlgumaPontuacao()) {
					retorno.add(usuario.getNome());
				}
			}
			return retorno;
		}
		
		public Usuario getUsuario(String nome) {
			Usuario retorno = new Usuario("");
			for (Usuario usuario :usuarios){
				if(usuario.temNome(nome)) {
					retorno =  usuario;
				}
			}
			return retorno;
		}
		
		public List<Usuario> getUsuarios() {
			return this.usuarios;
		}

		public List<String> retornaPontosDeUsuario(String nome) {
			Usuario usuario = this.getUsuario(nome);
			return usuario.getTiposPontucoes();
		}

		@Override
		public List<String> getTiposPontuacoes(String nome) {
			Usuario usuario = this.getUsuario(nome);
			return usuario.getTiposPontucoes();
		}

		
}
