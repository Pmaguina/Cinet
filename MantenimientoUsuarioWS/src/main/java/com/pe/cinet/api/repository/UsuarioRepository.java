package com.pe.cinet.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.cinet.api.model.UsuarioRequest;

public interface UsuarioRepository extends JpaRepository<UsuarioRequest, Integer> {
	
	@Query(value="SELECT u.* FROM Usuario u WHERE u.codigo_promocional = :codigo_promocional",
			nativeQuery = true)
	public UsuarioRequest  buscarUsuarioPorCodigoPromocional(@Param("codigo_promocional") String  codigo_promocional);
}
