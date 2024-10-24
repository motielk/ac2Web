package com.example.ac2.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<Projeto> buscarProjetosPorFuncionario(Integer idFuncionario) {
        return funcionarioRepository.findProjetosByFuncionarioId(idFuncionario);
    }

    public void excluir(Integer id) {   
        funcionarioRepository.deleteById(id);
    }
}
