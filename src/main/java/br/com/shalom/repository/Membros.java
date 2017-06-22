package br.com.shalom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shalom.model.Membro;
import br.com.shalom.repository.helper.MembrosQueries;

public interface Membros extends JpaRepository<Membro, Long>, MembrosQueries {

	public List<Membro> findByIdIn(Long[] ids);

}
