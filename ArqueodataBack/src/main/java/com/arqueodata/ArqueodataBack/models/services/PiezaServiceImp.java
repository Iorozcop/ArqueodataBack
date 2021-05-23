package com.arqueodata.ArqueodataBack.models.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IPiezaDao;
import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;



@Service
public class PiezaServiceImp implements IPiezaService{

	@Autowired
	private IPiezaDao piezaDao;
	
	@Autowired
	private EntityManager entityManager;
	
		
	@Override
	@Transactional(readOnly=true)
	public List<Pieza> findAll() {
		return (List<Pieza>) piezaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Pieza> findAll(Pageable pageable) {
		return piezaDao.findAll(pageable);
	}
	
	@Override
	@Transactional
	public Pieza save(Pieza pieza) {
		//devuelve la entidad guardada
		return piezaDao.save(pieza);
	}

	@Override
	@Transactional(readOnly=true)
	public Pieza findById(Long id) {
		return piezaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		piezaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Yacimiento> findAllYacimientos() {
		return piezaDao.findAllYacimientos();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Campain> findAllCampains() {
		return piezaDao.findAllCampains();
	}
	
	//Busca pieza por múltiples campos
	public List<Pieza> buscaPieza(Pieza pieza){
	
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pieza> cq = cb.createQuery(Pieza.class);
		Root<Pieza> root = cq.from(Pieza.class);
		
		List<Predicate> sc = new ArrayList<Predicate>();
		
		if(pieza.getMaterial() != null && pieza.getMaterial() != "") {
			sc.add(cb.equal(root.get("material"), pieza.getMaterial()));	
		}
		
		if(pieza.getUtil() != null && pieza.getUtil() != "") {
			sc.add(cb.equal(root.get("util"), pieza.getUtil()));	
		}
		
		if(pieza.getYacimiento() != null) {
			sc.add(cb.equal(root.get("yacimiento"), pieza.getYacimiento()));	
		}
		
		if(pieza.getCampain() != null) {
			sc.add(cb.equal(root.get("campain"), pieza.getCampain()));	
		}
		
		if(pieza.getFecha() != null) {
			sc.add(cb.equal(root.get("fecha"), pieza.getFecha()));	
		}
		
		cq.select(root).where(cb.and(sc.toArray(new Predicate[sc.size()])));
		
		return entityManager.createQuery(cq).getResultList();
		
	}

	

}
