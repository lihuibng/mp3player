package com.android.inapk;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PlayAudioInapkActivity extends Activity  implements OnClickListener,OnCompletionListener
{
	Button bPlay,bPause,bStop;
	int id1 = 0;
	private MediaPlayer mediaPlayer;
	@Override
	public void onCompletion(MediaPlayer mp)
	{
		mp.release();
		setTitle("资源已经释放");
	}
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        id1= bundle.getInt("id");
        bPlay=(Button)findViewById(R.id.button1);
        bPause=(Button)findViewById(R.id.button2);
        bStop=(Button)findViewById(R.id.button3);
        
        bPlay.setOnClickListener(this);
        bPause.setOnClickListener(this);
        bStop.setOnClickListener(this);
    }
	
	
	 public void onClick(View v) 
		{
	    	Button b=(Button)v;
	    	switch(b.getId())
	    	{
	    	case R.id.button1: 
	    		Toast.makeText(PlayAudioInapkActivity.this,"Play",Toast.LENGTH_SHORT).show();
				mediaPlayer = MediaPlayer.create(this, id1);
				mediaPlayer.setOnCompletionListener(this);
				if (mediaPlayer != null)
					mediaPlayer.stop();
				try
				{
				mediaPlayer.prepare();
				mediaPlayer.start();
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}

	    		break;
	    	case R.id.button2://pause
	    		Toast.makeText(PlayAudioInapkActivity.this,"Pause",Toast.LENGTH_SHORT).show();
	    		mediaPlayer.pause();
	    		break;
	    	case R.id.button3://stop
	    		Toast.makeText(PlayAudioInapkActivity.this,"Stop",Toast.LENGTH_SHORT).show();
	    		mediaPlayer.stop();
	            break;
	    		
	    	
	    	
	    	}
	    	
			
		}
	
	
}