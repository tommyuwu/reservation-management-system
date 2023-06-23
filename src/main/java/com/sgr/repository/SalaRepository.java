package com.sgr.repository;

import com.sgr.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query(value = "select exists (select 1 from sala as s where s.nro_sala = :sala and s.nombre_salon = :salon)", nativeQuery = true)
    Boolean existsByNroSalaAndNombreSalon(@Param("sala") int sala, @Param("salon") String salon);
}
