package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,String> {

	@Query("SELECT c FROM Reserva c WHERE c.fechaIngresoRes=:fechaInicio and c.fechaSalidaRes=:fechaSalida")//Así podemos usar jpql para hacer consultas
	//con =: podemos indicar parámetros que nuestra función va a recibir
	public List<Reserva> find(@Param("fechaInicio") Date fechaInicio,@Param("fechaSalida") Date fechaSalida);//Con la anotación @Param definimos el nombre de cada parámetro

}
