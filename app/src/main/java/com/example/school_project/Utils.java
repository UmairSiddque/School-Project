package com.example.school_project;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Locale;

public class Utils {
    public static String JsonDataFromAssetSample(Context context) {
        String json=null;
        try {
            InputStream inputStream=context.getAssets().open("sample.json");
            int sizeOfFile=inputStream.available();
            byte[] bufferData=new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
    public static String getMonthName(final int index, final Locale locale, final boolean shortName)
    {
        String format = "%tB";

        if (shortName)
            format = "%tb";

        Calendar calendar = Calendar.getInstance(locale);
        calendar.set(Calendar.MONTH, index);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return String.format(locale, format, calendar);
    }

    public static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}
