package br.unifor.projav1.ws;

import br.unifor.projav1.controllers.ProdutoController;
import br.unifor.projav1.dao.ProdutoDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final ProdutoController produtoController;

    public AppConfig() {
        this.produtoController = new ProdutoController(new ProdutoDAO());
    }

    @Bean
    public ProdutoController produtoController() {
        return this.produtoController;
    }
}
