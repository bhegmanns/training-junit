package de.hegmanns.training.mock;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

    public static void main(String[] args) {
        System.out.println(convert(BigDecimal.TEN, "USD", "GBP"));
    }

    public static BigDecimal convert(BigDecimal amount, String from, String to) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://api.ratesapi.io/api/latest?symbols=" + from + "," + to);
        Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        String s = request.get(String.class);
        System.out.println(">" + s);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(s).getAsJsonObject();
        String base = jsonObject.get("base").getAsString();
        String date = jsonObject.get("date").getAsString();
        JsonObject rates = jsonObject.get("rates").getAsJsonObject();
        BigDecimal fromRate = rates.get(from).getAsBigDecimal();
        BigDecimal toRate = rates.get(to).getAsBigDecimal();
        return amount.multiply(toRate.divide(fromRate, 4, RoundingMode.HALF_DOWN));
    }
}
