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
@EnableConfigurationProperties(value = ApplicationYmlConfig.class)
@TestPropertySource("classpath:application-test.yml")
public class ApplicationYmlConfigTest {

    @Autowired
    private ApplicationYmlConfig applicationYmlConfig;

    @Test
    public void testGetVersion() {
        assertNotNull(applicationYmlConfig);
        assertEquals("\"v1\"", applicationYmlConfig.getVersion());
    }

}
