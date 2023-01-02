package com.work.crawler;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.util.Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
public class IndexController {

    List<String> urls = Collections.singletonList(
        "https://www.hermes.com/us/en/product/chaine-d-ancre-enchainee-ring-small-model-H109507Bv00046/");

//    @RequestMapping(method = RequestMethod.GET, path = "/")
    @Scheduled(fixedDelay = 10000 )
    public void crawl() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Downloads/chromedriver");

        String[] params = {
            "sudo",
            "/Applications/Google Chrome.app",
            "/Contents/MacOS/Google Chrome",
            "--remote-debugging-port=9222",
            "--user-data-dir=\"/Users/user/chrome-profile\""
        };

        Runtime.getRuntime().exec(params);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        WebDriver driver = new ChromeDriver(options);
        String url = urls.get(0);

        driver.get(url);
        driver.wait(5000);

//        Elements selects = doc.select("#toggle-content-size-variants > div > h-product-variants > div");

        driver.close();

    }
}
