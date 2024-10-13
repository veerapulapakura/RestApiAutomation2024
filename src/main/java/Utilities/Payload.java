package Utilities;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Payload{
public static Map<String, Object>PayloadDataUsinhHashMap() {
    Map<String, Object> payload = new HashMap<>();
    Faker faker = new Faker();
    payload.put("lastname", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.FULLNAME));
    payload.put("lastname", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.LASTNAME));
    payload.put("country", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.COUNTRY));
    payload.put("cityname", RandomDataGenerator.getRandomdataFor(RandomDataTypeNames.CITYNAME));
    return payload;
}
}