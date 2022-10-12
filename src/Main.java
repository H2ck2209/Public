import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthData monthData = new MonthData();
        StepTracker stepTracker = new StepTracker();
        System.out.println("Выберите действие" + "\n");

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите месяц");
                int month;
                while (true) {
                    month = scanner.nextInt();
                    if (month > 12) {
                        System.out.println("Номер месяца должен быть от 1 до 12. Повторите ввод");
                    } else if (month < 1) {
                        System.out.println("Номер месяца не может быть отрицательным. Повторите ввод");
                    } else break;
                }
                System.out.println("Введите день");
                int day;
                while (true) {
                    day = scanner.nextInt();
                    if (day > 30) {
                        System.out.println("Повторите ввод. Укажите число от 1 до 30");
                    } else if (day < 1) {
                        System.out.println("Число не может быть отрицательным. Повторите ввод");
                    } else break;
                }
                System.out.println("Введите количество шагов");
                int userSteps;
                while (true) {
                    userSteps = scanner.nextInt();
                    if (userSteps < 1) {
                        System.out.println("Число шагов должно быть больше нуля. Повторите ввод");
                    } else break;
                }
                stepTracker.saveUserSteps(month, day, userSteps);
                System.out.println("Количество шагов " + userSteps + " за день " + day + " месяца " + month + " сохранено"
                        + "\n");
            } else if (command == 2) {
                System.out.println("Введите месяц");
                int month = scanner.nextInt();
                stepTracker.printStatistics(month);
                for (int i = 0; i < stepTracker.getStepsPer30days(month).length; i++) {
                    System.out.println("День " + (i + 1) + ": " + stepTracker.getStepsPer30days(month)[i] + ",");
                }
                System.out.println("Сумма шагов в месяц: " + stepTracker.sumStepsPerMonth(month));
                System.out.println("Максимальное количество шагов за день в месяце: " + stepTracker.maxSteps(month));
                System.out.println("Среднее количество шагов в месяце: " + stepTracker.averageSteps(month));
                System.out.println("Дистанция за месяц (км): " + stepTracker.monthDistance(month));
                System.out.println("Сожжено килокалорий в месяц: " + stepTracker.caloriesPerMonth(month));
                System.out.println("Лучшая серия выполнений цели по шагам (дней): " + stepTracker.bestSeries(month));
            } else if (command == 3) {
                System.out.println("Введите цель по количеству шагов в день");
                while (true) {
                    stepTracker.dailyGoalSteps = scanner.nextInt();
                    if (stepTracker.dailyGoalSteps > 0) {
                        System.out.println("Новая цель по количеству шагов в день: " + stepTracker.dailyGoalSteps);
                        System.out.println();
                        break;
                    } else System.out.println("Цель должна быть больше нуля. Повторите ввод");
                }
            } else if (command == 4) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Такой команды нет");
            }

        }
    }

    public static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день\n" +
                "2. Напечатать статистику за определённый месяц\n" +
                "3. Изменить цель по количеству шагов в день\n" +
                "4. Выйти из приложения");
    }
}