package com.botonerajultimo;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private SoundPool soundPool;
	private SparseIntArray soundPoolMap;
	private static final String TAG = MainActivity.class.getSimpleName();
	private int streamID;
	private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		initSound();
	}

	private void init() {
		 b1 = (Button) findViewById(R.id.button1);
		 b1.setOnClickListener(new OnClick());
		 b2 = (Button) findViewById(R.id.button2);
		 b2.setOnClickListener(new OnClick());
		 b3 = (Button) findViewById(R.id.button3);
		 b3.setOnClickListener(new OnClick());
		 b4 = (Button) findViewById(R.id.button4);
		 b4.setOnClickListener(new OnClick());
		 b5 = (Button) findViewById(R.id.button5);
		 b5.setOnClickListener(new OnClick());
		 b6 = (Button) findViewById(R.id.button6);
		 b6.setOnClickListener(new OnClick());
		 b7 = (Button) findViewById(R.id.button7);
		 b7.setOnClickListener(new OnClick());
		 b8 = (Button) findViewById(R.id.button8);
		 b8.setOnClickListener(new OnClick());
		 b9 = (Button) findViewById(R.id.button9);
		 b9.setOnClickListener(new OnClick());
	}
	
	private void initSound() {
		Log.i(TAG, "loading sounds...");
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
		soundPoolMap = new SparseIntArray();

		soundPoolMap.put(b1.getId(),
				soundPool.load(this, R.raw.jultifrase1, 1));
		soundPoolMap.put(b2.getId(),
				soundPool.load(this, R.raw.jultifrase2, 1));
		
	}
	
	public void playSound(Button button) {
		Log.i(TAG, "Playing sound for button: " + button);
		soundPool.stop(streamID);
		streamID = soundPool.play(soundPoolMap.get(button.getId()), AudioManager.STREAM_MUSIC,
				AudioManager.STREAM_MUSIC, 1, 0, 1f);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class OnClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			playSound((Button) v);
		}
	}
	
}

