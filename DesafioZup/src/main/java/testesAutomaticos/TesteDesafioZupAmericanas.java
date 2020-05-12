package testesAutomaticos;

import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import core.BaseTest;
import core.DSL;

@RunWith(Parameterized.class)
public class TesteDesafioZupAmericanas extends BaseTest {
	JavascriptExecutor js;
	private DSL dsl;

	@Parameter
	public String produto;

	@Before
	public void setUp() {
		getDriver();
		dsl = new DSL();

	}

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
				// [0]
				{ "29302228" },
				// [1]
				{ "panela" },
				// [2]
				{ "" },
				// [3]
				{ "29302228" },

		});
	}

	public static void pesquisaProdutoAdicionaCarrinho(String produto, DSL dsl) {
		dsl.esperaElementoclicavelId("h_search-input");
		dsl.preencheInputPorId("h_search-input", produto);
		dsl.clickid("h_search-btn");
		dsl.esperaElementoclicavelLinkText(produto);
		if (produto != "") {
			dsl.verificaCSSSelector(".title", produto + " em Promoção nas americanas");
			dsl.esperaElementoclicavelXpath(
					"//div[@id=\'content-middle\']/div[6]/div/div/div/div/div/div/div[2]/a/section/div[2]/div/h2");
			String nomeProduto = getDriver().findElement(By.xpath(
					"//div[@id=\'content-middle\']/div[6]/div/div/div/div/div/div/div[2]/a/section/div[2]/div/h2"))
					.getText();
			dsl.clickXpath(
					"//div[@id=\'content-middle\']/div[6]/div/div/div/div/div/div/div[2]/a/section/div[2]/div/h2");
			dsl.esperaElementoclicavelXpath("//a[@id=\'btn-buy\']/div/span");
			dsl.verificaId("product-name-default", nomeProduto);
			dsl.clickXpath("//a[@id=\'btn-buy\']/div/span");
			dsl.esperaElementoclicavelId("buy-button");
			dsl.verificaCSSSelector(".page-title", "minha cesta");
			dsl.verificaCSSSelector(".link-default", nomeProduto);
		} else {
			dsl.verificaCSSSelector(".title", "");
		}
	}

	@Test
	public void pesquisa() {
		pesquisaProdutoAdicionaCarrinho(produto, dsl);

	}

}
