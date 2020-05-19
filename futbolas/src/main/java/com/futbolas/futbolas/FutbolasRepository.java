package com.futbolas.futbolas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FutbolasRepository extends JpaRepository<Futbolas, Long> {

    @Query(value = "select * from futbolas e where e.name like %:keyword% or e.team like %:keyword% or e.country like %:keyword%", nativeQuery = true)
    List<Futbolas> findbyKeyword(@Param("keyword") String keyword);
}
