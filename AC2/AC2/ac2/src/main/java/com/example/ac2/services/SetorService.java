package com.example.ac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Setor;
import com.example.ac2.repositories.SetorRepository;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public void adicionarSetor(Setor setor) {
        setorRepository.save(setor);
    }

    public Setor buscarSetorPorId(Integer idSetor) {
        return setorRepository.findById(idSetor).orElseThrow();
    }

    public List<Setor> buscarSetoresComFuncionarios() {
        return setorRepository.findAllSetoresWithFuncionarios();
    }

    public void excluir(Integer id) {
        setorRepository.deleteById(id);
    }
}
