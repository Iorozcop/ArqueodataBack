package com.arqueodata.ArqueodataBack.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arqueodata.ArqueodataBack.models.dao.IPiezaDao;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;

@Service
public class PiezaServiceImp implements IPiezaService{

	@Autowired
	private IPiezaDao piezaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Pieza> findAll() {
		return (List<Pieza>) piezaDao.findAll();
	}

}
