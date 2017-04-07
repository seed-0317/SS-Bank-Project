package bankpackage;


import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Dao {

    private static String filename = "src/main/resources/SS-Bank-Dao.txt";


    public static void write(Customer customer) {
        File file = new File(filename);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Customer read() {
        File file = new File(filename);
        ObjectMapper m = new ObjectMapper();
        try {
            Customer customer = m.readValue(file, Customer.class);
            return customer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Customer("123", "jim", 20394);

    }
}


