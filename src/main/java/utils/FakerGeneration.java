package utils;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Date;
import java.util.Locale;

public class FakerGeneration {
    public Faker faker = new Faker(new Locale("en-US"));
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());
    String strCategory = ""; String strOutcome = "";

    public String getFakerFirstName() {
        return faker.name().firstName();
    }

    public String getFakerLastName() {
        return faker.name().lastName();
    }

    public String getFakerEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakerPassword() { return faker.internet().password(); }

    public String getFakerAddressName() {
        return faker.address().streetName() + faker.address().cityPrefix();
    }

    public String getFakerCity() {
        return faker.address().city();
    }

    public String getFakerZipCode() {
        /*int i5digit = faker.number().numberBetween(0, 5);
        return String.valueOf(i5digit);*/
        return faker.number().digits(5);
    }

    public String getFakerMobilePhone() {
        return faker.number().numberBetween(1,20) + "-" + faker.number().digits(8);
    }

    public String getFakerAddressAlias() { return faker.address().secondaryAddress(); }

    public String getFakerDayOfBirth() {
        int min = 1;
        int max = 31;
        int iDayOfBirth = faker.number().numberBetween(min, max);
        String dayOfBirth = String.valueOf(iDayOfBirth);
        return dayOfBirth;
    }

    public String getFakerMonthOfBirth() {
        int min = 1;
        int max = 12;
        int iMonthOfBirth = faker.number().numberBetween(min, max);
        String monthOfBirth = String.valueOf(iMonthOfBirth);
        return monthOfBirth;
    }

    public String getFakerYearOfBirth() {
        int min = 1990;
        int max = 2021;
        int iYearOfBirth = faker.number().numberBetween(min, max);
        String yearOfBirth = String.valueOf(iYearOfBirth);
        return yearOfBirth;
    }

}
