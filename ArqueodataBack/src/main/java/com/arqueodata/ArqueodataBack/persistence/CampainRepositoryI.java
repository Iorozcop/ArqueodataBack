package com.arqueodata.ArqueodataBack.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arqueodata.ArqueodataBack.models.entity.Campain;

@Repository
public interface CampainRepositoryI extends JpaRepository<Campain, Long>{

}
