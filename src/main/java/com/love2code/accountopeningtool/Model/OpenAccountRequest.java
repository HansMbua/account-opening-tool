package com.love2code.accountopeningtool.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class OpenAccountRequest {


    private Long customerId;

    private Double initialCredit;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(Double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
