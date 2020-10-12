package pages;

import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public ProductsPage filtrarTodos(){
        filtrarCategoria("category-all");
        return this;
    }

    public ProductsPage filtrarBebidas(){
        filtrarCategoria("category-0");
        return this;
    }

    public ProductsPage filtrarDoces(){
        filtrarCategoria("category-1");
        return this;
    }

    public ProductsPage adicionarCocaColaLata(){
        cliquePorId("add-product-0-btn");
        return this;
    }

    public ProductsPage adicionarFantaUvaLata(){
        cliquePorId("add-product-1-btn");
        return this;
    }

    public ProductsPage adicionaAguaMineralSemGas(){
        cliquePorId("add-product-2-btn");
        return this;
    }

    public ProductsPage adicionarTodasBebidas(){
        adicionarCocaColaLata();
        adicionarFantaUvaLata();
        adicionaAguaMineralSemGas();
        return this;
    }

    public ProductsPage adicionarRissoleMedio(){
        cliquePorId("add-product-3-btn");
        return this;
    }

    public ProductsPage adicionarBrigadeiro(){
        cliquePorId("add-product-4-btn");
        return this;
    }

    public ProductsPage adicionarAlfajorChocolatate(){
        cliquePorId("add-product-5-btn");
        return this;
    }

    public ProductsPage adicionarTodosDoces(){
        adicionarBrigadeiro();
        adicionarAlfajorChocolatate();
        return this;
    }

    public CartPage acessarCarrinho(){
        cliquePorId("cart-btn");
        return new CartPage(driver);
    }
}
