package mock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import classes.CaixaEletronico;
import classes.ContaCorrente;
import classes.ServicoRemoto;

public class MockServicoRemoto implements ServicoRemoto{
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
	public void setConta(ContaCorrente cc){
		contas.add(cc);
	}
	
	@Override
	public ContaCorrente recuperarConta(String numConta) {
		for(ContaCorrente cc : contas){
			if(cc.getNumConta() == numConta){
				return cc;
			}
		}
		return null;
	}

	@Override
	public void persistirConta(String numConta, double saldo) {
		ContaCorrente conta;
		conta = recuperarConta(numConta);
		if(conta != null){
			conta.setSaldo(saldo);
		}
	}
	
	@Before
	public void inicializaTeste(){
		contas.add(new ContaCorrente("50.10", 50000));
	}
	
	@Test
	public void recuperarContaSucesso(){
		ContaCorrente cc;
		cc = recuperarConta("50.10");
		assertNotNull(cc);
	}
	
	@Test
	public void recuperarContaFalha(){
		ContaCorrente cc;
		cc = recuperarConta("50.20");
		assertNull(cc);
	}
	
	@Test
	public void persistirContaSucesso(){
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("Retire seu dinheiro", ce.sacar("50.10", this, 20000));
		ContaCorrente cc = recuperarConta("50.10");
		assertEquals(cc.getSaldo(), 30000, 0);
	}
	
	@Test
	public void persistirContaFalha(){
		CaixaEletronico ce = new CaixaEletronico();
		assertEquals("Saldo insuficiente", ce.sacar("50.10", this, 70000));
		ContaCorrente cc = recuperarConta("50.10");
		assertEquals(cc.getSaldo(), 50000, 0);
	}
}
