package site.kpokogujl.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import site.kpokogujl.config.TestsConfig;

public class TestBase {
    public static String baseUrl;

    @BeforeAll
    static void setUp(){
        TestsConfig config = ConfigFactory.create(TestsConfig.class, System.getProperties());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        baseUrl = config.getBaseUrl();
    }
}
