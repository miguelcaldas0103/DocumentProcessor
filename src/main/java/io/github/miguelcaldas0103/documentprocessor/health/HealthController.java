package io.github.miguelcaldas0103.documentprocessor.health;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthController {
    @GetMapping("path")
    public String getAppHealth() {
        return new String("OK");
    }
}
