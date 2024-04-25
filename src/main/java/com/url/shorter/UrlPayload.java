package com.url.shorter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlPayload {

    @JsonProperty("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
