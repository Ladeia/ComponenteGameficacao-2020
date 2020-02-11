package com.antonioladeia.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.antonioladeia.Armazenamento;
import com.antonioladeia.ArmazenamentoConcreto;

public class ArmazenamentoTest {
	
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
