package com.worknest.servicio.repositorio;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.worknest.servicio.entidad.Persona;

public interface RepositorioPersona extends CrudRepository<Persona, Long> {
	@Procedure
	void personaProcedimiento(String nombre, String apellido);
	@Procedure
	void deletepersonas(Long idPersona);
}
