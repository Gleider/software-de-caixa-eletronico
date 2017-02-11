package mock;

import exceptions.ErroEntregarDinheiroException;
import exceptions.ErroLerEnvelopeException;
import exceptions.ErroNumeroContaException;

import org.junit.Test;

import classes.Hardware;

public class MockHardware implements Hardware{
	private boolean falharNumConta = false;
	private boolean falharEntregarDinheiro = false;
	private boolean falharLerEnvelope = false;
	private String conta = "500.000";
	
	public boolean isFalharNumConta() {
		return falharNumConta;
	}

	public void setFalharNumConta(boolean falharNumConta) {
		this.falharNumConta = falharNumConta;
	}

	public boolean isFalharEntregarDinheiro() {
		return falharEntregarDinheiro;
	}

	public void setFalharEntregarDinheiro(boolean falharEntregarDinheiro) {
		this.falharEntregarDinheiro = falharEntregarDinheiro;
	}

	public boolean isFalharLerEnvelope() {
		return falharLerEnvelope;
	}

	public void setFalharLerEnvelope(boolean falharLerEnvelope) {
		this.falharLerEnvelope = falharLerEnvelope;
	}

	@Override
	public String pegarNumeroDaContaCartao() throws ErroNumeroContaException{
		if(this.isFalharNumConta())
			throw new ErroNumeroContaException();
		return this.conta;
	}

	@Override
	public void entregarDinheiro() throws ErroEntregarDinheiroException{
		if(this.isFalharEntregarDinheiro())
			throw new ErroEntregarDinheiroException();
		
	}

	@Override
	public void lerEnvelope() throws ErroLerEnvelopeException{
		if(this.isFalharLerEnvelope())
			throw new ErroLerEnvelopeException();
		
	}

	@Test(expected = ErroNumeroContaException.class)
	public void numContaFalha() throws ErroNumeroContaException{
		setFalharNumConta(true);
		pegarNumeroDaContaCartao();
	}
	
	@Test
	public void numContaSucesso() throws ErroNumeroContaException  {
		setFalharNumConta(false);
		pegarNumeroDaContaCartao();
	}
	
	@Test(expected = ErroEntregarDinheiroException.class)
	public void entregarDinheiroFalha() throws ErroEntregarDinheiroException{
		setFalharEntregarDinheiro(true);
		entregarDinheiro();
	}
	
	@Test
	public void entregarDinheiroSucesso() throws ErroEntregarDinheiroException{
		setFalharEntregarDinheiro(false);
		entregarDinheiro();
	}
	
	@Test(expected = ErroLerEnvelopeException.class)
	public void lerEnvelopeFalha() throws ErroLerEnvelopeException{
		setFalharLerEnvelope(true);
		lerEnvelope();
	}
	
	@Test
	public void lerEnvelopeSucesso() throws ErroLerEnvelopeException{
		setFalharLerEnvelope(false);
		lerEnvelope();
	}
}
