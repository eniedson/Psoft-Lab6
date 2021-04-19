package stades;

import java.util.List;

import models.Pessoa;

public interface EstadoVacinacao {

	public void atualizarEstado(Pessoa pessoa, Integer idadeMinima, List<String> comorbidades, List<String> profissoes);
	
}
