package com.rcm.sistemas.userapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcm.sistemas.userapi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByNome(String nome);

	Usuario findByCpf(String cpf);

	List<Usuario> queryByNomeLike(String nome);

}
