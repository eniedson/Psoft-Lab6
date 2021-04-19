package stades;

import java.util.List;

import models.Pessoa;

public class NaoHabilitado implements EstadoVacinacao {

	@Override
	public void atualizarEstado(Pessoa pessoa, Integer idadeMinima, List<String> comorbidades,
			List<String> profissoes) {
		if ((idadeMinima != null && pessoa.getIdade() >= idadeMinima)
				|| profissoes.contains(pessoa.getProfissao())
				|| verificaComorbidades(pessoa.getComorbidades(), comorbidades)) {
			pessoa.setEstadoVacinacao(new HabilitadoDose1());
		}
	}

	private boolean verificaComorbidades(String[] comorbidadesPessoa, List<String> comorbidades) {
		for (String comorbidade : comorbidadesPessoa) {
			if (comorbidades.contains(comorbidade))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Não habilitado para tomar a vacina";
	}
}
