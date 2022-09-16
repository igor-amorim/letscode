package com.letscode.review.dao;

import com.letscode.review.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, String> {

}
