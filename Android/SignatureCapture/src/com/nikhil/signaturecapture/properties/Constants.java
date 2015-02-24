package com.nikhil.signaturecapture.properties;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

public class Constants {

	public static final String WEB_SERVICE_ERROR = "500 WEBSERVICE ERROR";
	public static final String HOST = "http://192.168.1.39:8080/SignatureCapture/";

	public static final String SIGN_PREFIX = "sign_";

	/* Webservice */

	/* SIGNATURE_CAPTURE_URL */
	public static final String SIGNATURE_CAPTURE_URL = HOST
			+ "Service/json/SignatureCaptureService.php";

	public static String createImageFile(String imageFileName, Bitmap bitmap,
			Context context) {
		int BUFFER_SIZE = 1024 * 8;
		File file;
		file = new File(context.getFilesDir() + "/" + imageFileName + ".jpg");
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			final BufferedOutputStream bos = new BufferedOutputStream(fos,
					BUFFER_SIZE);
			bitmap.compress(CompressFormat.JPEG, 100, bos);
			bos.flush();
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
		System.out.println("path : " + file.getAbsolutePath());
		return file.getAbsolutePath();
	}

	private Constants() {
	}

}
