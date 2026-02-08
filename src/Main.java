


import model.FamilyFloaterPolicy;
import model.HealthPolicy;
import model.IndividualPolicy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing StarHealth Logic Engine...\n");

        List<HealthPolicy> policies = new ArrayList<>();

        // Scenario 1: Young, Non-Smoker, Individual
        // Base: 5000 -> No Age Load -> No Smoker Load -> +18% Tax = 5900.00
        policies.add(new IndividualPolicy("POL001", 25, false, "5000"));

        // Scenario 2: Older (46), Smoker, Individual
        // Base: 10000 
        // -> Age Load (+20%): 12000 
        // -> Smoker Load (+30% on top): 15600 
        // -> Tax (+18%): 18408.00
        policies.add(new IndividualPolicy("POL002", 46, true, "10000"));

        // Scenario 3: Family Floater (2 dependents)
        // Base: 8000
        // -> Dependents (+10%): 8800
        // -> Tax (+18%): 10384.00
        policies.add(new FamilyFloaterPolicy("POL003", 35, false, "8000", 2));

        // POLYMORPHISM IN ACTION
        // We iterate through the generic 'HealthPolicy' list, but the specific
        // logic for each object type is executed automatically.
        for (HealthPolicy policy : policies) {
            policy.printQuote();
        }
    }
}