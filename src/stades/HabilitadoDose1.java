package stades;

import java.util.List;

import models.Pessoa;

public class HabilitadoDose1 implements EstadoVacinacao {

	@Override
	public void atualizarEstado(Pessoa pessoa, Integer idadeMinima, List<String> comorbidades,
			List<String> profissoes) {
		pessoa.setEstadoVacinacao(new Dose1());
	}

	@Override
	public String toString() {
		return "Habilitado para primeira dose";
	}
}
