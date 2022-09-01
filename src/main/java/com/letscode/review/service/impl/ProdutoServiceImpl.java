package com.letscode.review.service.impl;

import java.util.List;
import com.letscode.review.dao.ProdutoDao;
import com.letscode.review.dto.ProdutoDto;
import com.letscode.review.models.Produto;
import org.springframework.stereotype.Service;
import com.letscode.review.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao produtoDao;

    @Override
    public List<Produto> listarProdutos() {
        return produtoDao.findAll();
    }

    @Override
    public boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getDescricao(), produtoDto.getPreco());
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            produtoDao.save(produto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
