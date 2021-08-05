package br.unifor.projav1.ws.controllers;

import br.unifor.projav1.controllers.ProdutoController;
import br.unifor.projav1.entities.Produto;
import br.unifor.projav1.ws.dto.ProdutoDto;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class ProdutoControllerAdapter {
    private final ProdutoController controller;

    public ProdutoControllerAdapter(ProdutoController controller) {
        this.controller = controller;
    }

    @GetMapping("/produtos")
    public List<Produto> getAll() {
        return controller.getAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto getProdutoByID(@PathVariable int id) {
        return controller.findById(id);
    }

    @PostMapping("/produtos")
    public Produto insert(@RequestBody ProdutoDto dto) {
        Produto produto = new Produto(dto.ID, dto.nome, dto.quantidade, dto.preco);
        controller.insert(produto);
        System.out.println("Insert " + produto.getID() + " " + dto.nome + " " + dto.quantidade + " " + dto.preco);

        return produto;
    }

    @PatchMapping("/produtos/{id}")
    public Produto update(@PathVariable int id, @RequestBody ProdutoDto dto) {
        Produto produto = new Produto(id, dto.nome, dto.quantidade, dto.preco);
        controller.update(produto);
        System.out.println("Update " + produto.getID() + " " + dto.nome + " " + dto.quantidade + " " + dto.preco);
        return produto;
    }

    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable int id) {
        controller.delete(id);
    }
}
