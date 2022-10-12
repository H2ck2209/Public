public class Converter {

    private static  final double stepLength = 0.75;
    private static final int caloriesPerStep =  50; //1 килокалория = 1 000 калорий

    double distancePerMonth (int sumStepsPerMonth) {
        double distancePerMonth = sumStepsPerMonth * stepLength / 1000;
        return distancePerMonth;
    }
    double caloriesPerMonth (int sumStepsPerMonth) {
        int caloriesPerMonth = sumStepsPerMonth * caloriesPerStep / 1000;
        return caloriesPerMonth;
    }

}
