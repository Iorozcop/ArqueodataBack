package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arqueodata.ArqueodataBack.models.entity.Campain;


public interface ICampainDao extends JpaRepository<Campain, Long> {

	Campain findByCampain(int campain);

}
