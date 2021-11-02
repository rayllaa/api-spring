package br.com.api.estudante.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import br.com.api.estudante.model.Estudante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class EstudanteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstudante;
	
	@Column(unique=true)
	@CPF(message = "CPF inválido!")
	@NotEmpty(message = "CPF vazio!")
	private String cpfEstudante;
	
	@NotEmpty(message = "Nome vazio!")
	private String nomeEstudante;
	
	@NotEmpty(message = "Email vazio!")
	@Email
	private String emailEstudante;
	
	@NotEmpty(message = "Telefone vazio!")
	@Pattern(regexp="\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Numero inválido")
	private String telefoneEstudante;
	
	private String enderecoEstudante;	
	
	public Estudante fromNewDTO() {
		return Estudante.builder()
				.id(null)
				.cpf(this.cpfEstudante)
				.nome(this.nomeEstudante)
				.email(this.emailEstudante)
				.telefone(this.telefoneEstudante)
				.endereco(enderecoEstudante)
				.build();
	}
}
