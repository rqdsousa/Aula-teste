package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    // Metodo Get para pegar TODAS as informações
    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> ListaProduto() {
        return produtoRepository.findAll();

    }
//metodo Get para pegar UMA UNICA informação!
// implementar o metodo findById
    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um produto unico")
    public Optional<Produto> ListaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);

        // criando metodo Post- salvar
        @PostMapping("/produto")
        @ApiOperation(value = "Salva um produto")
                public Produto salvaProduto(@RequestBody Produto produto){
            return produtoRepository.save(produto)
        }

        // Fazendo o método Delete

        @DeleteMapping("/produto")
        @ApiOperation(value = "Deleta um produto")
                public void deleteProduto(@RequestBody Produto produto){
            produtoRepository.delete(produto);
        }
        // método que atualiza determinado produto//
        @PutMapping("/produtos")
        @ApiOperation(value = "Atualiza um produto")
                public Produto atualizaProduto(@RequestBody Produto produto){
            return produtoRepository.save(produto);
        }

        @PatchMapping("/produtos")
                @ApiOperation(value = "Atualiza um item")
                public Produto atualizarProdutoItem(@RequestBody Produto produto)
        return produtoRepository.save(produto);










    }
}
