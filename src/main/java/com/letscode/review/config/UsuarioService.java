package com.letscode.review.config;

import java.util.Optional;
import com.letscode.review.models.Usuario;
import com.letscode.review.dao.UsuarioDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioDao.findById(username);
        if (usuario.isPresent()) {
            return new UsuarioDto(usuario.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
