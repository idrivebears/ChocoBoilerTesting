package com.company.mx.iteso.boilers;

/**
 * Created by gwAwr on 10/29/2015.
 */
public class ChocolateBoiler
{
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler uniqueInstance = null;

    private ChocolateBoiler()
    {
        empty = true;
        boiled = false;
    }
    public void fill()
    {
        synchronized(ChocolateBoiler.class){
            if(isEmpty())
            {
                empty = false;
                boiled = false;
            }
        }
    }

    public void drain()
    {
        synchronized (ChocolateBoiler.class)
        {
            if(!isEmpty() && isBoiled())
            {
                //Drain the boiled milk and chocolate
                empty = true;
            }
        }

    }

    public void boil()
    {
        synchronized(ChocolateBoiler.class)
        {
            if(!isEmpty() && !isBoiled())
            {
                boiled = true;
            }
        }

    }

    public boolean isEmpty()
    {
        return empty;
    }

    public boolean isBoiled()
    {
        return boiled;
    }

    public static ChocolateBoiler getInstance()
    {
        if(uniqueInstance == null)
            synchronized(ChocolateBoiler.class){
                if(uniqueInstance == null){
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        return uniqueInstance;
    }

}
