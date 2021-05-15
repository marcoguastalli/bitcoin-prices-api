package net.marco27.api.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = ApiConfig.class)
@TestPropertySource("classpath:application-test.yml")
public class ApiConfigTest {

    @Autowired
    private ApiConfig apiConfig;

    @Test
    public void testGetVersion() {
        assertNotNull(apiConfig);
        assertEquals("\"v1\"", apiConfig.getVersion());
    }

}
