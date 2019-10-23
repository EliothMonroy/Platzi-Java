package com.platzi.ereservation.business.repository;

import com.platzi.ereservation.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* Interface que contiene las operaciones de bdd relacionadas al Cliente
* */

public interface ClienteRepository extends JpaRepository<Cliente,String> {

	/**
	 * Definición de método para biscar clientes por su apellido
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);

	/**
	 * @param idCli
	 * @return
	 */
	public Cliente findByIdCli(String idCli);

}
