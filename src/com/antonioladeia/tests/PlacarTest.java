package com.antonioladeia.tests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.antonioladeia.Armazenamento;
import com.antonioladeia.ArmazenamentoConcreto;
import com.antonioladeia.ArmazenamentoMock;
import com.antonioladeia.Placar;

public class PlacarTest {

//	@Test
//	public void armazenaUmaCurtidaMockTest() {
//		
//		Armazenamento armazenamento = new ArmazenamentoMock();
//		Placar placar = new Placar(armazenamento);
//		
//		placar.registraPontuacao("Antonio", "curtida", 1);
//		
//		placar.
//		
//		assertEquals(usuario.temNome("Antonio"), Boolean.TRUE);
//		assertEquals((Integer)usuario.getPontuacao("curtida"), (Integer) 1);
//	}
	
	@Test
	public void retornaTodosPontosUsuarioMockTest() {
		
		Armazenamento armazenamento = new ArmazenamentoMock();
		Placar placar = new Placar(armazenamento);
		
		placar.registraPontuacao("Antonio", "curtida", 1);
		placar.registraPontuacao("Antonio", "vidas", 3);
		placar.registraPontuacao("Antonio", "estrela", 5);
		
		Map<String, Integer> recebido = placar.retornaTodosPontosUsuario("Antonio");
		
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		esperado.put("curtida", 1);
		esperado.put("vidas", 3);
		esperado.put("estrela", 5);
		
		Map<String, Integer> esperadoOrdenado = new HashMap<String, Integer>();
		Map<String, Integer> recebidoOrdenado = new HashMap<String, Integer>();


		esperado.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByKey())
	    .forEachOrdered(x -> esperadoOrdenado.put(x.getKey(), x.getValue()));
		
		recebido.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByKey())
	    .forEachOrdered(x -> recebidoOrdenado.put(x.getKey(), x.getValue()));
		
		assertEquals(recebidoOrdenado, esperadoOrdenado);;
	}
	
	@Test
	public void retornaTodosUsuariosPontuadosMockTest() {
		Armazenamento armazenamento = new ArmazenamentoMock();
		Placar placar = new Placar(armazenamento);
		
		placar.registraPontuacao("luis", "like", 9);
		placar.registraPontuacao("vanessa", "like", 6);
		placar.registraPontuacao("marilia", "like", 3);
		
		Map<String, Integer> recebido = placar.retornaRankingPontuacaoPorTipo("like");
		
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		
		esperado.put("luis", 9);
		esperado.put("vanessa", 6);
		esperado.put("marilia", 3);

		assertEquals(recebido, esperado);;

	}
	
//	public void armazenaUmaCurtidaTest() {
//		
//		Armazenamento armazenamento = new ArmazenamentoConcreto();
//		Placar placar = new Placar(armazenamento);
//		
//		placar.registraPontuacao("Antonio", "curtida", 1);
//		
//		Usuario usuario = placar.getUsuario("Antonio");
//		
//		assertEquals(usuario.temNome("Antonio"), Boolean.TRUE);
//		assertEquals((Integer)usuario.getPontuacao("curtida"), (Integer) 1);
//	}
	
	@Test
	public void retornaTodosPontosUsuarioTest() {
		
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		Placar placar = new Placar(armazenamento);
		
		placar.registraPontuacao("Antonio", "curtida", 1);
		placar.registraPontuacao("Antonio", "vidas", 3);
		placar.registraPontuacao("Antonio", "estrela", 5);
		
		Map<String, Integer> recebido = placar.retornaTodosPontosUsuario("Antonio");
		
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		esperado.put("curtida", 1);
		esperado.put("vidas", 3);
		esperado.put("estrela", 5);
		
		Map<String, Integer> esperadoOrdenado = new HashMap<String, Integer>();
		Map<String, Integer> recebidoOrdenado = new HashMap<String, Integer>();


		esperado.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByKey())
	    .forEachOrdered(x -> esperadoOrdenado.put(x.getKey(), x.getValue()));
		
		recebido.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByKey())
	    .forEachOrdered(x -> recebidoOrdenado.put(x.getKey(), x.getValue()));
		
		assertEquals(recebidoOrdenado, esperadoOrdenado);;
	}
	
	@Test
	public void retornaTodosUsuariosPontuadosTest() {
		Armazenamento armazenamento = new ArmazenamentoConcreto();
		Placar placar = new Placar(armazenamento);
		
		placar.registraPontuacao("luis", "like", 9);
		placar.registraPontuacao("vanessa", "like", 6);
		placar.registraPontuacao("marilia", "like", 3);
		placar.registraPontuacao("marilia", "like", 9);
		
		Map<String, Integer> recebido = placar.retornaRankingPontuacaoPorTipo("like");
		
		Map<String, Integer> esperado = new HashMap<String, Integer>();
		
		esperado.put("luis", 9);
		esperado.put("vanessa", 6);
		esperado.put("marilia", 12);

		assertEquals(recebido, esperado);;

	}
}
