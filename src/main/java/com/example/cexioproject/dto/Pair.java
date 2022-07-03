package com.example.cexioproject.dto;

public class Pair {
    private String symbol1;
    private String symbol2;
    private String pricePrecision;
    private double minLotSize;
    private double minLotSizeS2;
    private Object maxLotSize;
    private String minPrice;
    private String maxPrice;

    public String getSymbol1() {
        return symbol1;
    }

    public void setSymbol1(String symbol1) {
        this.symbol1 = symbol1;
    }

    public String getSymbol2() {
        return symbol2;
    }

    public void setSymbol2(String symbol2) {
        this.symbol2 = symbol2;
    }

    public String getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(String pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public double getMinLotSize() {
        return minLotSize;
    }

    public void setMinLotSize(double minLotSize) {
        this.minLotSize = minLotSize;
    }

    public double getMinLotSizeS2() {
        return minLotSizeS2;
    }

    public void setMinLotSizeS2(double minLotSizeS2) {
        this.minLotSizeS2 = minLotSizeS2;
    }

    public Object getMaxLotSize() {
        return maxLotSize;
    }

    public void setMaxLotSize(Object maxLotSize) {
        this.maxLotSize = maxLotSize;
    }

    public String getMinPrice() {
        return  minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }
}
