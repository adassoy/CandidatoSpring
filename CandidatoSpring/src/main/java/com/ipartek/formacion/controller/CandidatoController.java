package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.service.CandidatoService;

@Controller
public class CandidatoController {
	protected final Log logger = LogFactory.getLog(getClass());
	public String valor_buscado = "";
	public String tipoCampo = "";

	@Autowired
	private CandidatoService candidatoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listarCandidatos(String tipoCampo, String valor_buscado) throws ServletException, IOException {

		this.logger.info("Procesando peticion listar Candidatos");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoService.getCandidatos(tipoCampo, valor_buscado));

		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/candidato/nuevo", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {
		this.logger.info("Mostrar formulario crear nuevo Candidato");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", new Candidato());
		model.put("isNew", true);

		return new ModelAndView("form", model);
	}

	@RequestMapping(value = "/candidato/save", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Candidato candidato, BindingResult bindingResult) {
		this.logger.info("Iniciando Guardado");

		Map<String, Object> model = new HashMap<String, Object>();
		String view = "form";
		String msg = "Problema al generar candidato";

		if (bindingResult.hasErrors()) {
			this.logger.debug("parametros no validos");
			model.put("isNew", candidato.isNew());
			msg = "Alguno de los campos no es valido";

		} else {

			if (candidato.isNew()) {
				if (this.candidatoService.crear(candidato)) {
					this.logger.info("Detectado como nuevo candidato");
					msg = "Insertado correctamente";
				} else {
					msg = "Dni duplicado";
				}

			} else {
				if (this.candidatoService.modificar(candidato)) {
					this.logger.info("Detectado como candidato a modificar");
					this.logger.info("Candidato modificado");
					msg = "Modificado correctamente";
				}

			}
			model.put("candidatos", this.candidatoService.getCandidatos(tipoCampo, valor_buscado));
			model.put("msg", msg);
			view = "index";
		}
		return new ModelAndView(view, model);

	}

	@RequestMapping(value = "/candidato/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView verDetalle(@PathVariable(value = "id") final long id) {
		this.logger.trace("Mostrando detalle del candidato[" + id + "]....");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidato", this.candidatoService.getById(id));
		model.put("isNew", false);
		return new ModelAndView("form", model);
	}

	@RequestMapping(value = "/candidato/eliminar/{id}", method = RequestMethod.GET)
	public ModelAndView eliminar(@PathVariable(value = "id") final long id) throws ServletException, IOException {
		this.logger.trace("Eliminando candidato[" + id + "]....");

		String msg = "No eliminado Candidato[" + id + "]";
		this.logger.info("No se ha podido eliminar el candidato");
		if (this.candidatoService.eliminar(id)) {
			msg = "candidato[" + id + "] eliminado";
			this.logger.info(msg);
		} else {
			this.logger.warn(msg);
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoService.getCandidatos(tipoCampo, valor_buscado));
		model.put("msg", msg);

		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscarCandidatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		valor_buscado = request.getParameter("valor_buscado");
		tipoCampo = request.getParameter("tipoCampo");

		listarCandidatos(tipoCampo, valor_buscado);

		this.logger.info("Procesando peticion buscar Candidatos");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidatos", this.candidatoService.getCandidatos(tipoCampo, valor_buscado));
		// model.put("candidatos",
		// this.candidatoService.getCandidatos(valor_buscado));

		return new ModelAndView("index", model);
	}

}
