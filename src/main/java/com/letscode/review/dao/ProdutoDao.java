package com.letscode.review.dao;

import com.letscode.review.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {

}
