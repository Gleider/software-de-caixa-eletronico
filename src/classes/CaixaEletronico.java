package classes;
import mock.MockServicoRemoto;

public class CaixaEletronico {
	private ContaCorrente cc;
	
	public String saldo(String numConta, MockServicoRemoto mock) {
		cc = mock.recuperarConta(numConta);
		if(cc != null)
			return "O saldo � R$" + cc.getSaldo();
		return "Conta n�o encontrada";
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
		return "Conta n�o encontrada";
	}

	public String depositar(String numConta, MockServicoRemoto mock, double saldo) {
		cc = mock.recuperarConta(numConta);
		if(cc != null){
			mock.persistirConta(numConta, cc.getSaldo() + saldo);
			return "Dep�sito recebido com sucesso";
		}
		return "Conta n�o encontrada";
	}

	public String login(String numConta, MockServicoRemoto mock) {
		cc = mock.recuperarConta(numConta);
		if(cc != null){
			return "Usu�rio autenticado";
		}
		return "N�o foi poss�vel autenticar o usu�rio";
	}
}
