package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    public CartPage adicionarMaisRissoleMedio(int quantidade){
        for(int i = 0; i < quantidade; i++){
            cliquePorId("add-product-3-qtd");
        }
        return this;
    }

    public CartPage removerRissoleMedio(int quantidade){
        for(int i = 0; i < quantidade; i++){
            cliquePorId("remove-product-3-qtd");
        }
        return this;
    }

    public CartPage adicionarMaisBrigadeiro(int quantidade){
        for(int i = 0; i < quantidade; i++){
            cliquePorId("add-product-4-qtd");
        }
        return this;
    }

    public String valorTotalCompra(){
        return getTextoId("price-total-checkout");
    }

    public String fecharCompra(){
        cliquePorId("finish-checkout-button");
        return getTextoXpath("//*[contains(@class, 'sc-dNLxif jyncPa')]");
    }

    public static void fecharModal(){
        cliquePorXpath("//*[contains(@class, 'close-modal sc-jqCOkK ippulb')]");
    }
}