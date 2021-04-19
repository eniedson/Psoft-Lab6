package models;

import java.util.List;

import stades.EstadoVacinacao;
import stades.NaoHabilitado;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private Integer idade;
	private String endereco;
	private String numeroCartaoSUS;
	private String email;
	private String telefone;
	private String profissao;
	private String[] comorbidades;
	private EstadoVacinacao estadoVacinacao;
	
	public Pessoa(String nome, String cpf, Integer idade, String endereco, String numeroCartaoSUS, String email,
			String telefone, String proficao, String[] comorbidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.numeroCartaoSUS = numeroCartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = proficao;
		this.comorbidades = comorbidades;
		this.estadoVacinacao = new NaoHabilitado();
	}
	
	public void update(String nome, Integer idade, String endereco, String numeroCartaoSUS, String email,
			String telefone, String proficao, String[] comorbidades) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.numeroCartaoSUS = numeroCartaoSUS;
		this.email = email;
		this.telefone = telefone;
		this.profissao = proficao;
		this.comorbidades = comorbidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroCartaoSUS() {
		return numeroCartaoSUS;
	}

	public void setNumeroCartaoSUS(String numeroCartaoSUS) {
		this.numeroCartaoSUS = numeroCartaoSUS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String proficao) {
		this.profissao = proficao;
	}

	public String[] getComorbidades() {
		return comorbidades;
	}

	public void setComorbidades(String[] comorbidades) {
		this.comorbidades = comorbidades;
	}

	public EstadoVacinacao getEstadoVacinacao() {
		return estadoVacinacao;
	}

	public void setEstadoVacinacao(EstadoVacinacao estadoVacinacao) {
		this.estadoVacinacao = estadoVacinacao;
	}
	
	@Override
	public String toString() {
		return nome + " - " + cpf + " - " + email + " - " + estadoVacinacao.toString();
	}
	
	public void atualizarEstado(Integer idadeMinima, List<String> comorbidades, List<String> profissoes) {
		this.estadoVacinacao.atualizarEstado(this, idadeMinima, comorbidades, profissoes);
	}
	
}
