package com.platzi.ereservation.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/*
* Clase que representa la tabla Cliente
* */
@Data//Tenemos acceso a getters y setters de todos los atributos
@Entity //Specifies that the class is an entity
@Table(name="cliente")//Specifies the primary table for the annotated entity
/*@NamedQueries({
		@NamedQuery(name="Cliente.findByIdentificacion", query="SELECT c FROM Cliente c WHERE c.identificacionCli=?1")//Podemos definir named queries para implementar nuestras propieas búsquedas
})*/
public class Cliente {
	@Id//Indicamos que el campo de abajo es un ID
	@GeneratedValue(generator = "system-uuid")//Indicamos cual es la estrategia de generación del valor del id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	//Ahora hacemos la relación con otra tabla, un cliente puede tener muchas reservas
	@OneToMany(mappedBy = "cliente")//Indicamos una relación uno a muchos,
	// usando mappedBy indicamos el campo donde se hace la unión
	private Set<Reserva> reservas;
}
