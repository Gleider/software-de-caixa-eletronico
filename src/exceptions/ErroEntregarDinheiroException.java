package exceptions;

public class ErroEntregarDinheiroException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String toString(){
		return "N�o foi poss�vel entregar o dinheiro.";
	}
}
