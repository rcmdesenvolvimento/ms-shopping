package com.rcm.sistemas.userapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.sistemas.userapi.dto.UsuarioDTO;
import com.rcm.sistemas.userapi.repository.UsuarioRepository;
import com.rcm.sistemas.userapi.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;

	/*
	@PostConstruct
	public void initiateList() {
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		UsuarioDTO dto = new UsuarioDTO("Ricardo Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com",
				"21976378858", new Date());
		UsuarioDTO dto1 = new UsuarioDTO("Rachel Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com",
				"21976378858", new Date());
		UsuarioDTO dto2 = new UsuarioDTO("Lucas Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com",
				"21976378858", new Date());
		UsuarioDTO dto3 = new UsuarioDTO("Davi Sardinha", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com",
				"21976378858", new Date());
		usuarios.add(dto);
		usuarios.add(dto1);
		usuarios.add(dto2);
		usuarios.add(dto3); 
	} 
*/
	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working";
	}

	@GetMapping("/user")
	public ResponseEntity<List<UsuarioDTO>> getUsers() {
		return ResponseEntity.ok().body(service.getAll());
	}

	@GetMapping("/user/{id}")
	public UsuarioDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
