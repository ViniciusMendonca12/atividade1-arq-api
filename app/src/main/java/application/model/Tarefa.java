package application.model;

// import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "Tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private boolean concluido;

    // getters and setters
    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setConcluido(boolean concluido){
        this.concluido = concluido;
    }

    public boolean getConcluido(){
        return this.concluido;
    }

    
    
}
