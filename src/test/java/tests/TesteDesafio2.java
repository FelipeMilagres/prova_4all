package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.ProductsPage;
import static utils.DriverFactory.*;

public class TesteDesafio2 extends BaseTest {
    @Test
    public void testDesafioDois() {
        String valorTotal = new ProductsPage(getDriver())
                .filtrarBebidas()
                .adicionarTodasBebidas()
                .filtrarTodos()
                .adicionarRissoleMedio()
                .acessarCarrinho()
                .adicionarMaisRissoleMedio(9)
                .removerRissoleMedio(5)
                .valorTotalCompra();

        Assert.assertEquals(valorTotal, "R$ 36,00");

        String mensagem = new CartPage(getDriver())
                .fecharCompra();

        Assert.assertEquals(mensagem, "Pedido realizado com sucesso!");
    }
}