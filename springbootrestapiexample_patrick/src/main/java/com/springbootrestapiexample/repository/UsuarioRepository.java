package com.springbootrestapiexample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapiexample.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
