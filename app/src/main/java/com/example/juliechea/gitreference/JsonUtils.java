package com.example.juliechea.gitreference;

import android.content.Context;
import android.util.Log;

import com.example.juliechea.gitreference.GitReference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class JsonUtils {

    public static String parseJsonToString(InputStream is) {
        String json = null;
        try {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static ArrayList<GitReference> populateGitReferences(String jsonString) {
        ArrayList<GitReference> data=new ArrayList<>();

        JSONArray jArray = null;
        try {
            // Load json String into a JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);
            
            // Extract all the "command" JSON objects into a JsonArray
            jArray = jsonObject.getJSONArray("commands");

            // Extract json objects from JsonArray and store into ArrayList as class objects
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                GitReference gitReference = new GitReference();
                gitReference.setCommand(json_data.getString("command"));
                gitReference.setExample(json_data.getString("example"));
                gitReference.setExplanations(json_data.getString("explanation"));
                gitReference.setSections(json_data.getString("section"));


                Log.i("JSON", "Adding: " + gitReference.getCommand());
                Log.i("JSON", "Adding: " + gitReference.getExample());
                Log.i("JSON", "Adding: " + gitReference.getExplanations());
                Log.i("JSON", "Adding: " + gitReference.getSections());

                data.add(gitReference);
            }

        } catch (Exception ex) {

        }





        return data;
    }

    public static String read(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }

    public static boolean create(Context context, String fileName, String jsonString){
        try {
            FileOutputStream fos = new FileOutputStream(jsonString);
            if (jsonString != null) {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }

    }

    public static boolean append(Context context, String fileName, String jsonString) {
        // TODO: Your code here

        return false;
    }

    public static boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

}
