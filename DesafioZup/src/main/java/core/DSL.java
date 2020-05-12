package core;

import static core.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	public void preencheInputPorId(String id, String valor) {
		getDriver().findElement(By.id(id)).sendKeys(valor);
	}
	

	public void esperaElementoclicavelLinkText(String link) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
	}

	public void esperaElementoclicavelCSSSelector(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
	}

	public void esperaElementoclicavelId(String id) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	public void esperaElementoclicavelXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void esperaAlert(String id) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void clickLinkText(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public void clickCSSSelector(String cssSelector) {
		getDriver().findElement(By.cssSelector(cssSelector)).click();
	}

	public void clickid(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public void maximizaTela() {
		getDriver().manage().window().maximize();
	}

	public void verificaCSSSelector(String cssSelector, String valor) {
		assertThat(getDriver().findElement(By.cssSelector(cssSelector)).getText(), is(valor));
	}

	public void verificaId(String id, String valor) {
		assertThat(getDriver().findElement(By.id(id)).getText(), is(valor));
	}


}
