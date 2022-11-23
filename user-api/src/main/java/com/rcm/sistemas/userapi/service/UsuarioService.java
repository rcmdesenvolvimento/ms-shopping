package com.rcm.sistemas.userapi.service;

import java.util.List;
import java.util.Optional;
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

	public UsuarioDTO findById(long usuarioId) {
		Optional<Usuario> usuario = repository.findById(usuarioId);
		if (usuario.isPresent()) {
			return modelMapper.map(usuario.get(), UsuarioDTO.class);
		}
		return null;
	}
	
	public UsuarioDTO findByCpf(String cpf) {
		Usuario usuario = repository.findByCpf(cpf);
		if (usuario != null) {
			return modelMapper.map(usuario, UsuarioDTO.class);
		}
		return null;
	}
	
	public List<UsuarioDTO> queryByNome(String nome) {
		List<Usuario> lista = repository.queryByNomeLike(nome);
		return lista
				.stream()
				.map(u -> modelMapper.map(u, UsuarioDTO.class))
				.collect(Collectors.toList());
	}
	
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		Usuario usuario = repository.save(modelMapper.map(usuarioDTO, Usuario.class));
		return modelMapper.map(usuario, UsuarioDTO.class);
	}
	
	public void delete(long usuarioId) {
		Optional<Usuario> usuario = repository.findById(usuarioId);
		if (usuario.isPresent()) {
			repository.deleteById(usuarioId);
		}
	}
	

}
