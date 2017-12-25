package by.http.tstng.tstng_study;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AppTestXPath {

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
	public void task1() throws InterruptedException {
		System.out.println("task 1: find java at google.com");
		driver.get("http://www.google.com");
		WebElement elementSearchForm = driver.findElement(By.xpath("//input[@name='q']"));
		elementSearchForm.sendKeys("Java");
		WebElement elementButton = driver.findElement(By.xpath("//input[@name='btnK']"));
		elementButton.click();

		Thread.sleep(10000);
		String title = driver.getTitle();
		assertEquals(title, "Java - Поиск в Google");

	}

	@Test(enabled = false)
	public void task2() {
		System.out.println("task 2: news at tut.by");
		driver.get("https://www.tut.by");
		WebElement newsTitle = driver.findElement(By.xpath("//span[@class='header _title']"));
		System.out.println("News Title: " + newsTitle.getText());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement newsPage = driver.findElement(By.xpath("//img[@class='b-mainnews__img']"));
		newsPage.click();

		List<WebElement> paragraph = driver.findElements(By.xpath("//div[@itemprop='articleBody']/p"));
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
		List<WebElement> itemList = driver.findElements(By.xpath("//ul[@class='nav-menu__list']/li"));
		System.out.println("Menu Items: ");
		for (WebElement webElement : itemList) {
			System.out.println(webElement.getText());
		}

		// hoover over обучение menu item, wait when submenu appears
		WebElement education = driver.findElement(By.xpath("//span[@class='nav-menu-item__title'][text()='Обучение']"));
		Actions actionOne = new Actions(driver);
		actionOne.moveToElement(education).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print обучение submenu
		List<WebElement> subitemList = driver.findElements(By.xpath("//div[@class='col-sm-6']/ul/li/a"));
		System.out.println("Subitems of Education: ");
		for (WebElement webElement : subitemList) {
			System.out.println(webElement.getText());
		}

		// find sidebar menu
		WebElement menuAll = driver
				.findElement(By.xpath("//div[@class='asside-middle js-switch-container js-panel-section']"));
		// find item Трудоустройство
		WebElement menuTitle = driver
				.findElement(By.xpath("//div[@class='nav-menu']/descendant::a[@href='/employment/']"));
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
		WebElement nextTitle = driver.findElement(
				By.xpath("//span[text()='Трудоустройство']/following::a[@href='/employment/na-kogo-uchitsya/']"));
		String itemTitle = nextTitle.getText();
		System.out.println("Required Item title: " + itemTitle);
		nextTitle.click();

		// hoover over обучение menu item, wait when submenu appears
		WebElement educationOne = driver
				.findElement(By.xpath("//span[@class='nav-menu-item__title'][text()='Обучение']"));
		Actions actionTwo = new Actions(driver);
		actionTwo.moveToElement(educationOne).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// click marketing submenu item
		WebElement marketing = driver.findElement(
				By.xpath("//li[@class='panel-section-list__item']/following::a[@href='/specialization/marketing/']"));
		marketing.click();
	}

	@Test(enabled = false)
	public void task5() {
		System.out.println("task 5: error 'wrong number' at quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement register = driver.findElement(By.xpath("//a[@href='/LoginAction.registration']"));
		register.click();

		WebElement login = driver.findElement(By.xpath("//input[@id='login']"));
		login.sendKeys("Lucia132345");

		WebElement password = driver.findElement(By.xpath("//input[@name='registrationForm.password']"));
		password.sendKeys("Lucianda132156");

		WebElement passwordConfirm = driver.findElement(By.xpath("//input[@name='registrationForm.repassword']"));
		passwordConfirm.sendKeys("Lucianda132156");

		WebElement email = driver.findElement(By.xpath("//input[@name='registrationForm.email']"));
		email.sendKeys("user17-95@mail.ru");

		WebElement finish = driver.findElement(By.xpath("//input[@name='ok']"));
		finish.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement error = driver.findElement(By.xpath("//div[@class='errors']"));
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

		WebElement register = driver.findElement(By.xpath("//a[@href='/LoginAction.registration']"));
		register.click();

		WebElement login = driver.findElement(By.xpath("//input[@id='login']"));
		login.sendKeys("Lucia132");

		WebElement password = driver.findElement(By.xpath("//input[@name='registrationForm.password']"));
		password.sendKeys("Lucianda132156");

		WebElement passwordConfirm = driver.findElement(By.xpath("//input[@name='registrationForm.repassword']"));
		passwordConfirm.sendKeys("Lucianda132156");

		WebElement email = driver.findElement(By.xpath("//input[@name='registrationForm.email']"));
		email.sendKeys("user15-95@mail.ru");

		// stream is goind to sleep for 10 sec and one has time to enter captcha
		// manually
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement finish = driver.findElement(By.xpath("//input[@name='ok']"));
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
		System.out.println("task 5: three errors at quizful.net");
		driver.get("http://www.quizful.net");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement register = driver.findElement(By.xpath("//a[@href='/LoginAction.registration']"));
		register.click();

		WebElement login = driver.findElement(By.xpath("//input[@id='login']"));
		login.sendKeys("ladyani");

		WebElement password = driver.findElement(By.xpath("//input[@name='registrationForm.password']"));
		password.sendKeys("ladyanie");

		WebElement passwordConfirm = driver.findElement(By.xpath("//input[@name='registrationForm.repassword']"));
		passwordConfirm.sendKeys("ladyanie");

		WebElement email = driver.findElement(By.xpath("//input[@name='registrationForm.email']"));
		email.sendKeys("user1-95@mail.ru");

		WebElement finish = driver.findElement(By.xpath("//input[@name='ok']"));
		finish.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement error = driver.findElement(By.xpath("//div[@class='errors']"));
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
		WebElement entrance = driver.findElement(By.xpath("//li/a[@href='/LoginAction.loginForm']"));
		entrance.click();

		WebElement loginMy = driver.findElement(By.xpath("//input[@id='login']"));
		loginMy.sendKeys("ladyani");

		WebElement passwordMy = driver.findElement(By.xpath("//input[@name='loginForm.password']"));
		passwordMy.sendKeys("ladyanie");

		WebElement enterButton = driver.findElement(By.xpath("//input[@name='ok']"));
		enterButton.click();

		WebElement account = driver.findElement(By.xpath("//b/a[@href='/user/ladyani']"));
		account.click();

		WebElement editButtonFirstClick = driver.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
		editButtonFirstClick.click();

		// edit personal data
		WebElement personalData = driver
				.findElement(By.xpath("//div[@id='profile-personal-form']/descendant::img[@src='/res/blank.gif']"));
		personalData.click();

		WebElement firstName = driver.findElement(By.xpath("//input[@name='personalForm.name']"));
		firstName.sendKeys("Lucia");

		WebElement lastName = driver.findElement(By.xpath("//input[@name='personalForm.surname']"));
		lastName.sendKeys("Norkova");

		WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='personalForm.birthyear']"));
		dateOfBirth.sendKeys("1983");

		WebElement site = driver.findElement(By.xpath("//input[@name='personalForm.site']"));
		site.sendKeys("https://www.tut.by/");

		WebElement company = driver.findElement(By.xpath("//input[@name='personalForm.company']"));
		company.sendKeys("ISTQB");

		// select value from dropdown list
		Select country = new Select(driver.findElements(By.xpath("//select[@name='personalForm.countryId']")).get(0));
		country.selectByVisibleText("Беларусь");

		Select city = new Select(driver.findElements(By.xpath("//select[@name='personalForm.cityId']")).get(0));
		city.selectByVisibleText("Пинск");

		Select timeZone = new Select(driver.findElements(By.xpath("//select[@name='personalForm.zone']")).get(0));
		timeZone.selectByVisibleText("Армения/Ереван(GMT+4)");

		WebElement aboutYourself = driver.findElement(By.xpath("//textarea[@name='personalForm.about']"));
		aboutYourself.sendKeys("My name is Lucia");

		WebElement avatar = driver.findElement(By.xpath("//input[@name='personalForm.avatar']"));
		avatar.sendKeys("C:\\Users\\Newbie\\Desktop\\av.png");

		WebElement submit = driver.findElement(By.xpath("//input[@name='personalForm.save']"));
		submit.click();

		// edit notifications
		WebElement editButtonSecondClick = driver.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
		editButtonSecondClick.click();

		WebElement notification = driver
				.findElement(By.xpath("//div[@id='profile-notifications-form']/descendant::img[@src='/res/blank.gif']"));
		notification.click();

		if (driver.findElement(By.xpath("//input[@name='notificationsForm.notificationsEnabled']")).isSelected()) {

			WebElement notificationFirst = driver.findElement(By.xpath("//input[@name='notificationsForm.notificationsEnabled']"));
			notificationFirst.click();
		}

		if (driver.findElement(By.xpath("//input[@name='notificationsForm.deliveryEnabled']")).isSelected()) {

			WebElement notificationSecond = driver.findElement(By.xpath("//input[@name='notificationsForm.deliveryEnabled']"));
			notificationSecond.click();
		}

		WebElement submitNotif = driver.findElement(By.xpath("//input[@name='notificationsForm.save']"));
		submitNotif.click();

		// edit confidentiality
		WebElement editButtonThirdClick = driver.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
		editButtonThirdClick.click();

		WebElement editConfidentiality = driver
				.findElement(By.xpath("//div[@id='profile-privacy-form']/descendant::img[@src='/res/blank.gif']"));
		editConfidentiality.click();

		// does not work((( do not know why
		// http://toolsqa.com/selenium-webdriver/checkbox-radio-button-operations/
		WebElement onlyMe = driver.findElement(By.xpath("//descendant::tr[4]/descendant::input[@name='privacyForm.profileVisibility']"));
		onlyMe.click();

		WebElement submitConf = driver.findElement(By.xpath("//input[@name='privacyForm.save']"));
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
