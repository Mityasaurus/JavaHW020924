package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Smith", "John", User.Gender.MALE, LocalDateTime.now()),
                new User(2, "Doe", "Jane", User.Gender.FEMALE, LocalDateTime.now().minusHours(1)),
                new User(3, "Brown", "Alex", User.Gender.NOT_SPECIFIED, LocalDateTime.now().minusDays(1)),
                new User(4, "White", "Chris", User.Gender.MALE, LocalDateTime.now().minusMinutes(30)),
                new User(5, "Black", "Taylor", User.Gender.FEMALE, LocalDateTime.now().minusSeconds(15))
        );

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(users);
        System.out.println(json);

        File file = Paths.get("file.txt").toFile();

        try {
            FileUtils.writeStringToFile(file, json, StandardCharsets.UTF_8);
            System.out.println("Successfully wrote json to file");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        //
        try {
            json = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println("Successfully read json from file");
            Set<User> userSet = gson.fromJson(json, new TypeToken<>() {});

            System.out.println(userSet);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}