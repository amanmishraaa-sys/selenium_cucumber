package com.util;
import com.github.javafaker.Faker;

public class Utility {

    Faker faker = new Faker();
    public String getRandomFirstName(){
        return faker.name().firstName();
    }

    public String getRandomLastName(){
        return faker.name().lastName();
    }

    public String getRandomEmail(){
        String firstName = getRandomFirstName();
        String lastName = getRandomLastName();
        return firstName+"."+lastName+"@gmail.com";
    }

    public String getEmailWithProvidedName(String firstName, String lastName){
        return firstName+"."+lastName+"@gmail.com";
    }

    public String getRandomMobileNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }
}
