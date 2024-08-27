package application.service;

import org.springframework.steretype.Service;

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