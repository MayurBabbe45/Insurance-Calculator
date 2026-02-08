package util;

import java.math.BigDecimal;

public class PolicyRules {
    // Using String constructor for BigDecimal is best practice to avoid precision loss
    public static final BigDecimal AGE_LOAD_FACTOR = new BigDecimal("1.20"); // 20% increase
    public static final BigDecimal SMOKER_LOAD_FACTOR = new BigDecimal("1.30"); // 30% increase
    public static final BigDecimal GST_RATE = new BigDecimal("1.18"); // 18% Tax

    public static final int AGE_RISK_THRESHOLD = 45;
}