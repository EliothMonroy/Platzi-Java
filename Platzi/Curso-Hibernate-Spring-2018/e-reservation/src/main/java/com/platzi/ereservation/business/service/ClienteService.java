package com.platzi.ereservation.business.service;

import com.platzi.ereservation.business.repository.ClienteRepository;
import com.platzi.ereservation.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para definir los servicios del cliente
 */
@Service//Es como un Component pero orientado a servicios
@Transactional(readOnly = true)//Específicamos que todos los métodos de la clase serán tratados como una transacción de solo lectura (a excepción de que se indique lo contrario)
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Método para realizar la operación de guardar un cliente
	 * @param cliente El cliente ha crear
	 * @return Cliente creado
	 */
	@Transactional
	public Cliente create(Cliente cliente){
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para realizar la operación de actualizar un cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente){
		return this.clienteRepository.save(cliente);
	}

	/**
	 * Método para realizar la operación de eliminar un cliente
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente){
		this.clienteRepository.delete(cliente);
	}

	/**
	 * Método para realizar la operación de encontrar un cliente por su identificación
	 * @param idCli
	 * @return
	 */
	public Cliente findByIdCli(String idCli){
		return this.clienteRepository.findByIdCli(idCli);
	}

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
}
