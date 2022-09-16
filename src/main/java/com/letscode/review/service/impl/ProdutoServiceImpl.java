package com.letscode.review.service.impl;

import java.util.List;
import org.slf4j.Logger;
import java.util.Optional;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    @Override
    public List<Produto> listarProdutos() {
        log.info("Teste de LOG: findAll()");
        return produtoDao.findAll();
    }

    @Override
    public Optional<Produto> buscarProduto(long id) {
        log.info("Teste de LOG: findById()");
        return produtoDao.findById(id);
    }

    @Override
    public boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getDescricao(), produtoDto.getPreco());
            produtoDao.save(produto);
            log.info("Teste de LOG: save() Sucesso");
            return true;
        } catch (Exception e) {
            log.info("Teste de LOG: save() Erro");
            return false;
        }
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            produtoDao.save(produto);
            log.info("Teste de LOG: save() Sucesso");
            return true;
        } catch (Exception e) {
            log.info("Teste de LOG: save() Erro");
            return false;
        }
    }

    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            log.info("Teste de LOG: deleteById() Sucesso");
            return true;
        } catch (Exception e) {
            log.info("Teste de LOG: deleteById() Erro");
            return false;
        }
    }

}
