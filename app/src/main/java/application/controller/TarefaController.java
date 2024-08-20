package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import application.model.Tarefa;
import application.repository.TarefaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaRepository TarefaRepo;

    @GetMapping
    public Iterable<Tarefa> list(){
        return TarefaRepo.findAll();
    }

    @PostMapping
    public Tarefa insert(@RequestBody Tarefa tarefa){
         if(tarefa.getDescricao().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Você deve inserir uma descrição valida"
            );
        } 
        return TarefaRepo.save(tarefa);
    }


    @GetMapping("/{id}")
    public Tarefa details(@PathVariable long id){
        Optional<Tarefa> resultado = TarefaRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não Encontrada"
            );
        }
        return resultado.get();
    }

    @PutMapping("/{id}")
    public Tarefa put(
        @PathVariable long id,
        @RequestBody Tarefa novasTarefas){
        Optional<Tarefa> resultado =  TarefaRepo.findById(id);

        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"
            );
        }

        if(novasTarefas.getDescricao().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Você deve passar uma descrição"
            );
        }

        resultado.get().setDescricao(novasTarefas.getDescricao());
        resultado.get().setConcluido(novasTarefas.getConcluido());


        return TarefaRepo.save(resultado.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        if(!TarefaRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Essa tarefa não existe"
            );
        }

        TarefaRepo.deleteById(id);
    }

}
