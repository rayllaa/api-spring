package br.com.api.estudante.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.estudante.model.Estudante;
import br.com.api.estudante.model.dto.EstudanteDTO;
import br.com.api.estudante.service.EstudanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController //não precisa colocar o @ResponseBody em todos os métodos, restController já assume a exitencia em todos
@RequestMapping("/estudantes") //endpoint
@Api(value="Documentação API Estudante")
@CrossOrigin(origins="*") //define o dominio que pode acessar
public class EstudanteController {

	@Autowired
	private EstudanteService service;
	
	@GetMapping
	@ApiOperation(value="Retorna lista de estudantes")
	public ResponseEntity<List<Estudante>> obterEstudantes(){
		
		List<Estudante> list = service.obterEstudantes();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estudante> consultarEstudante(@PathVariable(name = ("id")) Long idEstudante) throws Exception{
		
		Estudante estudante = service.consultarEstudante(idEstudante);
		
		return ResponseEntity.ok().body(estudante);
	}
	
	@PostMapping
	public ResponseEntity<Estudante> inserirEstudante(@RequestBody @Valid EstudanteDTO estudanteDTO) throws Exception{ //valid - valida campos null ou nao com base na especificação do DTO
		
		Estudante estudante = service.inserirEstudante(estudanteDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estudante> alterarEstudante(@PathVariable(name = ("id")) Long idEstudante,
				@RequestBody EstudanteDTO estudanteDto) throws Exception{
		
		Estudante estudante = service.consultarEstudante(idEstudante);
		service.alterarEstudante(estudante, estudanteDto);
		
		return ResponseEntity.ok().body(estudante);
	}
	
	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Estudante> removerEstudante(@PathVariable(name = ("id")) Long id) throws Exception {
	        
		 	service.consultarEstudante(id);
	        service.removerEstudante(id);

	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	
	
}
