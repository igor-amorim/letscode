package com.letscode.review.service;

import java.util.List;
import java.util.Optional;
import com.letscode.review.models.Usuario;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Optional<Usuario> getUsuario(String email);

    boolean newUsuario(Usuario usuario);

    boolean setUsuario(Usuario usuario);

    boolean delUsuario(String email);

}
