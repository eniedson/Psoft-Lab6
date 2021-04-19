package vacinaCovid;

import java.util.Scanner;

public class Main {

	private static final Scanner sc = new Scanner(System.in);;
	private static final String[] opcoes = {
			"Cadastrar/Atualizar pessoa (Para atualizar, basta colocar um cpf ja existente)", "Alterar idade minima",
			"Adicionar comorbidade", "Adicionar profissao", "Vacinar habilitados", "Listar cadastrados", "Sair" };

	private static Sistema sistema;

	public static void main(String[] args) {
		sistema = new Sistema();
		while (menu());
	}

	public static boolean menu() {
		switch (menuSelecao()) {
		case 0:
			menuSalvarPessoa();
			break;
		case 1:
			System.out.print("Digite a nova idade minima: ");
			sistema.setIdadeMinima(sc.nextInt());
			break;
		case 2:
			System.out.print("Digite o nome da comorbidade: ");
			sistema.adicionarComorbidade(sc.next());
			break;
		case 3:
			System.out.print("Digite o nome da profissão: ");
			sistema.adicionarProfissao(sc.next());
			break;
		case 4:
			sistema.vacinarHabilitados();
			break;
		case 5:
			System.out.println(sistema.listarPessoasCadastradas());
			break;
		case 6:
			return false;
		default:
			System.out.println("Opção invalida");
		}
		return true;
	}

	public static int menuSelecao() {
		System.out.println("Escolha a opção desejada: ");
		for (int i = 0; i < opcoes.length; i++) {
			System.out.println("(" + i + ") " + opcoes[i]);
		}
		System.out.print(">> ");
		return sc.nextInt();
	}

	public static void menuSalvarPessoa() {
		System.out.print("Digite o nome da pessoa: ");
		String nome = sc.next();
		System.out.print("Digite o cpf da pessoa: ");
		String cpf = sc.next();
		System.out.print("Digite a idade da pessoa: ");
		Integer idade = sc.nextInt();
		System.out.print("Digite o endereço da pessoa: ");
		String endereco = sc.next();
		System.out.print("Digite o número do cartão da pessoa: ");
		String numeroCartao = sc.next();
		System.out.print("Digite o email da pessoa: ");
		String email = sc.next();
		System.out.print("Digite o telefone da pessoa: ");
		String telefone = sc.next();
		System.out.print("Digite a profissão da pessoa: ");
		String profissao = sc.next();
		System.out.print("Digite as comorbidades da pessoa: ");
		String[] comorbidades = sc.next().split(" ");
		System.out.println();

		sistema.salvarPessoa(nome, cpf, idade, endereco, numeroCartao, email, telefone, profissao, comorbidades);
	}

}
