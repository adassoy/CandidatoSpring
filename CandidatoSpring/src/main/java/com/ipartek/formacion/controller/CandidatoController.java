package com.ipartek.formacion.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.CandidatoService;

@Controller
public class CandidatoController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private CandidatoService candidatoService;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public void nuevo() {
		this.logger.info("Creando nuevo Candidato");
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public void buscar() {
		this.logger.info("Buscando Candidato");
	}

}
