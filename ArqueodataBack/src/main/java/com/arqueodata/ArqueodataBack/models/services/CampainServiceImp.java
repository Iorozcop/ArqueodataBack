package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arqueodata.ArqueodataBack.models.dao.ICampainDao;
import com.arqueodata.ArqueodataBack.models.entity.Campain;


@Service
public class CampainServiceImp implements ICampainService {
	
	@Autowired
	private ICampainDao campainDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Campain> findAll() {
		return (List<Campain>) campainDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Campain> findAll(Pageable pageable) {
		return campainDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Campain findById(Long id) {
		return campainDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Campain save(Campain campain) {
		return campainDao.save(campain);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		campainDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Campain findByCampain(int campain) {
		return campainDao.findByCampain(campain);
	}

}
