package com.worknest.servicio.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worknest.servicio.entidad.Persona;
import com.worknest.servicio.repositorio.RepositorioPersona;

@RestController
@RequestMapping("/")
public class PersonControlador {
	private final RepositorioPersona repositorioPersona;
	@Autowired
	public PersonControlador(RepositorioPersona repositorioPersona) {
		this.repositorioPersona = repositorioPersona;
	}
	
	/*Método que lista todos los elementos de la base de datos*/
	@RequestMapping("/listaPersonas")
	public Iterable<Persona> listaTodasLasPersonas(){
		return repositorioPersona.findAll();
	}
	
	/*Método que guarda una registro por el metodo POST*/
	@RequestMapping(method = RequestMethod.POST, path = "/agregaPersona", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	
	public String agregaUnaPersona(@RequestBody Persona persona) {
		//Método de agregar a la base de datos con procedimiento almacenado
		repositorioPersona.personaProcedimiento(persona.getNombre(), persona.getApellido());
		
		/*Método de almacenar usando los métodos de la interface*/
		//repositorioPersona.save(persona);
		
		
		return "Se agrego la persona";
	}
	
	/*Método que actualiza un registro de la base de datos*/
	@RequestMapping(method = RequestMethod.PUT, path = "/actualizaPersona", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE )
	
	public String actualizaUnaPersona(@RequestBody Persona persona) {
		repositorioPersona.save(persona);
		return "Se actualizo la persona";
	}
	
	/*Método que elimina un elemento de la base de datos*/
    @RequestMapping(method = RequestMethod.DELETE, path = "/borraPersona/{idpersona}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String eliminarElemento(@PathVariable Long idpersona, @RequestBody Persona persona){
    	
    	/*Usando procedimiento almacenado*/
    	repositorioPersona.deletepersonas(idpersona);
    	
    	/*Usando el método de la Interface*/
        //repositorioPersona.delete(persona);
        
    	return "La persona fue borrada";        
    }

	
	
	
	
	
	
	
	
}
