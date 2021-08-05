package br.unifor.projav1.entities;

public class Produto implements Entity {
    private int ID;
    private String nome;
    private int quantidade;
    private float preco;

    public Produto(int ID, String nome, int quantidade, float preco) {
        this.ID = ID;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getID() {
        return this.ID;
    }

    public String getNome() {
        return this.nome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public float getPreco() {
        return this.preco;
    }
}
