package src.controller;

import src.db.ExchangeRate;
import src.service.LfuCache;

public class Executor {
    public static void run() {
        ExchangeRate exchanges = new ExchangeRate();
        exchanges.addExchanges();
        int capacity = 8;
        LfuCache cache = new LfuCache(capacity);

        cache.put(1, exchanges.getValue("usd"));
        cache.put(2, exchanges.getValue("eur"));
        cache.put(3, exchanges.getValue("rub"));
        cache.put(4, exchanges.getValue("aud"));
        cache.put(5, exchanges.getValue("cad"));
        cache.put(6, exchanges.getValue("cny"));
        cache.put(7, exchanges.getValue("hrk"));
        cache.put(8, exchanges.getValue("inr"));
        cache.put(9, exchanges.getValue("jpy"));
        cache.put(10, exchanges.getValue("chf"));
        cache.put(11, exchanges.getValue("gbp"));
        cache.put(12, exchanges.getValue("egp"));
        cache.put(13, exchanges.getValue("byn"));

        cache.iterateMap();
    }
}

