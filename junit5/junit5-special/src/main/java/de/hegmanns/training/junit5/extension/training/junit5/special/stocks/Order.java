package de.hegmanns.training.junit5.extension.training.junit5.special.stocks;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    private String accountNumber;

    private Stock stock;

    private Exchange exchange;

    private LocalDate expireDate;

    private BigDecimal amount;

    private String xetraType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getXetraType() {
        return xetraType;
    }

    public void setXetraType(String xetraType) {
        this.xetraType = xetraType;
    }
}
