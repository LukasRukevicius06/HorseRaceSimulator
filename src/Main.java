import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of horses: ");
        int numHorses = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter race length: ");
        int raceLength = scanner.nextInt();
        scanner.nextLine();

        Race race = new Race(raceLength);

        for (int i = 0; i < numHorses; i++)
        {
            System.out.println("Horse #" + (i + 1));
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter symbol (one character): ");
            char symbol = scanner.nextLine().charAt(0);

            System.out.print("Enter confidence (0.0 - 1.0): ");
            double confidence = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Horse horse = new Horse(symbol, name, confidence);
            race.addHorse(horse);
        }

        race.startRace();
    }
}