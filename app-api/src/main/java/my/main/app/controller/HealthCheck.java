package my.main.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheck {


    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        log.info("healthcheck probe");
        return ResponseEntity.ok("{\n\tsuccess: true\n}");
    }
}
