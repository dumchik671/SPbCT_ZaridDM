package sptktjava;
import java.applet.*;
import java.awt.*;

public class Multi extends Applet implements Runnable
{
    private Thread m_Multi = null;
    boolean going = true;
    private boolean m_fStandAlone = false;
    public static void main(String args[])
    {
        MultiFrame frame = new MultiFrame("Title");
        frame.show(); frame.hide();
        frame.resize(frame.insets().left + frame.insets().right + 320, frame.insets().top + frame.insets().bottom + 240);
        Multi applet_Combi = new Multi();
        frame.add("Center", applet_Combi);
        applet_Combi.m_fStandAlone = true;
        applet_Combi.init();
        applet_Combi.start();
        frame.show();
    }
    public Multi()
    {
    }
    //--------------------------------------------------------------------------
    public String getAppletInfo()
    {	return "Name: CombiApplet\r\n" +
            "";
    }
    //--------------------------------------------------------------------------
    public void init()
    {	resize(320, 240);

    }
    //-------------------------------------------------------------------------
    public void destroy()
    {
    }

    public void paint(Graphics g)
    {
        g.drawString("Running: " + Math.random(), 10, 20);
    }

    public void start()
    {
        if (m_Multi == null)
        {	m_Multi = new Thread(this); // создание потока
            m_Multi.start(); // запуск потока
        }

    }

    public void stop()
    {
        if (m_Multi != null)
        {	going = false;
            m_Multi = null;
        }

    }

    public void run()
    {
        while (true)
        {	try
        {
            repaint();
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            stop();
        }
        }
    }
}