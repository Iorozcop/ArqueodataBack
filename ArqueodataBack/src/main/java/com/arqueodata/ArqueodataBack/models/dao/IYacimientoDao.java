package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;


public interface IYacimientoDao extends JpaRepository<Yacimiento, Long> {

	Yacimiento findByNombre(String yacimiento);

}
