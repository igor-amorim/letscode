package com.letscode.review.endpoints;

import java.util.List;
import java.util.Optional;
import com.letscode.review.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.letscode.review.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UsuarioEndpoints {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(path = "/usuario", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(path = "/usuario/{email}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Usuario>> getUsuario(@PathVariable String email) {
        Optional<Usuario> usuario = usuarioService.getUsuario(email);
        return new ResponseEntity<Optional<Usuario>>(usuario, HttpStatus.OK);
    }

    @RequestMapping(path = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<String> newUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.newUsuario(usuario)) {
            return new ResponseEntity<String>("Usuário criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/usuario", method = RequestMethod.PUT)
    public ResponseEntity<String> setUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.setUsuario(usuario)) {
            return new ResponseEntity<String>("Usuário atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/usuario/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delUsuario(@PathVariable String email) {
        if (usuarioService.delUsuario(email)) {
            return new ResponseEntity<String>("Usuário excluído com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o usuário.", HttpStatus.BAD_REQUEST);
        }
    }

}
