package com.lx.testproject;
public class Thread1 extends Thread
{
    private DeadLock dl;
    
    public Thread1(DeadLock dl)
    {
        this.dl = dl;
    }
    
    public void run()
    {
        try
        {
            dl.rightLeft();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}