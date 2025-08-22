package de.hegmanns.training.junit5.extension.training.junit5;


import com.github.tomakehurst.wiremock.*;
import com.github.tomakehurst.wiremock.client.*;
import com.github.tomakehurst.wiremock.core.*;
import org.junit.jupiter.api.*;
import org.springframework.http.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockTest {

    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void beforeAll() {
//        wireMockServer = new WireMockServer(8080);
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(9999));
        wireMockServer.start();

        WireMock.configureFor("localhost", 9999);
        stubFor(get(urlMatching("/provider/omsmappingconfiguration/*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody("hello"))
        );
    }

    @AfterAll
    public static void afterAll() {
        wireMockServer.stop();
    }

    @Test
    void test() {
        System.out.println("it works");
    }

}
