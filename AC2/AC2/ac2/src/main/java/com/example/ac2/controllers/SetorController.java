package com.example.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.models.Setor;
import com.example.ac2.services.SetorService;

@RestController
@RequestMapping("/api/setores")
public class SetorController {
    
    @Autowired
    private SetorService setorService;

    @PostMapping
    public void adicionarSetor(@RequestBody Setor setor) {;
        setorService.adicionarSetor(setor);
    }

    @GetMapping("/{idSetor}")
    public Setor buscarSetorPorId(@PathVariable Integer idSetor) {
        return setorService.buscarSetorPorId(idSetor);
    }
    @GetMapping
    public List<Setor> buscarSetoresComFuncionarios() {
        return setorService.buscarSetoresComFuncionarios();
    }
}
