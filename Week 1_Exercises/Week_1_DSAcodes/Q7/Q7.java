public class Q7 {

    // Recursive method to calculate future value
    public static double calculateFutureValueRecursive(double currentValue, double growthRate, int periods) {
        // Base case: no periods left, return current value
        if (periods == 0) {
            return currentValue;
        }
        // Recursive case: calculate future value for periods - 1 and apply growth rate
        return calculateFutureValueRecursive(currentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double currentValue = 1000; // Example initial value
        double growthRate = 0.05;   // Example growth rate (5%)
        int periods = 5;            // Number of periods

        // Calculate future value using recursion
        double futureValueRecursive = calculateFutureValueRecursive(currentValue, growthRate, periods);
        System.out.println("Future Value (Recursive): " + futureValueRecursive);
    }
}
