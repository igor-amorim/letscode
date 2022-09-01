package com.letscode.review.service;

import java.util.List;
import java.util.Optional;
import com.letscode.review.dto.ProdutoDto;
import com.letscode.review.models.Produto;

public interface ProdutoService {

    List<Produto> listarProdutos();

    Optional<Produto> buscarProduto(long id);

    boolean novoProduto(ProdutoDto produto);

    boolean atualizarProduto(Produto produto);

    boolean removerProduto(long id);

}
