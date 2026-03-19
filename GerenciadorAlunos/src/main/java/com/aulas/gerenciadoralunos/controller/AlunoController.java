package com.aulas.gerenciadoralunos.controller;

import com.aulas.gerenciadoralunos.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/Aula4_GL/alunos")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        alunos.add(new Aluno(123456, "João Remiz", "joa0.remiz@gmail.com"));
        alunos.add(new Aluno(654321, "Jose Remizar", "j0se.remizar@gmail.com"));
        alunos.add(new Aluno(321456, "Josafin Remize", "josafIn.remize@gmail.com"));
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    @PutMapping("{ra}")
    public Aluno atualizarAluno(@PathVariable Integer ra, @RequestBody Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getRa().equals(ra)) {
                a.setNome(aluno.getNome());
                a.setEmail(aluno.getEmail());
                return a;
            }
        }
        return null;
    }

    @DeleteMapping("{ra}")
    public String excluirAluno(@PathVariable Integer ra) {
        //Não queria usar muito o Iterator, mas da forma que fizemos em aula, não estava funcionando no meu computador de casa.
        Iterator<Aluno> iterator = alunos.iterator();

        while (iterator.hasNext()) {
            Aluno a = iterator.next();
            if (a.getRa().equals(ra)) {
                iterator.remove();
                return "Aluno excluido com sucesso.";
            }
        }

        return "Aluno não encontrado.";
    }
}
