package de.hegmanns.training.junit5.extension.training.junit5.special.stocks;

public class Stock {

    private String id;

    private String stockName;

    private String xetraType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getXetraType() {
        return xetraType;
    }

    public void setXetraType(String xetraType) {
        this.xetraType = xetraType;
    }
}
