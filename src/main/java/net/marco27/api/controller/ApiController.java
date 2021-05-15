package net.marco27.api.controller;

import static net.marco27.api.domain.releasenotes.ReleaseNotes.VERSION_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.marco27.api.config.ApiConfig;
import net.marco27.api.domain.releasenotes.ReleaseNotes;

@RestController
@RequestMapping("/" + VERSION_1)
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private final ApiConfig apiConfig;

    @Autowired
    public ApiController(final ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @GetMapping("/releasenotes")
    public ResponseEntity<ReleaseNotes> releaseNotes() {
        final ReleaseNotes result = new ReleaseNotes(apiConfig);
        log.debug("ReleaseNotes: {}", apiConfig.getVersion());
        return ResponseEntity.ok(result);
    }
}
