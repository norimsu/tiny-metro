package io.naraplatform.share.domain.lang;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;

public class GlobalPrice implements ValueObject {
    //
    private Currency defaultCurrency;
    private double price;
    private Map<Currency,Double> priceMap;

    public GlobalPrice() {
        //
    }

    public GlobalPrice(Currency defaultCurrency, double price) {
        //
        this();
        this.defaultCurrency = defaultCurrency;
        this.price = price;
        this.priceMap = new HashMap<>();
        this.priceMap.put(defaultCurrency, price);
    }

    public String toString() {
        //
        return toJson();
    }

    public static GlobalPrice fromJson(String json) {
        //
        return JsonUtil.fromJson(json, GlobalPrice.class);
    }

    public static GlobalPrice getSample() {
        //
        Currency currency = Currency.getInstance(Locale.US);
        return new GlobalPrice(currency, 35.6);
    }

    public static GlobalPrice newPrice(Currency currency, double price) {
        //
        GlobalPrice globalPrice = new GlobalPrice(currency, price);
        return globalPrice;
    }

    public GlobalPrice addPrice(Currency currency, double price) {
        //
        if (priceMap == null) {
            this.priceMap = new HashMap<>();
        }

        this.priceMap.put(currency, price);

        return this;
    }

    public double getPriceOf(Currency currency) {
        //
        if (priceMap ==  null) {
            throw new NoSuchElementException("No price except for default currency: " + currency.getSymbol());
        }
        Double currencyPrice = priceMap.get(currency);

        if(currencyPrice == null) {
            throw new NoSuchElementException("No price for currency: " + currency.getSymbol());
        }

        return currencyPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Currency, Double> getPriceMap() {
        return priceMap;
    }

    public void setPriceMap(Map<Currency, Double> priceMap) {
        this.priceMap = priceMap;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
