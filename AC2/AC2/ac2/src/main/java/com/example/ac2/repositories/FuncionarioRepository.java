package com.example.ac2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{ 
    @Query("SELECT p FROM Projeto p JOIN p.funcionarios f WHERE f.id = :id")
    List<Projeto> findProjetosByFuncionarioId(@Param("id") Integer id);
} 