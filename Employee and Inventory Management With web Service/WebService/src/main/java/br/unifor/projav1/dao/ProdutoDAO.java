package br.unifor.projav1.dao;

import br.unifor.projav1.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements DAO<Produto> {
    ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    public List<Produto> getAll() {
        return produtos;
    }

    @Override
    public Produto findById(int id) {
        for (Produto produto : produtos) {
            if (produto.getID() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void insert(Produto produto) {
        produto.setID(produtos.size());
        produtos.add(produto);
    }

    @Override
    public void update(Produto produto) {
        for (Produto p : produtos) {
            if (p.getID() == produto.getID()) {
                p.setQuantidade(produto.getQuantidade());
                p.setPreco(produto.getPreco());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getID() == id) {
                produtos.remove(i);
                break;
            }
        }
    }

    @Override
    public int count() {
        return produtos.size();
    }
}
