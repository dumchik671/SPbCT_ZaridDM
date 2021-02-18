
package sptktjava;

import java.awt.*;
import java.awt.event.*;

class MultiFrame extends Frame
{
    public MultiFrame(String str)
    {	super (str);
        addWindowListener(new MyWindowAdapter());
    }
    class MyWindowAdapter extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            dispose();
            System.exit(0);
        }
    }
}