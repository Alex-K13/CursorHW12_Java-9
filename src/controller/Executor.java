package controller;

import dao.ExchangeRate;
import service.LfuCache;

public class Executor {
    public static void run() {
        ExchangeRate exchanges = new ExchangeRate();
        exchanges.addExchanges();
        int capacity = 7;
        LfuCache cache = new LfuCache(capacity);
        cache.put(1, exchanges.getExchange("usd"));
        cache.put(2, exchanges.getExchange("eur"));
        cache.put(3, exchanges.getExchange("rub"));
        cache.put(4, exchanges.getExchange("aud"));
        cache.put(5, exchanges.getExchange("cad"));
        cache.put(6, exchanges.getExchange("cny"));
        cache.put(7, exchanges.getExchange("hrk"));
        cache.put(8, exchanges.getExchange("inr"));
        cache.put(9, exchanges.getExchange("jpy"));
        cache.put(10, exchanges.getExchange("chf"));
        cache.put(11, exchanges.getExchange("gbp"));
        cache.put(12, exchanges.getExchange("egp"));
        cache.put(13, exchanges.getExchange("byn"));

        cache.iterateMap();
    }
}

