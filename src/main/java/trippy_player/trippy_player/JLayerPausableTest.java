package trippy_player.trippy_player;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hp
 */

import java.io.*;
import javax.sound.sampled.AudioFormat;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import static javax.sound.sampled.AudioSystem.getAudioInputStream;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class JLayerPausableTest {
    
}

class SoundJLayer extends JLayerPlayerPausable.PlaybackListener implements Runnable
{
	private String filePath;
	JLayerPlayerPausable player;
	private Thread playerThread;
        
        boolean playing_status = false;     // keeping playing status of player
        boolean repeat = false;             // repeat 
        float init_volume = 6f;             // volume
        long lastFrame;                     // keeping last frame of audio
        
        File file;                          // to store file
        
        // storing file size and getting last frame
	public SoundJLayer(String filePath) throws UnsupportedAudioFileException, IOException, Exception
	{
            this.filePath = filePath;    

            file = new File(filePath);

            long tempFileSize = file.length();
            long fileSize = tempFileSize / 418;

            lastFrame = fileSize;
	}

        public void setPitch(int pitch) throws IOException, UnsupportedAudioFileException {
            this.player.setPitch(22050);
        }
        
        // to set volume
        // -80f to 6f values can be passed
        public void setVolume(float gain) throws FileNotFoundException, JavaLayerException {
            
            this.player.setGain(gain);
        }
        
	public void pause()
	{
		this.player.pause();

		this.playerThread.stop();
		this.playerThread = null;
	}

	public void pauseToggle()
	{
		if (this.player.isPaused == true)
		{
			this.play();
		}
		else
		{
			this.pause();
		}
	}

	public void play()
	{
		if (this.player == null)
		{
			this.playerInitialize();
		}

		this.playerThread = new Thread(this, "AudioPlayerThread");

		this.playerThread.start();
	}

	private void playerInitialize()
	{
		try
		{
			String urlAsString = 
				"file:///" 
				//+ new java.io.File(".").getCanonicalPath() 
				+ "/" 
				+ this.filePath;

                        System.out.println(urlAsString);
                        
			this.player = new JLayerPlayerPausable
			(
				new java.net.URL(urlAsString),
				this 
			);
                        
                        player.setLastFrame(lastFrame);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	// PlaybackListener members

	public void playbackStarted(JLayerPlayerPausable.PlaybackEvent playbackEvent)
	{
		System.out.println("playbackStarted()");
	}

	public void playbackFinished(JLayerPlayerPausable.PlaybackEvent playbackEvent)
	{
		System.out.println("playbackEnded()");
	}	

        public int getSliderPosition (){
            return player.frameIndexCurrent;
        }
        
	// IRunnable members

	public void run()
	{
		try
		{
			this.player.resume();
		}
		catch (javazoom.jl.decoder.JavaLayerException ex)
		{
			ex.printStackTrace();
		}

	}
}
