package com.arqueodata.ArqueodataBack.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.arqueodata.ArqueodataBack.models.entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
