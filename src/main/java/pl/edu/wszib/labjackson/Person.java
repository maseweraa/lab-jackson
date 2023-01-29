package pl.edu.wszib.labjackson;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(
        String firstName,
        String lastName,
        Address address,
        Integer age
) {
}
