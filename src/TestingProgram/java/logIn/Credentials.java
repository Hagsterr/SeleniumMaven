package logIn;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class Credentials {

    String email = null;
    String password = null;

        File jsonFile = new File("C:\\temp\\facebook.json");

        {

            try {

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(jsonFile);

                email = jsonNode.get("facebookCredentials").get("email").asText();
                password = jsonNode.get("facebookCredentials").get("password").asText();

                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



