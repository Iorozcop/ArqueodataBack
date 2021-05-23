package com.arqueodata.ArqueodataBack.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import com.arqueodata.ArqueodataBack.models.entity.Campain;
import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.entity.Yacimiento;

@Repository
public interface PiezaRepositoryI extends JpaRepository<Pieza,Long>{

}
