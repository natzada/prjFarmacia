package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Medicamento;
import com.example.demo.services.MedicamentoService;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

	private final MedicamentoService medicamentoservice;
	
	@Autowired 
	public MedicamentoController (MedicamentoService medicamentoservice) {
		this.medicamentoservice = medicamentoservice;
	}
	
	@PostMapping
	public Medicamento criarMedicamento(@RequestBody Medicamento medicamento) {
		return medicamentoservice.salvarMedicamento(medicamento);
	}
	
	@GetMapping ("/{id}")
	public Medicamento buscarPorID(@PathVariable Long id) {
		return medicamentoservice.buscarPorId(id);
	}
	
	@GetMapping
	public List<Medicamento> buscarTodosMedicamentos(){
		return medicamentoservice.buscarTodos();
	}
	
	@DeleteMapping ("/{id}")
	public void deletarMedicamentos(@PathVariable Long id) {
		medicamentoservice.deletarMedicamento(id);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Medicamento> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
		Medicamento medicamentoAtualizado = medicamentoservice.atualizarMedicamento(id, medicamento);
		if(medicamentoAtualizado != null) {
			return ResponseEntity.ok(medicamentoAtualizado);
		}
		else {
			return null;
		}
	}

}
