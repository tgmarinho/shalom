package br.com.shalom.repository.helper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.shalom.model.Membro;
import br.com.shalom.paginacao.PaginacaoUtil;
import br.com.shalom.repository.filter.MembroFilter;

public class MembrosImpl implements MembrosQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Membro> filtrar(MembroFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Membro.class);
		
		paginacaoUtil.preparar(criteria, pageable);
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(MembroFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Membro.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(MembroFilter filtro, Criteria criteria) {
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getEmail())) {
				criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getStatus())) {
				if(filtro.getStatus().equals("TODOS")){
					criteria.add(Restrictions.or(Restrictions.eq("ativo", Boolean.TRUE), Restrictions.eq("ativo", Boolean.FALSE)));
				}
				if(filtro.getStatus().equals("TRUE")){
					criteria.add(Restrictions.eq("ativo", Boolean.TRUE));
				}
				if(filtro.getStatus().equals("FALSE")){
					criteria.add(Restrictions.eq("ativo", Boolean.FALSE));
				}
			}
			
			if (!StringUtils.isEmpty(filtro.getMes())) {
				criteria.add(Restrictions.sqlRestriction("month(data_nascimento) = " + filtro.getMes()));
			}
			
			if (filtro.getSituacoes() != null && !filtro.getSituacoes().isEmpty()) {
				criteria.add(Restrictions.in("situacao", filtro.getSituacoes())).addOrder(Order.asc("situacao"));
			}
		}
	}

}
