package com.example.ac2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Projeto;
import com.example.ac2.services.ProjetoService;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public void adicionarProjeto(@RequestBody Projeto Projeto) {
        projetoService.adicionarProjeto(Projeto);
    }

    @GetMapping("/{id}")
    public Projeto buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.buscarProjetoPorId(id);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }

    @GetMapping("/entre-datas")
    public List<Projeto> buscarProjetosPorPeriodo(@RequestParam("dataInicio") LocalDate dataInicio,
            @RequestParam("dataFim") LocalDate dataFim) {
        return projetoService.buscarProjetosPorPeriodo(dataInicio, dataFim);
    }
}
