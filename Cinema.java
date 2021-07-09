package cinema;


import java.util.Scanner;

public class Cinema {
    static int countTicket = 0;

    static int currentIncome = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("> " + rows);
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println("> " + seats);

        String[][] arrayOfCinema = doubleArray(rows, seats);

        while (flag) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int switcher = scanner.nextInt();
            System.out.println("> " + switcher);

            switch (switcher) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println();
                    showArray(arrayOfCinema);
                    break;
                case 2:
                    buyTicket(arrayOfCinema, seats, rows);
                    System.out.println();
                    break;
                case 3:
                    statistic(rows, seats);
                    break;
            }
        }
        // Write your code here
    }


    public static void buyTicket(String[][] arrayOfCinema, int seats, int rows) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Enter a row number:");
            int memberRow = scanner.nextInt();
            System.out.println("> " + memberRow);
            System.out.println("Enter a seat number in that row:");
            int memberSeat = scanner.nextInt();
            System.out.println("> " + memberSeat);
            if (memberRow <= rows && memberSeat <= seats && memberRow >= 1 && memberSeat >= 1) {
                if (arrayOfCinema[memberRow][memberSeat].equals("S")) {
                    if (seats * rows < 60) {
                        System.out.println("Ticket price: $10");
                        currentIncome = currentIncome + 10;
                    } else {
                        if (memberRow <= rows / 2) {
                            System.out.println("Ticket price: $10");
                            currentIncome = currentIncome + 10;
                        } else {
                            System.out.println("Ticket price: $8");
                            currentIncome = currentIncome + 8;
                        }
                    }
                    arrayOfCinema[memberRow][memberSeat] = "B";
                    countTicket++;
                    break;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public static void statistic(int rows, int seats) {
        int countOfallTickets = rows * seats;
        double percent = countTicket * 1.0 / countOfallTickets * 100;
        System.out.printf("Number of purchased tickets: %d%n", countTicket);
        System.out.printf("Percentage: %.2f%c%n", percent, '%');
        System.out.printf("Current income: $%d%n", currentIncome);
        if (seats * rows < 60) {
            System.out.printf("Total income: $%d%n", rows * seats * 10);
        } else {
            System.out.printf("Total income: $%d%n",
                    rows / 2 * 10 * seats + (rows - rows / 2) * 8 * seats);
        }

    }


    public static void showArray(String[][] arrayOfCinema) {
        System.out.println("Cinema:");
        for (String[] a  : arrayOfCinema) {
            for (String c : a) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static  String[][] doubleArray(int rows, int seats) {
        String[][] arrayOfCinema = new String[rows + 1][seats + 1];
        arrayOfCinema[0][0] = " ";
        for (int i = 1; i < arrayOfCinema[0].length; i++) {
            arrayOfCinema[0][i] = i + "";
        }
        for (int i = 1; i < arrayOfCinema.length; i++) {
            arrayOfCinema[i][0] = i + "";
        }
        for (int i = 1; i < arrayOfCinema.length; i++) {
            for (int b = 1; b < arrayOfCinema[i].length; b++) {
                arrayOfCinema[i][b] = "S";
            }
        }
        return arrayOfCinema;
    }


}