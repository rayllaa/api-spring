package br.com.api.estudante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.estudante.model.Estudante;
import br.com.api.estudante.model.dto.EstudanteDTO;
import br.com.api.estudante.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
	@Autowired
	private EstudanteRepository repository;

	public List<Estudante> obterEstudantes(){
			
		List<Estudante> list = repository.findAll();
		
		return list;
	}

	public Estudante consultarEstudante(Long id) throws Exception {
		
		Optional<Estudante> estudante = repository.findById(id);

		return estudante.orElseThrow(() -> new Exception("Objeto não encontrado. Id: "+id));
	}

	public Estudante inserirEstudante(EstudanteDTO estudanteDto) {
		
		Estudante estudante = estudanteDto.fromNewDTO();
		
		estudante = repository.save(estudante);//gera novo id
		
		return estudante;
	}

	public void alterarEstudante(Estudante estudante, EstudanteDTO estudanteDto) {

		estudante.setCpf(estudanteDto.getCpfEstudante());
		estudante.setNome(estudanteDto.getNomeEstudante());
		estudante.setTelefone(estudanteDto.getTelefoneEstudante());
		estudante.setEndereco(estudanteDto.getEnderecoEstudante());
		estudante.setEmail(estudanteDto.getEmailEstudante());
		
		estudante = repository.save(estudante); //save() se recebe null cria novo objeto, senão altera o objeto
	}
	
	public void removerEstudante(Long id){
		repository.deleteById(id);
	}
}
