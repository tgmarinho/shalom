package br.com.shalom.repository.helper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.shalom.model.Membro;
import br.com.shalom.repository.filter.MembroFilter;

public interface MembrosQueries {
	
	public Page<Membro> filtrar(MembroFilter filtro, Pageable pageable);
	
}
