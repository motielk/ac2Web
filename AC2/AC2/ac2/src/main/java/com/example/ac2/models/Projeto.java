package com.example.ac2.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public Projeto(String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
                + "]";
    }

}
