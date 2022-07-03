package com.example.cexioproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("e")
    private String endPoint;
    @JsonProperty("ok")
    private String status;
    private Data data;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
