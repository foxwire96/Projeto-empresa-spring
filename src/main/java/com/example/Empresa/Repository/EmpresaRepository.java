package com.example.Empresa.Repository;

import com.example.Empresa.Entity.Empresa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM EMPRESA WHERE EMPRESA_STATUS >= 0", nativeQuery = true)
    List<Empresa> buscarEmpresasAtivas();

    @Query(value = "SELECT * FROM EMPRESA WHERE EMPRESA_ID = :id AND EMPRESA_STATUS >= 0", nativeQuery = true)
    Optional<Empresa> buscarEmpresaAtivasPorId(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE empresa SET empresa_status = -1 WHERE empresa_id = :id", nativeQuery = true)
    void apagarEmpresaPorId(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE empresa SET empresa_status = 0 WHERE empresa_id = :id", nativeQuery = true)
    void desativarEmpresaPorId(@Param("id") Integer id);
}

