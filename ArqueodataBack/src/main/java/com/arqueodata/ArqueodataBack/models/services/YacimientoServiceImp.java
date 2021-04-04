package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IYacimientoDao;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

@Service
public class YacimientoServiceImp implements IYacimientoService{

	@Autowired
	private IYacimientoDao yacimientoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Yacimiento> findAll() {
		return (List<Yacimiento>) yacimientoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Yacimiento findById(Long id) {
		return yacimientoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Yacimiento save(Yacimiento yacimiento) {
		return yacimientoDao.save(yacimiento);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		yacimientoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Yacimiento findByNombre(String yacimiento) {
		return yacimientoDao.findByNombre(yacimiento);
	}

}
