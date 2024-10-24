package com.example.ac2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac2.models.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{
    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios")
    List<Setor> findAllSetoresWithFuncionarios();
}
