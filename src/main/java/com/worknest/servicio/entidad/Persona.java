package com.worknest.servicio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.GenerationType;




/*Asignamos a la clase tipo entidad*/
@Entity
/*Nombre de la tabla que contendrá está estructura*/
@Table(name = "persona")

/*Creación del procedimiento almacenado*/
@NamedStoredProcedureQueries({
	/*Procedimiento almacenao de agregar*/
	@NamedStoredProcedureQuery(
			name = "agregar",
			procedureName = "personaProcedimiento",
			parameters = {
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "_nombre", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "_apellido", type =  String.class)
					
			}),
	/*Procedimiento de eliminar una persona*/
	@NamedStoredProcedureQuery(
			name = "eliminar",
			procedureName = "deletepersonas",
			parameters = {
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "_idpersona", type =  Long.class)
					
					
			})
})



public class Persona {
	
	/*Generamos un id autoincrementable*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPersona")
	private Long idPersona;
	
	/*Columna nombre de la tabla*/
	@Column(name = "nombre")
	private String nombre;
	
	/*Columna apellido de la tabla*/
	@Column(name = "apellido")
	private String apellido;

	

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	
	
}//END clase Persona
