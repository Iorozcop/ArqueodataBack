package com.arqueodata.ArqueodataBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqueodata.ArqueodataBack.models.entity.Pieza;
import com.arqueodata.ArqueodataBack.models.services.IPiezaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PiezaRestController {
	
	@Autowired
	private IPiezaService piezaService;
	
	@GetMapping("/piezas")
	public List<Pieza> index(){
		return piezaService.findAll();
	}
}
