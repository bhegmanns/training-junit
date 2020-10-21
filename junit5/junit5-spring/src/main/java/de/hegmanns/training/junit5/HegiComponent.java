package de.hegmanns.training.junit5;

import org.springframework.stereotype.Component;

@Component
public class HegiComponent {

    private HegiService service;

    public HegiComponent(HegiService service) {
        this.service = service;
    }

    public String getCommonGreet() {
        return service.doGreet("anyone");
    }
}
