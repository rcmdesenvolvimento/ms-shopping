package com.rcm.sistemas.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.sistemas.userapi.dto.UsuarioDTO;

@RestController
//@RequestMapping("/users")
public class UsuarioController {

	public static List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

	@PostConstruct
	public void initiateList() {
		UsuarioDTO dto = new UsuarioDTO("Ricardo Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com","21976378858", new Date());
		UsuarioDTO dto1 = new UsuarioDTO("Rachel Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com","21976378858", new Date());
		UsuarioDTO dto2 = new UsuarioDTO("Lucas Miranda", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com","21976378858", new Date());
		UsuarioDTO dto3 = new UsuarioDTO("Davi Sardinha", "67380700715", "Rua Carlos Palut, 426", "ricardo@gmail.com","21976378858", new Date());
		usuarios.add(dto);
		usuarios.add(dto1);
		usuarios.add(dto2);
		usuarios.add(dto3);
	}

	@GetMapping("/")
	public String getMensagem() {
		return "Spring boot is working";
	}

	@GetMapping("/users")
	public List<UsuarioDTO> getUsers() {
		return usuarios;
	}

}
