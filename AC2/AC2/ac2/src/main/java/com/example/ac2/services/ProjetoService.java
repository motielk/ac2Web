package com.example.ac2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionarProjeto(Projeto projeto) {
        projetoRepository.save(projeto);
    }

    public Projeto buscarProjetoPorId(Integer id) {
        return projetoRepository.findProjetoWithFuncionariosById(id);
    }

    public List<Projeto> buscarProjetosPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return projetoRepository.findProjetosByDateRange(dataInicio, dataFim);
    }

    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto).orElseThrow();
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElseThrow();
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }
}
