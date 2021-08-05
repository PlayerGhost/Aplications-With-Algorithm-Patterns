package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import entities.Produto;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO implements DAO<Produto> {
    Gson gson = new Gson();
    HttpClient client = HttpClient.newHttpClient();

    @Override
    public List<Produto> getAll() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/produtos"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Type type = new TypeToken<List<Produto>>() {
            }.getType();

            List<Produto> produtos = new ArrayList<Produto>();

            if (gson.fromJson(response.body(), type) != null) {
                produtos = gson.fromJson(response.body(), type);
            }

            return produtos;
        } catch (IOException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Produto findById(int id) {
        List<Produto> produtos = getAll();
        
        for (Produto produto : produtos) {
            if (produto.getID() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void insert(Produto produto) {
        try {
            String json = gson.toJson(produto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/produtos/"))
                    .setHeader("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        } catch (IOException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Produto produto) {
        try {
            String json = gson.toJson(produto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/produtos/" + produto.getID()))
                    .setHeader("Content-Type", "application/json")
                    .method("PATCH", BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        } catch (IOException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/produtos/" + id))
                    .setHeader("Content-Type", "application/json")
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        } catch (IOException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int count() {
        return this.getAll().size();
    }
}
