package com.sgr.repository;

import com.sgr.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "select exists (select 1 from cliente as c where c.correo = :correo)", nativeQuery = true)
    boolean existsByCorreo(@Param("correo") String correo);

    @Query(value = "select exists (select 1 from cliente as c where c.documento = :doc)", nativeQuery = true)
    boolean existsByDocumento(@Param("doc") String doc);

    @Query(value = "select exists (select 1 from cliente as c where c.telefono = :tel)", nativeQuery = true)
    boolean existsByTelefono(@Param("tel") String tel);
}
