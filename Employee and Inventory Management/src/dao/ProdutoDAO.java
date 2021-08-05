package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;

public class ProdutoDAO implements DAO<Produto> {
    ArrayList<Produto> produtos = new ArrayList<Produto>();
    int lastID = 0;

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
        produto.setID(lastID + 1);
        produtos.add(produto);
        lastID++;
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
