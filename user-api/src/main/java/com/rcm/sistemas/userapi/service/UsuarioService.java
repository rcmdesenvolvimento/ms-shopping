package com.rcm.sistemas.userapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcm.sistemas.userapi.dto.UsuarioDTO;
import com.rcm.sistemas.userapi.model.Usuario;
import com.rcm.sistemas.userapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public List<UsuarioDTO> getAll() {
		List<Usuario> lista = repository.findAll();
		return lista
				.stream()
				.map(u -> modelMapper.map(u, UsuarioDTO.class))
				.collect(Collectors.toList());
	}

}
