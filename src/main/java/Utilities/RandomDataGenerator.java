package Utilities;
import com.github.javafaker.Faker;

public class RandomDataGenerator {
    public static Faker faker = new Faker();

    public static String getRandomdataFor(RandomDataTypeNames namestoreturn) {


        switch (namestoreturn) {
            case LASTNAME:
                return faker.lastName();
            case FIRSTNAME:
                return faker.firstName();
            case COUNTRY:
                return faker.country();
            case CITYNAME:
                return faker.cityPrefix();
            default:
                return "";
        }

    }

    public static String getnumberdata() {
        return faker.phoneNumber();
    }

    public static String getAlphanumberdata() {
        return faker.name();
    }
}
