package com.platzi.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/*
 * Clase que representa la tabla Cliente
 * */
@Data
@Entity
@Table(name="reserva")
public class Reserva {
	@Id//Indicamos que el campo de abajo es un ID
	@GeneratedValue(generator = "system-uuid")//Indicamos cual es la estrategia de generación del valor del id
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idRes;
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	@ManyToOne//La relación aquí es al reves
	@JoinColumn(name = "idCli") //Indicamos el campo con el que se hara el join
	private Cliente cliente;
}
