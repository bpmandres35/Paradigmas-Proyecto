/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rb;

import RB.SalaJuego;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author PC
 */
public class SalaJuegoTest {
    
    public SalaJuegoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of paint method, of class SalaJuego.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        SalaJuego instance = new SalaJuego();
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of actionPerformed method, of class SalaJuego.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent arg0 = null;
        SalaJuego instance = new SalaJuego();
        instance.actionPerformed(arg0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of keyPressed method, of class SalaJuego.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent arg0 = null;
        SalaJuego instance = new SalaJuego();
        instance.keyPressed(arg0);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of moveRight method, of class SalaJuego.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight");
        SalaJuego instance = new SalaJuego();
        instance.moveRight();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of moveLeft method, of class SalaJuego.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        SalaJuego instance = new SalaJuego();
        instance.moveLeft();
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of keyReleased method, of class SalaJuego.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent arg0 = null;
        SalaJuego instance = new SalaJuego();
        instance.keyReleased(arg0);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of keyTyped method, of class SalaJuego.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent arg0 = null;
        SalaJuego instance = new SalaJuego();
        instance.keyTyped(arg0);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
