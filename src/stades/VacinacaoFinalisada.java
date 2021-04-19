package stades;

import java.util.List;

import models.Pessoa;

public class VacinacaoFinalisada implements EstadoVacinacao {

	@Override
	public void atualizarEstado(Pessoa pessoa, Integer idadeMinima, List<String> comorbidades,
			List<String> profissoes) {
		System.out.println("Pessoa vacinada");
	}

	@Override
	public String toString() {
		return "Vacinação finalizada";
	}
}
