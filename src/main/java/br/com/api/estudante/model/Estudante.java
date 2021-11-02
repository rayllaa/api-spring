package br.com.api.estudante.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames={"cpf"})})
public class Estudante implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)//(unique=true)
	private String cpf;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String endereco;

}
