package model;

import java.math.BigDecimal;

// Abstraction: Defines the template for ANY health policy
public abstract class HealthPolicy {
    protected String policyId;
    protected int age;
    protected boolean isSmoker;
    protected BigDecimal basePremium;

    public HealthPolicy(String policyId, int age, boolean isSmoker, String basePremiumStr) {
        this.policyId = policyId;
        this.age = age;
        this.isSmoker = isSmoker;
        this.basePremium = new BigDecimal(basePremiumStr);
    }

    // Abstract method: Every child class MUST define how they calculate their specific premium
    public abstract BigDecimal calculateFinalPremium();

    // Common logic for printing
    public void printQuote() {
        System.out.println("--- Policy Quote (" + this.getClass().getSimpleName() + ") ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Base Premium: " + basePremium);
        System.out.println("Final Premium: " + calculateFinalPremium());
        System.out.println("-------------------------------------------------");
    }
}