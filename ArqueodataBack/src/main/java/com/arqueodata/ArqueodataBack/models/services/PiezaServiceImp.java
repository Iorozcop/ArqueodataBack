package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	@Transactional(readOnly=true)
	public List<Pieza> findAll() {
		return (List<Pieza>) piezaDao.findAll();
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

}
