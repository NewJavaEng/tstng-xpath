package by.http.tstng.tstng_study;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class AppTestcssLocator {

	private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	private static final String DRIVER_PATH = "C:\\driver\\geckodriver.exe";

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		System.setProperty(DRIVER_FIREFOX, DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@Test(enabled = false)
	public void test1() {
		System.out.println("test1: tyt.by title");
		driver.get("https://www.tut.by");
		String title = driver.getTitle();
		assertEquals(title, "Белорусский портал TUT.BY. Новости Беларуси и мира");

	}

	@Test(enabled = false)
	public void task1() throws InterruptedException {
		System.out.println("task 1: find java at google.com");
		driver.get("http://www.google.com");
		WebElement elementSearchForm = driver.findElement(By.id("lst-ib"));
		elementSearchForm.sendKeys("Java");
		WebElement elementButton = driver.findElement(By.name("btnK"));
		elementButton.click();

		Thread.sleep(10000);
		String title = driver.getTitle();
		assertEquals(title, "Java - Поиск в Google");

	}

	@Test(enabled = false)
	public void task2() {
		System.out.println("task 2: news at tut.by");
		driver.get("https://www.tut.by");
		WebElement newsTitle = driver.findElement(By.cssSelector("#title_news_block span.header._title"));
		System.out.println("News Title: " + newsTitle.getText());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement newsPage = driver.findElement(By.cssSelector("#title_news_block img.b-mainnews__img"));
		newsPage.click();

		List<WebElement> paragraph = driver.findElements(By.cssSelector("#article_body > p"));
		int paragrahpQuantity = paragraph.size();
		System.out.println("Quantity of p elements in main news: " + paragrahpQuantity);

	}

	@Test(enabled = false)
	public void task4() {
		System.out.println("task 4: it-academy.by");
		driver.get("https://www.it-academy.by");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print main sidebar menu
		List<WebElement> itemList = driver.findElements(By.cssSelector("ul.nav-menu__list > li"));
		System.out.println("Menu Items: ");
		for (WebElement webElement : itemList) {
			System.out.println(webElement.getText());
		}

		// hoover over обучение menu item, wait when submenu appears
		WebElement education = driver.findElement(By.cssSelector(".nav-menu-item__title"));
		Actions actionOne = new Actions(driver);
		actionOne.moveToElement(education).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print обучение submenu
		List<WebElement> subitemList = driver.findElements(By.cssSelector(".section-panel-list a[href^='/spec']"));
		System.out.println("Subitems of Education: ");
		for (WebElement webElement : subitemList) {
			System.out.println(webElement.getText());
		}

		WebElement menuAll = driver.findElement(By.cssSelector(".asside-middle.js-switch-container.js-panel-section"));
		WebElement menuTitle = driver.findElement(By.cssSelector("a[href='/employment/']"));
		// hover over трудоустройство item and wait a bit -> other dropdown menu will
		// appear
		Actions act = new Actions(driver);
		act.moveToElement(menuTitle).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print title of на кого учиться submenu item and click на кого учиться link in
		// appeared submenu
		WebElement nextTitle = driver.findElement(By.cssSelector("a[href='/employment/na-kogo-uchitsya/']"));
		String itemTitle = nextTitle.getText();
		System.out.println("Required Item title: " + itemTitle);
		nextTitle.click();

		// hoover over обучение menu item, wait when submenu appears
		WebElement educationOne = driver.findElement(By.cssSelector(".nav-menu-item__title"));
		Actions actionTwo = new Actions(driver);
		actionTwo.moveToElement(educationOne).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement marketing = driver
				.findElement(By.cssSelector(".section-panel-list a[href=\"/specialization/marketing/\"]"));
		marketing.click();
	}

	@Test(enabled = false)
	public void task5() {
		System.out.println("task 5: error wrong number at quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement register = driver.findElement(By.cssSelector("#header a[href=\"/LoginAction.registration\"]"));
		register.click();

		WebElement login = driver.findElement(By.cssSelector("#login[size=\"19\"]"));
		login.sendKeys("Lucia132");

		WebElement password = driver.findElement(By.name("registrationForm.password"));
		password.sendKeys("Lucianda132156");

		WebElement passwordConfirm = driver.findElement(By.name("registrationForm.repassword"));
		passwordConfirm.sendKeys("Lucianda132156");

		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("user15-95@mail.ru");

		WebElement finish = driver.findElement(By.name("ok"));
		finish.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement error = driver.findElement(By.cssSelector("#register-form .errors"));
		String errorText = error.getText();
		System.out.println("Error text: " + errorText);
		assertEquals(errorText, "Неправильное число");

	}

	@Test(enabled = false)
	public void task5OneMoreTest() {
		System.out.println("task 5:register into quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement register = driver.findElement(By.cssSelector("#header a[href=\"/LoginAction.registration\"]"));
		register.click();

		WebElement login = driver.findElement(By.cssSelector("#login[size=\"19\"]"));
		login.sendKeys("Lucia132");

		WebElement password = driver.findElement(By.name("registrationForm.password"));
		password.sendKeys("Lucianda132156");

		WebElement passwordConfirm = driver.findElement(By.name("registrationForm.repassword"));
		passwordConfirm.sendKeys("Lucianda132156");

		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("user15-95@mail.ru");

		// stream is goind to sleep for 10 sec and one has time to enter captcha
		// manually
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement finish = driver.findElement(By.name("ok"));
		finish.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(enabled = false)
	public void task5OneMoreTestPlus() {
		System.out.println("task 5: 3 errors at quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement register = driver.findElement(By.cssSelector("#header a[href=\"/LoginAction.registration\"]"));
		register.click();

		WebElement login = driver.findElement(By.cssSelector("#login[size=\"19\"]"));
		login.sendKeys("ladyani");

		WebElement password = driver.findElement(By.name("registrationForm.password"));
		password.sendKeys("ladyanie");

		WebElement passwordConfirm = driver.findElement(By.name("registrationForm.repassword"));
		passwordConfirm.sendKeys("ladyanie");

		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("user1-95@mail.ru");

		WebElement finish = driver.findElement(By.name("ok"));
		finish.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement error = driver.findElement(By.cssSelector("#register-form .errors"));
		String errorText = error.getText();
		System.out.println("Error text: " + errorText);
		// if errorText contains specified text -> true will be returned for
		// assertTrue() method (even if errorText contains 3 messages, but only one
		// message
		// was specified in parameters
		Assert.assertTrue(errorText.contains("Указанный логин занят."));

	}

	@Test
	public void task6() {
		System.out.println("task 6: quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// login into quizful.net
		WebElement entrance = driver.findElement(By.cssSelector("#header a[href=\"/LoginAction.loginForm\"]"));
		entrance.click();

		WebElement loginMy = driver.findElement(By.cssSelector(".content #login"));
		loginMy.sendKeys("ladyani");

		WebElement passwordMy = driver.findElement(By.name("loginForm.password"));
		passwordMy.sendKeys("ladyanie");

		WebElement enterButton = driver.findElement(By.name("ok"));
		enterButton.click();

		WebElement account = driver.findElement(By.cssSelector("#user-panel a[href=\"/user/ladyani\"]"));
		account.click();

		WebElement editButtonFirstClick = driver.findElement(By.cssSelector("a[href=\"/ProfileAction.settings\"]"));
		editButtonFirstClick.click();

		// edit personal data
		WebElement personalData = driver
				.findElement(By.cssSelector("#profile-personal-form .arrow[src=\"/res/blank.gif\"]"));
		personalData.click();

		WebElement firstName = driver.findElement(By.name("personalForm.name"));
		firstName.sendKeys("Lucia");

		WebElement lastName = driver.findElement(By.name("personalForm.surname"));
		lastName.sendKeys("Norkova");

		WebElement dateOfBirth = driver.findElement(By.name("personalForm.birthyear"));
		dateOfBirth.sendKeys("1983");

		WebElement site = driver.findElement(By.name("personalForm.site"));
		site.sendKeys("https://www.tut.by/");

		WebElement company = driver.findElement(By.name("personalForm.company"));
		company.sendKeys("ISTQB");

		// select value from dropdown list
		Select country = new Select(driver.findElements(By.name("personalForm.countryId")).get(0));
		country.selectByVisibleText("Беларусь");

		Select city = new Select(driver.findElements(By.name("personalForm.cityId")).get(0));
		city.selectByVisibleText("Пинск");

		Select timeZone = new Select(driver.findElements(By.name("personalForm.zone")).get(0));
		timeZone.selectByVisibleText("Армения/Ереван(GMT+4)");

		WebElement aboutYourself = driver.findElement(By.name("personalForm.about"));
		aboutYourself.sendKeys("My name is Lucia");

		WebElement avatar = driver.findElement(By.name("personalForm.avatar"));
		avatar.sendKeys("C:\\Users\\Newbie\\Desktop\\av.png");

		WebElement submit = driver.findElement(By.name("personalForm.save"));
		submit.click();

		// edit notifications
		WebElement editButtonSecondClick = driver.findElement(By.cssSelector("a[href=\"/ProfileAction.settings\"]"));
		editButtonSecondClick.click();

		WebElement notification = driver
				.findElement(By.cssSelector("#profile-notifications-form .arrow[src=\"/res/blank.gif\"]"));
		notification.click();

		if (driver.findElement(By.name("notificationsForm.notificationsEnabled")).isSelected()) {

			WebElement notificationFirst = driver.findElement(By.name("notificationsForm.notificationsEnabled"));
			notificationFirst.click();
		}

		if (driver.findElement(By.name("notificationsForm.deliveryEnabled")).isSelected()) {

			WebElement notificationSecond = driver.findElement(By.name("notificationsForm.deliveryEnabled"));
			notificationSecond.click();
		}

		WebElement submitNotif = driver.findElement(By.name("notificationsForm.save"));
		submitNotif.click();

		// edit confidentiality
		WebElement editButtonThirdClick = driver.findElement(By.cssSelector("a[href='/ProfileAction.settings']"));
		editButtonThirdClick.click();

		WebElement editConfidentiality = driver
				.findElement(By.cssSelector("#profile-privacy-form .arrow[src='/res/blank.gif']"));
		editConfidentiality.click();

//		does not work((( do not know why
//		http://toolsqa.com/selenium-webdriver/checkbox-radio-button-operations/
		WebElement onlyMe = driver.findElement(By.cssSelector("#profile-privacy-form tr:nth-of-type(4)"));
		onlyMe.click();

		WebElement submitConf = driver.findElement(By.name("privacyForm.save"));
		submitConf.click();

	}

	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
		driver.close();
		driver = null;
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}

}
