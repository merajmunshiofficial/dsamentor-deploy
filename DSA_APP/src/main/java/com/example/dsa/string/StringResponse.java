package com.example.dsa.string;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class StringResponse {
    @Schema(description = "String result")
    private String resultString;
    @Schema(description = "Integer result")
    private Integer resultInt;
    @Schema(description = "List result")
    private List<?> resultList;

    public String getResultString() { return resultString; }
    public void setResultString(String resultString) { this.resultString = resultString; }
    public Integer getResultInt() { return resultInt; }
    public void setResultInt(Integer resultInt) { this.resultInt = resultInt; }
    public List<?> getResultList() { return resultList; }
    public void setResultList(List<?> resultList) { this.resultList = resultList; }

    public static Builder builder() { return new Builder(); }
    public static class Builder {
        private final StringResponse resp = new StringResponse();
        public Builder resultString(String s) { resp.setResultString(s); return this; }
        public Builder resultInt(Integer i) { resp.setResultInt(i); return this; }
        public Builder resultList(List<?> l) { resp.setResultList(l); return this; }
        public StringResponse build() { return resp; }
    }
} 