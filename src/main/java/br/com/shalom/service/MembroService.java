package br.com.shalom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.shalom.model.Membro;
import br.com.shalom.repository.Membros;

@Service
public class MembroService {

	@Autowired
	private Membros membros;

	public void salvar(Membro membro) {
		try {
			membros.saveAndFlush(membro);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(Long id) {
		try {
			membros.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
