package application.service;

import org.springframework.steretype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import application.model.Usuario;

@Service
public class TokenService{
    private String secret = "1234567";

    private String generateToken(Usuario usuario){
        try {
           Algorithm algorithm =  Algotithm.HMAC256(secret);
           return JWT.create()
                .withIssuer("API TAREFAS")
                .withSubject(usuario.getNomeDeUsuario())
                .sign(algorithm);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar JWT", exception);
        }
    }
}