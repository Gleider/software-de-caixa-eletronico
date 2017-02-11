package classes;
import exceptions.ErroEntregarDinheiroException;
import exceptions.ErroLerEnvelopeException;
import exceptions.ErroNumeroContaException;

public interface Hardware {
	public String pegarNumeroDaContaCartao() throws ErroNumeroContaException;
	public void entregarDinheiro() throws ErroEntregarDinheiroException;
	public void lerEnvelope() throws ErroLerEnvelopeException;
}
