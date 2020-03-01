package src.db;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {
    private Map<String, String> exchanges = new HashMap<>();

    public void addExchanges() {
        exchanges.put("usd", "24.33 uah");
        exchanges.put("eur", "26.85 uah");
        exchanges.put("rub", "0.39 uah");
        exchanges.put("aud", "16.65 uah");
        exchanges.put("cad", "18.54 uah");
        exchanges.put("cny", "3.52 uah");
        exchanges.put("hrk", "3.61 uah");
        exchanges.put("inr", "0.34 uah");
        exchanges.put("jpy", "0.22 uah");
        exchanges.put("chf", "25.07 uah");
        exchanges.put("gbp", "31.84 uah");
        exchanges.put("egp", "1.54 uah");
        exchanges.put("byn", "11.53 uah");
    }

    public String getValue(String key) {
        return exchanges.get(key);
    }

    public String toString() {
        return super.toString();
    }
}
