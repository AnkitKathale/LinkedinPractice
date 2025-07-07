package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JSONReader {

    public static String existingUser(String data) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser ();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\ExistingUser.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject existingUser = (JsonObject) obj;
        return existingUser.get(data).getAsString();
    }
    public static String accountDetails(String data) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\AccountDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject accountDetails = (JsonObject) obj;
        return accountDetails.get(data).getAsString();
    }

    public static String paymentDetails(String data) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\PaymentDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject paymentDetails = (JsonObject) obj;
        return paymentDetails.get(data).getAsString();
    }

    public static String poloBrandProducts(String data) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\PoloBrandProducts.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject poloBrandProducts = (JsonObject) obj;
        return poloBrandProducts.get(data).getAsString();
    }

    public static String madameBrandProducts(String data) throws IOException, ParseException {
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\MadameBrandProducts.json");
        Object obj = jsonParser.parse(fileReader);
        JsonObject madameBrandProducts = (JsonObject) obj;
        return madameBrandProducts.get(data).getAsString();
    }
}
