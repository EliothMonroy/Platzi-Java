package com.platzi.ereservation.view.resources;

import com.platzi.ereservation.business.service.ClienteService;
import com.platzi.ereservation.model.Cliente;
import com.platzi.ereservation.view.resources.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representael servicio web de cliente
 */
@RestController//Indicamos que nuestra clase será tratada como un servicio web
@RequestMapping("/api/cliente")//Indicamos el nombre de nuestro servicio (url)
@Api(tags = "cliente")//Indicamos que este servicio se va a documentar con Swagger
public class ClienteResource {
	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@ApiOperation(value = "Crear Cliente",notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cliente creado correactamente"),
			@ApiResponse(code = 400, message = "Solicitud inválida")
	})
	@PostMapping//Indicamos que es una operación post
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO){
		Cliente cliente=new Cliente();
		cliente.setNombreCli(clienteVO.getNombreCli());
		cliente.setApellidoCli(clienteVO.getApellidoCli());
		cliente.setIdentificacionCli(clienteVO.getIdentificacionCli());
		cliente.setDireccionCli(clienteVO.getDireccionCli());
		cliente.setTelefonoCli(clienteVO.getTelefonoCli());
		cliente.setEmailCli(clienteVO.getEmailCli());
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Actualizar Cliente",notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cliente actualizado correactamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")
	})
	@PutMapping("/{id}")//Indicamos que es una operación put, y especificamos que recibiremos un id
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") String idCli, ClienteVO clienteVO){
		Cliente cliente=this.clienteService.findByIdCli(idCli);
		if(cliente==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			cliente.setNombreCli(clienteVO.getNombreCli());
			cliente.setApellidoCli(clienteVO.getApellidoCli());
			cliente.setIdentificacionCli(clienteVO.getIdentificacionCli());
			cliente.setDireccionCli(clienteVO.getDireccionCli());
			cliente.setTelefonoCli(clienteVO.getTelefonoCli());
			cliente.setEmailCli(clienteVO.getEmailCli());
			return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Eliminar Cliente",notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cliente eliminado correactamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")
	})
	@DeleteMapping("/{id}")//Método delete http
	public ResponseEntity deleteCliente(@PathVariable("id") String idCli){
		Cliente cliente=this.clienteService.findByIdCli(idCli);
		if(cliente!=null){
			this.clienteService.delete(cliente);
			return new ResponseEntity(HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Listar Clientes",notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados")
	})
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
