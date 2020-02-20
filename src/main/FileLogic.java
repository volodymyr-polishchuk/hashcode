package main;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileLogic {
    public static void run(String filename) {
        String time = Long.toString(System.currentTimeMillis() / 1000).substring(5);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                Main.class.getClassLoader().getResource(filename).getFile()
                        )
                )
        );
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream(
                                     new File(
                                             "./result" + time + ".txt"
                                     )
                             )
                     )
             )
        ) {
            List<String> collect = reader.lines().collect(Collectors.toList());
            String result = Logic.run(collect);

            writer.write(result);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
