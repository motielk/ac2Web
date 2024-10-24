package com.example.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public void adicionarFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.adicionarFuncionario(funcionario);
    }

    @GetMapping("/{idFuncionario}/projetos")
    public List<Projeto> buscarProjetosPorFuncionario(@PathVariable Integer idFuncionario) {
        return funcionarioService.buscarProjetosPorFuncionario(idFuncionario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        funcionarioService.excluir(id);
    }
}
