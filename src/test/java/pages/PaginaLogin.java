package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin extends BasePage{

    public PaginaLogin(WebDriver navegador) {

        super(navegador);
    }

    public PaginaLogin digitarLogin (String login){

        navegador.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(login);

        return this;
    }

    public PaginaLogin digitarSenha (String senha){

        navegador.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(senha);

        return this;
    }

    public PaginaAposLogin clicarIr() {

        navegador.findElement(By.xpath("//input[@id=\"submit\"]")).click();

        return new PaginaAposLogin(navegador);
    }

    public PaginaAposLogin fazerLogin(String login, String senha) {
        digitarLogin(login);
        digitarSenha(senha);
        clicarIr();

        return new PaginaAposLogin(navegador);
    }
}