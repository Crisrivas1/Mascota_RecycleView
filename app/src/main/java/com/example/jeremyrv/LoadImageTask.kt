package com.example.jeremyrv

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class LoadImageTask(val imageview : ImageView): AsyncTask<String, Void, Bitmap>()
{
    override fun doInBackground(vararg p0: String?): Bitmap? {
        val image = p0[0]
        var bitmap: Bitmap? = null
        var connection: HttpURLConnection? = null

        try {
            var url =  URL(image)
            connection = url.openConnection() as HttpURLConnection
            connection.connect()
            var inputStream : InputStream = connection.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)


        } catch (e: Exception)
        {

        }
        finally {
            connection?.disconnect()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        if (result !=null)
        {
            imageview.setImageBitmap(result)
        }

    }
}