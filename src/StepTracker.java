import java.util.Scanner;

public class StepTracker {
    MonthData[] monthData;
    Converter converter = new Converter();
    Scanner scanner = new Scanner(System.in);
    int dailyGoalSteps = 10000;



    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }


    int saveUserSteps(int month, int day, int userSteps) {
        //сохранение количества шагов
        monthData[month - 1].dayData[day - 1] = userSteps;
        return userSteps;
    }

    void printStatistics(int month) {
        getStepsPer30days(month);
        sumStepsPerMonth(month);
        maxSteps(month);
        averageSteps(month);
        monthDistance(month);
        caloriesPerMonth(month);
        bestSeries(month);
    }


    int[] getStepsPer30days(int month) {
        return monthData[month - 1].dayData;
    }

    int sumStepsPerMonth(int month) {
        //сумма шагов за месяц
        int sum = 0;
        for (int i = 0; i < monthData[month - 1].dayData.length; i++) {
            sum = sum + monthData[month - 1].dayData[i];
        }
        return sum;
    }

    int maxSteps(int month) {
        //Максимальное количество шагов в месяце
        int maxSteps = 0;
        for (int i = 0; i < monthData[month - 1].dayData.length; i++) {
            if (monthData[month - 1].dayData[i] > maxSteps) {
                maxSteps = monthData[month - 1].dayData[i];
            }
        }
        return maxSteps;
    }

    double averageSteps(int month) {
        //Среднее количество шагов в месяц
        double averageSteps = sumStepsPerMonth(month) / monthData[month - 1].dayData.length;
        return averageSteps;
    }

    double monthDistance(int month) {
        //Пройденная дистанция за месяц
        double result = converter.distancePerMonth(sumStepsPerMonth(month));
        return result;
    }

    double caloriesPerMonth(int month) {

        //Количество килокалорий за месяц
        double result2 = converter.caloriesPerMonth(sumStepsPerMonth(month));
        return result2;
    }

    int bestSeries(int month) {
        //лучшая серия
        int currentSeries = 0;
        int bestSeries = 0;
        for (int i = 0; i < monthData[month - 1].dayData.length; i++) {
            if (monthData[month - 1].dayData[i] >= dailyGoalSteps) {
                currentSeries = currentSeries + 1;
                //ошибка с показанием 30 числа месяца в серии
            } else if (currentSeries > bestSeries) {
                bestSeries = currentSeries;
                currentSeries = 0;
            }
        }
        if (currentSeries > bestSeries)
            bestSeries = currentSeries;
        return bestSeries;
    }
}




