package model;


import util.PolicyRules;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IndividualPolicy extends HealthPolicy {

    public IndividualPolicy(String policyId, int age, boolean isSmoker, String basePremium) {
        super(policyId, age, isSmoker, basePremium);
    }

    @Override
    public BigDecimal calculateFinalPremium() {
        BigDecimal finalAmount = basePremium;

        // 1. Apply Age Loading
        if (this.age > PolicyRules.AGE_RISK_THRESHOLD) {
            finalAmount = finalAmount.multiply(PolicyRules.AGE_LOAD_FACTOR);
        }

        // 2. Apply Smoker Loading
        if (this.isSmoker) {
            finalAmount = finalAmount.multiply(PolicyRules.SMOKER_LOAD_FACTOR);
        }

        // 3. Apply GST (Tax)
        finalAmount = finalAmount.multiply(PolicyRules.GST_RATE);

        // Scale to 2 decimal places (Standard Currency format)
        return finalAmount.setScale(2, RoundingMode.HALF_UP);
    }
}