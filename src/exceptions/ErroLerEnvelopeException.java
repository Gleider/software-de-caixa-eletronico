package exceptions;

public class ErroLerEnvelopeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String toString(){
		return "N�o foi poss�vel receber o envelope.";
	}
}
