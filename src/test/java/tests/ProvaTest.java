package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PaginaAposLogin;
import pages.PaginaLogin;
import support.Web;


public class ProvaTest {

    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.criarChrome();
    }

    @Test
    public void testRealizarLoginFalha() {

        new PaginaLogin(navegador)
                .fazerLogin("maria", "222");

        WebElement usuario = navegador.findElement(By.xpath("//div[@class=\"alert alert-warning fade in\"]"));
        String mensagemErro = usuario.getText();
        assertEquals("×\nAviso! Usuário ou senha incorretos", mensagemErro);
    }

    @Test
    public void testRealizarLoginSucesso() {

        new PaginaLogin(navegador)
                .fazerLogin("usuario", "123456");
        navegador.navigate().refresh();

        WebElement usuario = navegador.findElement(By.xpath("//h1[text()='Conciliação']"));
        String conciliacao = usuario.getText();
        assertEquals("Conciliação", conciliacao);
    }

    @Test
    public void testVerificarPermissaoSomenteLeitura() {

        new PaginaLogin(navegador)
                .fazerLogin("somente.leitura"   , "leitura");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .visualizaColunasSomenteLeitura("Fila de Trabalho", "Atribuidos",
                        "Concluídos", "Pendência Interna", "Pendência ZG")
                .realizarESalvarFiltroPesquisa();
    }

    @Test
    public void testVerificarPermissaoAnalistaKanban() {

        new PaginaLogin(navegador)
                .fazerLogin("analista.kanban"   , "kanban");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .realizarConfiguracoesMenu()
                .visualizaEManipulaColunas();
    }

    @Test
    public void testSomenteLeituraPesquisa(){

        new PaginaLogin(navegador)
                .fazerLogin("somente.leitura", "leitura");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .pesquisaSomenteLeitura();
    }

    @Test
    public void testLimpaSomenteLeituraPesquisa(){

        new PaginaLogin(navegador)
                .fazerLogin("somente.leitura", "leitura");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .pesquisaSomenteLeitura()
                .limpaPesquisaSomenteLeitura();
    }

    @Test
    public void testSalvarFiltroCompartilhadoKanban() {

        new PaginaLogin(navegador)
                .fazerLogin("analista.kanban", "kanban");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .salvarFiltroCompartilhadoKanban();
    }

    @Test
    public void testSalvarFiltroPadraoKanban() {

        new PaginaLogin(navegador)
                .fazerLogin("analista.kanban", "kanban");
        navegador.navigate().refresh();

        new PaginaAposLogin(navegador)
                .salvarFiltroPadraoKanban();
    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}