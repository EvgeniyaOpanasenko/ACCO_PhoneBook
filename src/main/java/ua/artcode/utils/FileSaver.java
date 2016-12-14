package ua.artcode.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ua.artcode.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lisa on 12/12/2016.
 */
public class FileSaver {

    private String path;
    private Gson gson = new Gson();

    public FileSaver(String path) {
        this.path = path;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public ArrayList<Contact> read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            ArrayList<Contact> users = gson.fromJson(br, new TypeToken<List<Contact>>() {
            }.getType());

            if(users == null){
                users = new ArrayList<>();

            }
            return users;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void save(ArrayList<Contact> users) {

        String json = gson.toJson(users);
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
