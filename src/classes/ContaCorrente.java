package classes;

public class ContaCorrente {

	private String numConta;
	private double saldo;

	public ContaCorrente(String numConta, double saldo) {
		this.numConta = numConta;
		this.saldo = saldo;
	}

	public String getNumConta() {
		return this.numConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
		
	}
	
}
