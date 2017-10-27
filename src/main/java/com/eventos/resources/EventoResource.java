package com.eventos.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.models.Evento;
import com.eventos.repository.EventoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Eventos")
@RestController
@RequestMapping("/evento")
public class EventoResource {

	@Autowired
	private EventoRepository er;
	
	@ApiOperation(value="Retorna uma lista de Eventos")
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Evento> listaEventos(){
		Iterable<Evento> listaEventos = er.findAll();
		return listaEventos;
	}
	
	@ApiOperation(value="Salva um evento")
	@PostMapping()
	public Evento cadastraEvento(@RequestBody @Valid Evento evento){
		return er.save(evento);
	}
	
	@ApiOperation(value="Deleta um evento")
	@DeleteMapping()
	public Evento deletaEvento(@RequestBody Evento evento){
		er.delete(evento);
		return evento;
	}
}
