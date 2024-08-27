package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    // abaixo é uma função nativa que constroi esse findBy, se o nome for valido no model
    //ele constroi o metodo findBy corretamente
    public Usuario findByNomeDeUsuario(String nomeDeUsuario); 
    
} 
