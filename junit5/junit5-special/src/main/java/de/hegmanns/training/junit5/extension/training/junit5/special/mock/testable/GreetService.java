package de.hegmanns.training.junit5.extension.training.junit5.special.mock.testable;

import java.time.LocalTime;

public class GreetService {

    public static String sayHello() {
        return "hello" + LocalTime.now().getHour();
    }


    public String greet(String name) {
        int hour = LocalTime.now().getHour();

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
