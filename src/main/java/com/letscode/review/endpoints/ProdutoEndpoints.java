package com.letscode.review.endpoints;

import java.util.List;
import java.util.Optional;

import com.letscode.review.dto.ProdutoDto;
import com.letscode.review.models.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.letscode.review.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutoEndpoints {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path = "/produto", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @RequestMapping(path = "/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduto(@PathVariable long id) {
        Optional<Produto> produto = produtoService.buscarProduto(id);
        if (produto.isEmpty()) {
            return new ResponseEntity<String>("Produto não encontrado.", HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> novoCliente(@RequestBody ProdutoDto produtoDto) {
        boolean OK = produtoService.novoProduto(produtoDto);
        if (OK) {
            return new ResponseEntity<String>("Produto criado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível criar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarCliente(@RequestBody Produto produto) {
        boolean OK = produtoService.atualizarProduto(produto);
        if (OK) {
            return new ResponseEntity<String>("Produto atualizado com sucesso.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Não foi possível atualizar o produto.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removerCliente(@PathVariable long id) {
        boolean OK = produtoService.removerProduto(id);
        if (OK) {
            return new ResponseEntity<String>("Produto excluído com sucesso.", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Não foi possível excluir o produto.", HttpStatus.BAD_REQUEST);
        }
    }

}
