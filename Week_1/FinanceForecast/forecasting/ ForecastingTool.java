package forecasting;

public class ForecastingTool {
    public static double futureValueRecursive(double initialAmount, double growthRate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return futureValueRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

    public static double futureValueIterative(double initialAmount, double growthRate, int years) {
        double result = initialAmount;
        for (int i = 0; i < years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }

    public static void main(String[] args) {
        double initial = 10000;
        double growthRate = 0.08;
        int years = 10;

        System.out.println("Recursive Forecasting:");
        double valueRecursive = futureValueRecursive(initial, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, valueRecursive);

        System.out.println("\nIterative Forecasting (Optimized):");
        double valueIterative = futureValueIterative(initial, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, valueIterative);
    }
}
