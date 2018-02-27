package com.alphatica.genotick.account;

import java.math.BigDecimal;

class Trade {

    private BigDecimal quantity;

    private BigDecimal price;

    Trade(BigDecimal quantity, BigDecimal price) {
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    BigDecimal value() {
        return getQuantity().abs().multiply(getPrice());
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
