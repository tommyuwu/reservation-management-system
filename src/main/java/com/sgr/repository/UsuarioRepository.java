package com.sgr.repository;

import com.sgr.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select exists (select 1 from usuario as u where u.email = :email)", nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);

    @Query(value = "select exists (select 1 from usuario as u where u.username = :username)", nativeQuery = true)
    boolean existsByUsername(@Param("username") String username);

    @Query(value = "select exists (select 1 from usuario as u where u.password = :password)", nativeQuery = true)
    boolean existsByPassword(@Param("password") String password);
}
