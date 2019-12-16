package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.SelectableChannel;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class PaginaAposLogin extends PaginaLogin {

    private String xpath2 = "/html[1]/body[1]/app-root[1]/app-kanban-holder[1]/div[1]/div[2]/div[2]/app-kanban[1]/div[1]/div[2]/app-filter[1]/div[1]/app-multi-select[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]";

    public PaginaAposLogin(WebDriver navegador) {
        super(navegador);
    }

    public PaginaAposLogin realizarESalvarFiltroPesquisa()  {

        String xpath = "/html[1]/body[1]/app-root[1]/app-kanban-holder[1]/div[1]/div[2]/div[2]/app-kanban[1]/div[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]\t";
        navegador.findElement(By.xpath(xpath)).click();
        navegador.findElement(By.xpath("//span[text()='test']")).click();
        navegador.findElement(By.xpath("//span[text()='Filtros']")).click();
        navegador.findElement(By.xpath("//*[@class='fa fa-floppy-o']")).click();
        navegador.findElement(By.xpath("//button[@class='kb-sv-save mat-mini-fab mat-accent']")).click();

        return this;
    }

    public PaginaAposLogin visualizaColunasSomenteLeitura(String FilaDeTrabalho, String Atribuidos, String Concluidos, String PendenciaInterna, String PendenciaZG) {

        WebElement coluna1 = navegador.findElement(By.xpath("//span[text()='Fila de Trabalho']"));
        FilaDeTrabalho = coluna1.getText();
        assertEquals("Fila de Trabalho", FilaDeTrabalho);

        WebElement coluna2 = navegador.findElement(By.xpath("//span[text()='Atribuidos']"));
        Atribuidos = coluna2.getText();
        assertEquals("Atribuidos", Atribuidos);

        WebElement coluna3 = navegador.findElement(By.xpath("//span[text()='Concluídos']"));
        Concluidos = coluna3.getText();
        assertEquals("Concluídos", Concluidos);

        WebElement coluna4 = navegador.findElement(By.xpath("//span[text()='Pendência Interna']"));
        PendenciaInterna = coluna4.getText();
        assertEquals("Pendência Interna", PendenciaInterna);

        WebElement coluna5 = navegador.findElement(By.xpath("//span[text()='Pendência ZG']\t"));
        PendenciaZG = coluna5.getText();
        assertEquals("Pendência ZG", PendenciaZG);

        return this;
    }

    public PaginaAposLogin realizarConfiguracoesMenu() {

        navegador.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
        navegador.findElement(By.xpath("//span[contains(text(),'Controle de Ações')]")).click();
        navegador.findElement(By.xpath("//span[contains(text(),'Configuração de Colunas')]")).click();

        return this;
    }

    public PaginaAposLogin visualizaEManipulaColunas() {

        navegador.findElement(By.xpath("//span[contains(text(),'Configuração de Colunas')]")).click();
        navegador.findElement(By.xpath("//text()[.='Fila de Trabalho']/ancestor::div[1]")).click();
        navegador.findElement(By.xpath("//text()[.='Atribuidos']/ancestor::div[1]")).click();
        navegador.findElement(By.xpath("//text()[.='Trabalhando']/ancestor::div[1]")).click();
        navegador.findElement(By.xpath("//text()[.='Concluídos']/ancestor::div[1]")).click();
        navegador.findElement(By.xpath("//text()[.='Pendência Interna']/ancestor::div[1]")).click();
        navegador.findElement(By.xpath("//div[@class='mat-tab-header-pagination-chevron']")).click();
        navegador.findElement(By.xpath("//text()[.='Pendência ZG']/ancestor::div[1]")).click();

        return this;
    }

    public PaginaAposLogin pesquisaSomenteLeitura() {

        navegador.findElement(By.xpath("//text()[.='Filtros']/ancestor::button[1]")).click();
        navegador.findElement(By.xpath(xpath2)).click();
        navegador.findElement(By.xpath("//span[contains(text(),'Bradesco')]")).click();
        navegador.findElement(By.xpath("//button[@type='button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2019']/ancestor::span[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2018']/ancestor::span[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//div[text()='1']")).click();

        return this;
    }

    public PaginaAposLogin limpaPesquisaSomenteLeitura() {

        navegador.findElement(By.xpath("//*[@class='fa fa-eraser']")).click();

        return this;
    }

    public PaginaAposLogin salvarFiltroCompartilhadoKanban() {

        navegador.findElement(By.xpath("//*[@class='fa fa-filter']")).click();
        navegador.findElement(By.xpath("//text()[.='Filtros']/ancestor::button[1]")).click();
        navegador.findElement(By.xpath(xpath2)).click();
        navegador.findElement(By.xpath("//span[contains(text(),'Bradesco')]")).click();
        navegador.findElement(By.xpath("//button[@type='button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2019']/ancestor::button[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2018']/ancestor::span[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//div[text()='1']")).click();
        navegador.findElement(By.xpath("//*[@class='fa fa-floppy-o']")).click();
        navegador.findElement(By.xpath("//input[@placeholder='Nome do filtro']")).sendKeys("Teste Salvar Filtro Compartilhado");
        navegador.findElement(By.xpath("//span[text()='Filtro compartilhado']")).click();
        navegador.findElement(By.xpath("//button[@class='kb-sv-save mat-mini-fab mat-accent']")).click();

        WebElement sucessoGravar = navegador.findElement(By.xpath("//span[text()='Sucesso!']\t"));
        String sucessoGravarFiltro = sucessoGravar.getText();
        assertEquals("Sucesso!", sucessoGravarFiltro);

        return this;
    }

    public PaginaAposLogin salvarFiltroPadraoKanban() {

        navegador.findElement(By.xpath("//*[@class='fa fa-filter']")).click();
        navegador.findElement(By.xpath("//text()[.='Filtros']/ancestor::button[1]")).click();
        navegador.findElement(By.xpath(xpath2)).click();
        navegador.findElement(By.xpath("//span[contains(text(),'Bradesco')]")).click();
        navegador.findElement(By.xpath("//button[@type='button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2019']/ancestor::span[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//text()[.='DEZ DE 2018']/ancestor::span[1]")).click();
        navegador.findElement(By.xpath("//div[text()='JAN']")).click();
        navegador.findElement(By.xpath("//button[@class='mat-calendar-previous-button mat-icon-button']")).click();
        navegador.findElement(By.xpath("//div[text()='1']")).click();
        navegador.findElement(By.xpath("//*[@class='fa fa-floppy-o']")).click();
        navegador.findElement(By.xpath("//input[@placeholder='Nome do filtro']")).sendKeys("Teste Filtro Padrão");
        navegador.findElement(By.xpath("//span[text()='Filtro padrão']")).click();
        navegador.findElement(By.xpath("//button[@class='kb-sv-save mat-mini-fab mat-accent']")).click();
        navegador.findElement(By.xpath("//*[@class='fa fa-check']")).click();

        WebElement sucessoGravar = navegador.findElement(By.xpath("//span[text()='Sucesso!']"));
        String sucessoGravarFiltro = sucessoGravar.getText();
        assertEquals("Sucesso!", sucessoGravarFiltro);

        return this;
    }

}