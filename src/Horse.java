
/**
 * The horse class represents individual race participants
 * each horse has its own stats that affect its race outcome
 * 
 * @ author Lukas Rukevicius
 * @ version 1.1
 */
public class Horse
{
    //Fields of class Horse
    private char horseSymbol;
    private String horseName;
    private double horseConfidence;
    private int distance;
    private boolean horseFall;
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
       this.horseSymbol = horseSymbol;
       this.horseName = horseName;
       this.horseConfidence = horseConfidence;
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        horseFall = true;
    }
    
    public double getConfidence()
    {
       return horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return distance;
    }
    
    public String getName()
    {
        return horseName;
    }
    
    public char getSymbol()
    {
        return horseSymbol;
    }
    
    public void goBackToStart()
    {
        distance = 0;
    }
    
    public boolean hasFallen()
    {
        return horseFall;
    }

    public void moveForward()
    {
        distance += 1;
    }

    public void setConfidence(double newConfidence)
    {
        horseConfidence = newConfidence;
        if (horseConfidence < 0)
        {
            horseConfidence = 0;
        }
        else if (horseConfidence > 1)
        {
            horseConfidence = 1;
        }
    }
    
    public void setSymbol(char newSymbol)
    {
        horseSymbol = newSymbol;
    }
    
}
