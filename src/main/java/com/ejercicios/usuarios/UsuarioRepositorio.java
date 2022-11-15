package com.ejercicios.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejercicios.usuarios.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
	public Usuario findByEmail(String email);
	

}
