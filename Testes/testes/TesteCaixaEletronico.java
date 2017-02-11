package testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.CaixaEletronico;
import classes.ContaCorrente;
import mock.MockServicoRemoto;

public class TesteCaixaEletronico {
	CaixaEletronico ce;
	ContaCorrente cc, cc2;
	MockServicoRemoto sr;
	
	@Before
	public void inicializa() {
		sr = new MockServicoRemoto();
		ce = new CaixaEletronico();
		cc = new ContaCorrente("100.000", 500);
		sr.setConta(cc);
		cc2 = new ContaCorrente("500.000", 150);
		sr.setConta(cc2);
		
	}
	
	@Test
	public void testRecuperarUmaConta(){
		ContaCorrente rec;
		rec = sr.recuperarConta("100.000");
		assertEquals(cc, rec);
	}
	
	@Test
	public void testRecuperarDuasContas(){
		ContaCorrente rec;
		rec = sr.recuperarConta("500.000");
		assertEquals(cc2, rec);
		
	}
	
	@Test
	public void testSaldoSucesso(){
		assertEquals(ce.saldo("100.000", sr), "O saldo � R$500.0");
	}
	
	@Test
	public void testSaldoFalha(){
		assertEquals(ce.saldo("300.000", sr), "Conta n�o encontrada");
	}
	
	@Test
	public void testSacarSucesso(){
		assertEquals(ce.sacar("100.000", sr, 100), "Retire seu dinheiro");
	}
	
	@Test
	public void testSacarFalha(){
		assertEquals(ce.sacar("100.000", sr, 800), "Saldo insuficiente");
	}
	
	@Test
	public void testDepositarSucesso(){
		assertEquals(ce.depositar("100.000", sr, 100), "Dep�sito recebido com sucesso");
	}
	
	@Test
	public void testLoginSucesso(){
		assertEquals(ce.login("100.000", sr), "Usu�rio autenticado");
	}
	
	@Test
	public void testLoginFalha(){
		assertEquals(ce.login("200.000", sr), "N�o foi poss�vel autenticar o usu�rio");
	}
}
