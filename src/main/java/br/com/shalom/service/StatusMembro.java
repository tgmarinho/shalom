package br.com.shalom.service;

import br.com.shalom.repository.Membros;

public enum StatusMembro{

	ATIVAR {
		@Override
		public void executar(Long[] ids, Membros  membros) {
			membros.findByIdIn(ids).forEach(u -> u.setAtivo(true));
		}
	},
	
	DESATIVAR {
		@Override
		public void executar(Long[] ids, Membros membros) {
			membros.findByIdIn(ids).forEach(u -> u.setAtivo(false));
		}
	};
	
	public abstract void executar(Long[] ids, Membros membros);
	
}
