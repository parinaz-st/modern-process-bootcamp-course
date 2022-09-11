package com.modern.transaction.dto;

import java.math.BigDecimal;

public class TransferRequestDto
{
    private long sernderAccountId;
    private long recieverAccountId;
    private BigDecimal amount;

    public long getSernderAccountId() {
        return sernderAccountId;
    }

    public void setSernderAccountId(long sernderAccountId) {
        this.sernderAccountId = sernderAccountId;
    }

    public long getRecieverAccountId() {
        return recieverAccountId;
    }

    public void setRecieverAccountId(long recieverAccountId) {
        this.recieverAccountId = recieverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
