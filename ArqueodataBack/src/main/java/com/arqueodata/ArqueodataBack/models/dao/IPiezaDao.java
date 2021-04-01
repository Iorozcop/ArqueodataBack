package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Pieza;

public interface IPiezaDao extends CrudRepository<Pieza, Long> {

}
