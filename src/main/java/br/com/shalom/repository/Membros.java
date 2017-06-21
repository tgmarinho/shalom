package br.com.shalom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.shalom.model.Membro;
import br.com.shalom.repository.helper.MembrosQueries;

public interface Membros extends JpaRepository<Membro, Long>, MembrosQueries {

}
