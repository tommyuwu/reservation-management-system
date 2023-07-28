package com.sgr.repository;
import com.sgr.entity.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {

    @Query(value = "select exists (select 1 from equipamiento as e where e.descripcion = :descripcion)", nativeQuery = true)
    Boolean existsByDescripcion(@Param("descripcion") String descripcion);
}

