package model;


import util.PolicyRules;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FamilyFloaterPolicy extends HealthPolicy {
    private int numberOfDependents;

    public FamilyFloaterPolicy(String id, int age, boolean smoker, String base, int dependents) {
        super(id, age, smoker, base);
        this.numberOfDependents = dependents;
    }

    @Override
    public BigDecimal calculateFinalPremium() {
        BigDecimal finalAmount = basePremium;

        // Family Logic: Add 5% cost for every dependent
        BigDecimal dependentCostFactor = new BigDecimal("0.05").multiply(new BigDecimal(numberOfDependents));
        BigDecimal totalFactor = new BigDecimal("1.0").add(dependentCostFactor); // e.g., 1.10 for 2 kids

        finalAmount = finalAmount.multiply(totalFactor);

        // Standard Risks
        if (this.isSmoker) {
            finalAmount = finalAmount.multiply(PolicyRules.SMOKER_LOAD_FACTOR);
        }

        // Tax
        finalAmount = finalAmount.multiply(PolicyRules.GST_RATE);

        return finalAmount.setScale(2, RoundingMode.HALF_UP);
    }
}