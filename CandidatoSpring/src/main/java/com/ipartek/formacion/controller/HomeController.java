package com.ipartek.formacion.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.service.CandidatoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CandidatoService candidatoService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Procesando peticion listar Candidatos");
//		// atributos == modelo
//		final Map<String, Object> model1 = new HashMap<String, Object>();
//		model1.put("candidatos", this.candidatoService.getCandidatos());
//
//		return "home";
//	}

	//////////////////////////////////////////////////////////
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listarInventario() throws ServletException, IOException {

		this.logger.info("Procesando peticion listar Candidatos");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoService.getCandidatos());

		return new ModelAndView("home", model);
	}

	/////////////////////////////////////////////////////////

}
