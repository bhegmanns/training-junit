package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import java.time.Clock;
import java.time.LocalTime;

public class GreetService02 {

    private Clock clock = Clock.systemDefaultZone();

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public String greet(String name) {
        int hour = LocalTime.now(this.clock).getHour();

        String greetString = "";
        if (hour < 6) {
            greetString = "Good Night";
        }else{
            if (hour < 12) {
                greetString = "Good Morning";
            }else{
                if (hour < 18) {
                    greetString = "Good Day";
                }else{
                    if (hour < 21) {
                        greetString = "Good Evening";
                    }else{
                        greetString = "Good Night";
                    }
                }
            }
        }
        return greetString + ", " + name;
    }

}
