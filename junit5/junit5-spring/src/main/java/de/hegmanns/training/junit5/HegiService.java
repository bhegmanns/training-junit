package de.hegmanns.training.junit5;

import org.springframework.stereotype.Service;

@Service
public class HegiService {

    public String doGreet(String yourName) {
        return "Hello " + yourName;
    }
}
