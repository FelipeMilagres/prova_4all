package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ProductsPage;
import static utils.DriverFactory.*;

public class TesteDesafio1 extends BaseTest {
    @Test
    public void testeDesafioUm(){
        String mensagem = new ProductsPage(getDriver())
                .filtrarDoces()
                .adicionarTodosDoces()
                .filtrarTodos()
                .acessarCarrinho()
                .adicionarMaisBrigadeiro(4)
                .fecharCompra();

        Assert.assertEquals(mensagem, "Pedido realizado com sucesso!");
    }
}