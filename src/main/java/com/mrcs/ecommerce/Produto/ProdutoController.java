package com.mrcs.ecommerce.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/cadastro")
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/lista")
    public String listarProdutos (Model model){
        model.addAttribute("produtos", produtoRepository.findAll());

        return "produtos";
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<ProdutoModel> atualizaProduto(@RequestBody ProdutoModel produtoAtualizado, @PathVariable Long id){
        Optional<ProdutoModel> optional = produtoRepository.findById(id);

        if (produtoRepository.existsById(id)){
            produtoAtualizado.setId(id);
            ProdutoModel salvo = produtoRepository.save(produtoAtualizado);
            return ResponseEntity.ok(salvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
