package com.antonioladeia.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.antonioladeia.Armazenamento;
import com.antonioladeia.ArmazenamentoConcreto;
import com.antonioladeia.Usuario;

public class ArmazenamentoTest {

	@Test
	public void armazenaUmaCurtidaTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		armazenamento.registraPontuacao("Antonio", "curtida", 1);
		
		Usuario usuario = armazenamento.getUsuario("Antonio");
		
		assertEquals(usuario.temNome("Antonio"), Boolean.TRUE);
		assertEquals((Integer)usuario.getPontuacao("curtida"), (Integer) 1);
	}
	
	@Test
	public void armazenaMaisDeUmaCurtidaTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		armazenamento.registraPontuacao("Antonio", "curtida", 1);
		armazenamento.registraPontuacao("Antonio", "curtida", 5);

		
		Usuario usuario = armazenamento.getUsuario("Antonio");
		
		assertEquals(usuario.temNome("Antonio"), Boolean.TRUE);
		assertEquals((Integer)usuario.getPontuacao("curtida"), (Integer) 6);
	}
	
	@Test
	public void retornaQuantidadeCurtidasTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		armazenamento.registraPontuacao("Antonio", "curtida", 10);
		
		assertEquals((Integer) armazenamento.retornaPontuacao("Antonio", "curtida"), (Integer) 10);
	}
	
	@Test
	public void retornaTodosUsuariosComPontosTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		armazenamento.registraPontuacao("Antonio", "curtida", 10);
		armazenamento.registraPontuacao("Vanessa", "curtida", 5);
		armazenamento.registraPontuacao("Marilia", "estrela", 15);

		List<String> esperado = new ArrayList<String>();
		esperado.add("Antonio");
		esperado.add("Vanessa");
		esperado.add("Marilia");
		
		assertEquals(armazenamento.retornaUsuariosComPontuacao(), esperado);
	}
	
	@Test
	public void retornaTodosPontosDeUmUsuarioTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		armazenamento.registraPontuacao("Antonio", "curtida", 10);
		armazenamento.registraPontuacao("Antonio", "like", 5);
		armazenamento.registraPontuacao("Antonio", "deslike", 15);

		List<String> esperado = new ArrayList<String>();
		esperado.add("curtida");
		esperado.add("like");
		esperado.add("deslike");
		
		List<String> recebido = armazenamento.retornaPontosDeUsuario("Antonio");
		java.util.Collections.sort(recebido);
		java.util.Collections.sort(esperado);
		
		assertEquals(recebido, esperado);
	}
	
}
