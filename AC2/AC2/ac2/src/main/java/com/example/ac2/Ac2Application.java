package com.example.ac2;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2.controllers.FuncionarioController;
import com.example.ac2.controllers.ProjetoController;
import com.example.ac2.controllers.SetorController;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.models.Setor;

@SpringBootApplication
public class Ac2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}

	@Bean
	public CommandLineRunner init(
			@Autowired ProjetoController projetoController,
			@Autowired FuncionarioController funcionarioController,
			@Autowired SetorController setorController) {
		return args -> {

			
			System.out.println("=== ADICIONANDO SETOR ===");
			Setor setor = new Setor(null, "Suporte técnico", null);
			setorController.adicionarSetor(setor);
			System.out.println("Setor adicionado: " + setor.getNome());
			System.out.println(" ");

			
			System.out.println("=== ADICIONANDO FUNCIONÁRIO ===");
			Funcionario funcionario = new Funcionario("Murilo");
			funcionario.setSetor(setor);
			funcionarioController.adicionarFuncionario(funcionario);
			System.out.println("Funcionário adicionado: " + funcionario.getNome());
			System.out.println(" ");

			
			System.out.println("=== ADICIONANDO PROJETO ===");
			Projeto projeto = new Projeto("Atualizar Software", LocalDate.now(), LocalDate.now().plusDays(30));
			projetoController.adicionarProjeto(projeto);
			System.out.println("Projeto adicionado: " + projeto.getDescricao());
			System.out.println(" ");

			
			System.out.println("=== BUSCANDO PROJETO POR ID ===");
			Projeto projetoBuscado = projetoController.buscarProjetoPorId(1);
			if (projetoBuscado != null) {
				System.out.println("Projeto encontrado: " + projetoBuscado.getDescricao());
			} else {
				System.out.println("Projeto não encontrado!");
			}
			System.out.println(" ");

			
			System.out.println("=== VINCULANDO FUNCIONÁRIO AO PROJETO ===");
			projetoController.vincularFuncionario(1, 1);
			System.out.println("Funcionário vinculado ao projeto!");
			System.out.println(" ");

			
			System.out.println("=== BUSCANDO PROJETOS PELO ID DO FUNCIONÁRIO ===");
			List<Projeto> projetosDoFuncionario = funcionarioController.buscarProjetosPorFuncionario(1);
			System.out.println("Projetos do funcionário: ");
			projetosDoFuncionario.forEach(p -> System.out.println("- " + p.getDescricao()));
			System.out.println(" ");

			
			System.out.println("=== BUSCANDO PROJETO E FUNCIONÁRIOS VINCULADOS ===");
			Projeto projetoComFuncionarios = projetoController.buscarProjetoPorId(1);
			if (projetoComFuncionarios != null) {
				System.out.println("Projeto encontrado: " + projetoComFuncionarios.getDescricao());
				System.out.println("Funcionários vinculados ao projeto: ");
				projetoComFuncionarios.getFuncionarios().forEach(f -> System.out.println("- " + f.getNome()));
			} else {
				System.out.println("Projeto não encontrado!");
			}
			System.out.println(" ");


			System.out.println("=== BUSCANDO SETOR POR ID ===");
			Setor setorBuscado = setorController.buscarSetorPorId(1);
			if (setorBuscado != null) {
				System.out.println("Setor encontrado: " + setorBuscado.getNome());
			} else {
				System.out.println("Setor não encontrado!");
			}
			System.out.println(" ");


			System.out.println("=== BUSCANDO PROJETOS ENTRE PERÍODOS ===");
			LocalDate dataInicio = LocalDate.now();
			LocalDate dataFim = LocalDate.now().plusDays(30);
			List<Projeto> projetosEntreDatas = projetoController.buscarProjetosPorPeriodo(dataInicio, dataFim);
			System.out.println("Projetos entre " + dataInicio + " e " + dataFim + ": ");
			projetosEntreDatas.forEach(p -> System.out.println("- " + p.getDescricao()));
			System.out.println(" ");


			System.out.println("=== BUSCANDO SETORES COM FUNCIONÁRIOS ===");
			List<Setor> setoresComFuncionarios = setorController.buscarSetoresComFuncionarios();
			System.out.println("Setores com funcionários: ");
			setoresComFuncionarios.forEach(s -> {
				System.out.println("- Setor: " + s.getNome());
				s.getFuncionarios().forEach(f -> System.out.println("- Funcionário: " + f.getNome()));
			});
		};
	}
}
