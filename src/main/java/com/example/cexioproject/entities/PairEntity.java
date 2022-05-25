package com.example.cexioproject.entities;

import javax.persistence.*;

@Entity
@Table(name = "Pairs")
public class PairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol1;
    private String symbol2;
    private String pricePrecision;
    private Double minLotSize;
    private Double minLotSizeS2;
    private String maxLotSize;
    private String minPrice;
    private String maxPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getMinLotSize() {
        return minLotSize;
    }

    public void setMinLotSize(Double minLotSize) {
        this.minLotSize = minLotSize;
    }

    public Double getMinLotSizeS2() {
        return minLotSizeS2;
    }

    public void setMinLotSizeS2(Double minLotSizeS2) {
        this.minLotSizeS2 = minLotSizeS2;
    }

    public String getMaxLotSize() {
        return maxLotSize;
    }

    public void setMaxLotSize(String maxLotSize) {
        this.maxLotSize = maxLotSize;
    }

    public String getMinPrice() {
        return minPrice;
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
