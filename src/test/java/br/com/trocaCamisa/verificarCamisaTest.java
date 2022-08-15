package br.com.trocaCamisa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.mail.EmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.trocaCamisa.*;

public class verificarCamisaTest {

	private WebDriver driver;
//	private iptvHomePage homePage;
//	private AmazonHomePage amazonHomePage;
	Dimension d = new Dimension(1920, 1080);

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void inicio() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		//options.addArguments("--headless=chrome");
		// options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		// options.merge(capabilities);
		driver = new ChromeDriver(options);
		// driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--headless");
//		
//		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36 OPR/60.0.3255.170";
//		options.addPreference("general.useragent.override",userAgent);
//		
//		
//		
//		//options.addArguments("--window-size=1200,800");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--no-sandbox");
		// options.addArguments("--disable-dev-shm-usage");
//		driver = new FirefoxDriver(options);	
//		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
//     	amazonHomePage = new AmazonHomePage(driver);
//		

//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--headless");
//		options.addArguments("--window-size=1200,800");
//		options.addArguments("browserVersion", "99");
//		options.addArguments("platformName", "Windows 10");

		options.addArguments(
				"--user-agent=\"Mozilla/99.0.4844.51 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML,like Gecko) Chrome/99.0.4844.51 Safari/537.36\"");
		// options.addArguments("--incognito");
		// driver = new ChromeDriver(options);
		// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

		// driver = new ChromeDriver();
//		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//		amazonHomePage = new AmazonHomePage(driver);

	}

	@Test
	public void verificarDisponibilidade() throws InterruptedException, EmailException {

		driver.get("https://www.adidas.com.br/");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(
				"body.no-chat-button:nth-child(2) div.gl-app div.content-wrapper___7kDpB.content-visibility-enabled___9none div.sheet___3v2Q_.page-content___ayp8d div.header___1FxHS.gl-is-sticky.fixed___3SAJN:nth-child(2) div.header-desktop___3T36B:nth-child(3) div.glass-header-bottom-desktop-white___38y1Y:nth-child(3) div.inner___2IOZ- div.right-side-menu___16Ik7 div.gl-profile-icon.profile_button___34dLM div:nth-child(1) button.gl-cta.gl-cta--tertiary.profile_button_link___WQCT9.outlined-icon-color___1fd_i.undefined > span.gl-cta__content"))
				.click(); // homePage = new iptvHomePage(driver);
		// amazonHomePage = new AmazonHomePage(driver);
		Thread.sleep(2000);
		// driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.id("login-register-auto-flow-input")).click();
		driver.findElement(By.id("login-register-auto-flow-input")).sendKeys("hud.email@yahoo.com.br");
		driver.findElement(By.cssSelector(
				"body.no-chat-button.gl-modal-open:nth-child(2) div.gl-app div.gl-modal.gl-modal--active.gl-modal--small.glass-modal___Mshhk div.gl-modal__dialog.gl-modal__dialog--small div.gl-modal__main div.gl-modal__main-content div:nth-child(1) form.gl-vspace-bpall-small:nth-child(7) > button.gl-cta.gl-cta--primary.gl-cta--full-width:nth-child(3)"))
				.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// Wait for modal
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"body.no-chat-button.gl-modal-open:nth-child(2) div.gl-app div.gl-modal.gl-modal--active.gl-modal--small.glass-modal___Mshhk div.gl-modal__dialog.gl-modal__dialog--small div.gl-modal__main div.gl-modal__main-content div:nth-child(1) form.gl-vspace-bpall-small:nth-child(7) > button.gl-cta.gl-cta--primary.gl-cta--full-width:nth-child(3)")));
		// Select last child of content div
		WebElement element = driver.findElement(By.cssSelector(
				"body.no-chat-button.gl-modal-open:nth-child(2) div.gl-app div.gl-modal.gl-modal--active.gl-modal--small.glass-modal___Mshhk div.gl-modal__dialog.gl-modal__dialog--small div.gl-modal__main div.gl-modal__main-content div:nth-child(1) form.gl-vspace-bpall-small:nth-child(7) > button.gl-cta.gl-cta--primary.gl-cta--full-width:nth-child(3)"));
		// Scroll to last child node
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[data-auto-id=\"social-login-form-facebook\"]")).click();

		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("hud.email@yahoo.com.br");
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).sendKeys("@AnnaIra838383");
		driver.findElement(By.id("loginbutton")).click();

		Thread.sleep(4000);

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Ir para sua conta']")));

		driver.findElement(By.xpath("//*[.='Ir para sua conta']")).click();

		Thread.sleep(4000);
		
		@SuppressWarnings("deprecation")
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ORDER")));
		
		driver.findElement(By.id("ORDER")).click();
		driver.findElement(By.cssSelector("a[href=\"/order-tracker\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name=\"orderNo\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"orderNo\"]")).sendKeys("ABR12677669");

		driver.findElement(By.cssSelector("input[name=\"email\"]")).click();
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys("hu.psilva@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[.='Fazer troca ou devolução']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[.='TROCA']")).click();

		try {

			WebElement informacao = driver.findElement(By.cssSelector("p[class=\"gl-no-margin-bottom\"]"));
			String texto = informacao.getText();

			if (texto == null && texto.isEmpty() | texto != "Esgotado") {

				String mensagem = "MANO OLHA LA SE DA PRA TROCAR ";
				String site = "https://www.adidas.com.br";
				String pedido= "ABR12677669";
				whats wts = new whats();
				wts.mensagem(mensagem + " " + site + " " + pedido);

			} else {

				String mensagem = "AINDA ESGOTADO";

				whats wts = new whats();
				wts.mensagem(mensagem);

			}

		} catch (Exception e) {

			String mensagem = "MANO OLHA LA SE DA PRA TROCAR Pq deu um erro estranho";
			String site = "https://www.adidas.com.br";
			String pedido= "ABR12677669";
			
			NotificarPorEmail email = new NotificarPorEmail();
			email.EnviarEmail(mensagem);
			
			whats wts = new whats();
			wts.mensagem(mensagem + " " + site + " " + pedido);

		}

	}

	@AfterEach
	public void fechar() {

		driver.close();

	}

}
