package pl.edu.wszib.labjackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // serializacja
        Person person = new Person(
                "Marcel",
                "Seweryn",
                new Address("Kraków", "00-000", "ul. Testowa", "1"),
                27
        );
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(json);

        // deserializacja
        String exampleJson = """
                {
                  "firstName" : "Marcel",
                  "lastName" : "Seweryn",
                  "address" : {
                      "city" : "Kraków",
                      "zipCode" : "00-000",
                      "street" : "ul. Testowa",
                      "number" : "1"
                    },
                  "age": 1
                }
                """;
        JsonNode deserializedPerson2 = objectMapper.readTree(exampleJson);
        System.out.println(deserializedPerson2);
        JsonNode firstName = deserializedPerson2.get("firstName");
        System.out.println(firstName);

        Person deserializedPerson = objectMapper.readValue(exampleJson, Person.class);
        System.out.println("DeserializedPerson: " + deserializedPerson);

        // Rozszerz rekord Person o dodatkowe property "age"
    }
}
