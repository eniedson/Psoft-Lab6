package stades;

import java.util.Date;
import java.util.List;

import models.Pessoa;

public class Dose1 implements EstadoVacinacao {

	private Date dataVacinacao;
	
	public Dose1() {
		dataVacinacao = new Date();
	}
	
	@Override
	public void atualizarEstado(Pessoa pessoa, Integer idadeMinima, List<String> comorbidades,
			List<String> profissoes) {
		if ((new Date().getTime() - dataVacinacao.getTime()) / (10006060*24) >= 20) {
			pessoa.setEstadoVacinacao(new HabilitadoDose2());
		}
	}

	@Override
	public String toString() {
		return "Tomou a primeira dose";
	}
}
