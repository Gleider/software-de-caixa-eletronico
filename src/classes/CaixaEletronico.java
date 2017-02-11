package classes;
import mock.MockServicoRemoto;

public class CaixaEletronico {
	private ContaCorrente cc;
	
	public String saldo(String numConta, MockServicoRemoto mock) {
		cc = mock.recuperarConta(numConta);
		if(cc != null)
			return "O saldo é R$" + cc.getSaldo();
		return "Conta não encontrada";
	}

	public String sacar(String numConta, MockServicoRemoto mock, double saldo) {
		cc = mock.recuperarConta(numConta);
		if(cc != null){
			if((cc.getSaldo() - saldo) >= 0){
				mock.persistirConta(numConta, cc.getSaldo() - saldo);
				return "Retire seu dinheiro";
			}
			return "Saldo insuficiente";
		}
		return "Conta não encontrada";
	}

	public String depositar(String numConta, MockServicoRemoto mock, double saldo) {
		cc = mock.recuperarConta(numConta);
		if(cc != null){
			mock.persistirConta(numConta, cc.getSaldo() + saldo);
			return "Depósito recebido com sucesso";
		}
		return "Conta não encontrada";
	}

	public String login(String numConta, MockServicoRemoto mock) {
		cc = mock.recuperarConta(numConta);
		if(cc != null){
			return "Usuário autenticado";
		}
		return "Não foi possível autenticar o usuário";
	}
}
