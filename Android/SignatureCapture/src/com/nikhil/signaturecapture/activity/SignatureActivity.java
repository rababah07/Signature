package com.nikhil.signaturecapture.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.nikhil.signaturecapture.properties.Constants;
import com.nikhil.signaturecapture.views.SignatureView;
import com.nikhil.signaturecapture.webservice.SignatureUploadService;



@SuppressLint("SimpleDateFormat")
public class SignatureActivity extends Activity {
	private SignatureView signView;
	private Button clear, Save;

	private SignatureUploadService upload = new SignatureUploadService();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signature);
		init();

	}

	private void init() {
		signView = (SignatureView) findViewById(R.id.signature);
		clear = (Button) findViewById(R.id.clear);
		clear.setOnClickListener(clearOnClickListrner);
		Save = (Button) findViewById(R.id.save);
		Save.setOnClickListener(SaveOnClickListrner);

	}

	View.OnClickListener clearOnClickListrner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			signView.clear();
		}
	};

	View.OnClickListener SaveOnClickListrner = new OnClickListener() {
		@Override
		public void onClick(View v) {

			signView.setDrawingCacheEnabled(true);
			signView.buildDrawingCache();
			signView.buildDrawingCache(true);
			Bitmap bitmap = Bitmap.createBitmap(signView.getDrawingCache());

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
					.format(new Date());

			String imageFileName = Constants.SIGN_PREFIX + timeStamp;

			upload.setSourceFileUri(Constants.createImageFile(imageFileName,
					bitmap, getApplicationContext()));

			upload.uploadFile();
			bitmap.recycle();
			signView.setDrawingCacheEnabled(false);

		}
	};

}
