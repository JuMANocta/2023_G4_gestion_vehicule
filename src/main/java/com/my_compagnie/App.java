package com.my_compagnie;

import javax.swing.SwingUtilities;
import com.my_compagnie.view.VehiculeGUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VehiculeGUI();
            }
        });
    }
}
