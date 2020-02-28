package dao;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
    private Map<String, Double> exchanges = new HashMap<>();

    public void addExchanges() {
        exchanges.put("usd", 24.33);
        exchanges.put("eur", 26.85);
        exchanges.put("rub", 0.39);
        exchanges.put("aud", 16.65);
        exchanges.put("cad", 18.54);
        exchanges.put("cny", 3.52);
        exchanges.put("hrk", 3.61);
        exchanges.put("inr", 0.34);
        exchanges.put("jpy", 0.22);
        exchanges.put("chf", 25.07);
        exchanges.put("gbp", 31.84);
        exchanges.put("egp", 1.54);
        exchanges.put("byn", 11.53);
    }

    public Double getExchange(String key) {
        return exchanges.get(key);
    }

    public String toString() {
        return super.toString();
    }
}
