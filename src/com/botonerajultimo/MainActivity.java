package com.botonerajultimo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private SoundPool soundPool;
	private SparseIntArray soundPoolMap;
	private static final String TAG = MainActivity.class.getSimpleName();
	private int streamID;
	private Bitmap bitmapOrange, bitmapBlue;
	private Drawable drawableOrange, drawableBlue;
	private ImageButton lastButton;
	private ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		init();
		initSound();
	}

	private void init() {
		bitmapOrange = BitmapFactory.decodeResource(
				this.getResources(), R.drawable.button_orange);
		drawableOrange = new BitmapDrawable(this.getResources(),
				bitmapOrange);
		bitmapBlue = BitmapFactory.decodeResource(
				this.getResources(), R.drawable.button);
		drawableBlue = new BitmapDrawable(this.getResources(),
				bitmapBlue);
		
		 b1 = (ImageButton) findViewById(R.id.ImageButton01);
		 b1.setOnClickListener(new OnClick());
		 b2 = (ImageButton) findViewById(R.id.ImageButton02);
		 b2.setOnClickListener(new OnClick());
		 b3 = (ImageButton) findViewById(R.id.ImageButton03);
		 b3.setOnClickListener(new OnClick());
		 b4 = (ImageButton) findViewById(R.id.ImageButton04);
		 b4.setOnClickListener(new OnClick());
		 b5 = (ImageButton) findViewById(R.id.ImageButton05);
		 b5.setOnClickListener(new OnClick());
		 b6 = (ImageButton) findViewById(R.id.ImageButton06);
		 b6.setOnClickListener(new OnClick());
		 b7 = (ImageButton) findViewById(R.id.ImageButton07);
		 b7.setOnClickListener(new OnClick());
		 b8 = (ImageButton) findViewById(R.id.ImageButton08);
		 b8.setOnClickListener(new OnClick());
		 b9 = (ImageButton) findViewById(R.id.ImageButton09);
		 b9.setOnClickListener(new OnClick());
	}
	
	private void initSound() {
		Log.i(TAG, "loading sounds...");
		soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
		soundPoolMap = new SparseIntArray();
		soundPoolMap.put(b1.getId(),
				soundPool.load(this, R.raw.aprete_3_veces, 1));
		soundPoolMap.put(b2.getId(),
				soundPool.load(this, R.raw.cuando_me_ganaste, 1));
		soundPoolMap.put(b3.getId(),
				soundPool.load(this, R.raw.gente_de_la_b, 1));
		soundPoolMap.put(b4.getId(),
				soundPool.load(this, R.raw.hace_como_2_meses, 1));
		soundPoolMap.put(b5.getId(),
				soundPool.load(this, R.raw.mitomano, 1));
		soundPoolMap.put(b6.getId(),
				soundPool.load(this, R.raw.que_hizo, 1));
		soundPoolMap.put(b7.getId(),
				soundPool.load(this, R.raw.san_silencio, 1));
		soundPoolMap.put(b8.getId(),
				soundPool.load(this, R.raw.ultimo_campeon, 1));
		soundPoolMap.put(b9.getId(),
				soundPool.load(this, R.raw.vino_la_nena_sarco, 1));
	}
	
	public void playSound(ImageButton button) {
		Log.i(TAG, "Playing sound for button: " + button);
		soundPool.stop(streamID);
		streamID = soundPool.play(soundPoolMap.get(button.getId()), AudioManager.STREAM_MUSIC,
				AudioManager.STREAM_MUSIC, 1, 0, 1f);
	}
	
	public void changeColor(ImageButton newButton){
		//change the last button from orange to blue
		if (lastButton != null){
			lastButton.setImageDrawable(drawableBlue);
		}
		//change the button from blue to orange
		newButton.setImageDrawable(drawableOrange);
		lastButton = newButton;	
	}
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
	class OnClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			changeColor((ImageButton) v);
			playSound((ImageButton) v);
		}
	}
	
}

