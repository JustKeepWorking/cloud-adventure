package com.nduyhai.cloudadventure.monitoring.domain;

import java.io.Serializable;

public class Greeting implements Serializable {

    private Integer id;

    public String quote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
