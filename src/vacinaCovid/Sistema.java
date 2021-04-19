package vacinaCovid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.Pessoa;
import stades.Dose1;
import stades.HabilitadoDose1;
import stades.HabilitadoDose2;
import stades.NaoHabilitado;

public class Sistema {

	private Map<String, Pessoa> pessoas;
	private Integer idadeMinima;
	private List<String> comorbidades;
	private List<String> profissoes;
	
	public Sistema() {
		pessoas = new HashMap<String, Pessoa>();
		profissoes = new LinkedList<String>();
		comorbidades = new LinkedList<String>();
	}
	
	public void salvarPessoa(String nome, String cpf, Integer idade, String endereco, String numeroCartaoSUS, String email,
			String telefone, String proficao, String[] comorbidades) {
		pessoas.put(cpf, new Pessoa(nome, cpf, idade, endereco, numeroCartaoSUS, email, telefone, proficao, comorbidades));
		pessoas.get(cpf).atualizarEstado(idade, this.comorbidades, this.profissoes);
	}
	
	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
		atualizarEstados();
	}
	
	public void adicionarComorbidade(String comorbidade) {
		comorbidades.add(comorbidade);
		atualizarEstados();
	}
	
	public void adicionarProfissao(String profissao) {
		profissoes.add(profissao);
		atualizarEstados();
	}
	
	public void atualizarEstados() {
		for (Pessoa pessoa : pessoas.values()) {
			if (pessoa.getEstadoVacinacao() instanceof NaoHabilitado || pessoa.getEstadoVacinacao() instanceof HabilitadoDose1) {
				pessoa.setEstadoVacinacao(new NaoHabilitado());
				pessoa.atualizarEstado(idadeMinima, comorbidades, profissoes);
			}
		}
	}

	public void vacinarHabilitados() {
		for (Pessoa pessoa : pessoas.values()) {
			if (pessoa.getEstadoVacinacao() instanceof Dose1) pessoa.atualizarEstado(idadeMinima, comorbidades, profissoes);
			
			if (pessoa.getEstadoVacinacao() instanceof HabilitadoDose1 || pessoa.getEstadoVacinacao() instanceof HabilitadoDose2) {
				pessoa.atualizarEstado(idadeMinima, comorbidades, profissoes);
			}
		}
	}

	public String listarPessoasCadastradas() {
		String saida = "";
		for (Pessoa pessoa : pessoas.values()) {
			saida += pessoa.toString() + "\n";
		}
		return saida;
	}
}
