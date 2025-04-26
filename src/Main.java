public class Main
{
    public static void main(String[] args)
    {
        Horse horse1 = new Horse('!', "Joe", 0.6);
        Horse horse2 = new Horse('$', "Bob", 0.6);
        Horse horse3 = new Horse('%', "Steve", 0.6);
        // Create a Race instance (race length of 20 units)
        Race race = new Race(20);
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);
        race.startRace();
    }
}