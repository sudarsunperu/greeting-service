package com.example.demo.greetings.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("Hello, World");
    }

    @Test
    public void greetingShouldReturnNameIfProvided() {
        String name = "Sudarsun";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting?name="+name,
                String.class)).contains("Hello, " + name);
    }

//    @Test
    public void greetingShouldReturnUpperCaseNameIfCapitalizeTrue() {
        String name = "Sudarsun";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting?capitalize=true&name="+name,
                String.class)).contains("Hello, " + name.toUpperCase());
    }
}
