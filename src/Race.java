import java.util.concurrent.TimeUnit;
import java.lang.Math;
import java.util.ArrayList;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author Lukas Rukevicius
 * @version 1.3
 */
public class Race
{
    private final int raceLength;
    private ArrayList<Horse> horses;
    private Horse winnerHorse;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance)
    {
        // initialise instance variables
        raceLength = distance;
        horses = new ArrayList<>();
        winnerHorse = null;
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @var horses the arrayList that will store all horses
     */

    public void addHorse(Horse theHorse)
    {
        horses.add(theHorse);
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;

        //run a for loop through horses arrayList to make them all go back to start distance 0
        for (Horse horse : horses)
        {
            horse.goBackToStart();
        }
                      
        while (!finished)
        {
            //move each horse
            for (Horse horse : horses)
            {
                moveHorse(horse);
            }
                        
            //print the race positions
            printRace();
            
            //if any of the three horses has won the race is finished
            for (Horse horse : horses)
            {
                if (raceWonBy(horse))
                {
                    finished = true;
                    break;
                }
            }

            if (allFallen())
            {
                System.out.println("Race ended in a draw. All horses have fallen!");
                return;
            }
           
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }

        System.out.println("Race ended, the winner was: " + (winnerHorse.getName()).toUpperCase());
    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        if (!theHorse.hasFallen())
        {
            if (Math.random() < theHorse.getConfidence())
            {
                theHorse.moveForward();
            }

            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() >= raceLength)
        {
            winnerHorse = theHorse;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print('\u000C');

        multiplePrint('=', raceLength + 3);
        System.out.println();

        for (Horse horse : horses)
        {
            printLane(horse);
            System.out.println();
        }

        multiplePrint('=', raceLength + 3);
        System.out.println();
    }
    
    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);
        
        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('\u2322');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        
        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);
        
        //print the | for the end of the track
        System.out.print('|');

        System.out.print(' ');
        System.out.print((theHorse.getName()).toUpperCase());
        System.out.print(" (Current confidence " + theHorse.getConfidence() + ")");
    }
        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }

    private boolean allFallen()
    {
        for (Horse horse : horses)
        {
            if (!horse.hasFallen())
            {
                return false;
            }
        }
        return true;
    }
}
