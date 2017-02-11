package classes;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numConta);
	public void persistirConta(String numConta, double saldo);
}
