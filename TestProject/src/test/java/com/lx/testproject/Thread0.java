package com.lx.testproject;
public class Thread0 extends Thread
{
    private DeadLock dl;
    
    public Thread0(DeadLock dl)
    {
        this.dl = dl;
    }
    
    public void run()
    {
        try
        {
            dl.leftRight();
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}