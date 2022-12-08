/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package trippy_player.trippy_player;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class mainTest {
    
    public mainTest() {
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

        main nMain = new main();
        
        SoundJLayer sl;
        

        
    /**
     * Test of audioEnd method, of class main.
     */
    @Test
    public void testAudioEnd() throws IOException, Exception {
        System.out.println("audioEnd");
        
        sl = new SoundJLayer("C:\\Users\\Hp\\Documents\\DEAF KEV Invincible NCS Release.mp3");
        
        boolean result;// = nMain.audioEnd();
        fail("false");
    }

    /**
     * Test of loadPlaylists method, of class main.
     */
    @Test
    public void testLoadPlaylists() throws Exception {
        System.out.println("loadPlaylists");
        main instance = new main();
        instance.loadPlaylists();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play_playlistFun method, of class main.
     */
    @Test
    public void testPlay_playlistFun() {
        System.out.println("play_playlistFun");
        main instance = new main();
        instance.play_playlistFun();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
