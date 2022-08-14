package ClientDetails;

import java.io.*;
import java.util.ArrayList;

public abstract class DataManager {

    public static void writeFile(String fileName, String message) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> readFile(String fileName) {
        File file=new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {
            String line;
            ArrayList<String> arrayList = new ArrayList<>();
            while ((line = reader.readLine()) != null) arrayList.add(line);
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void serializeFile(String fileName, T recipient) {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(recipient);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T deserializeFile(String fileName, Object obj) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.length() == 0) return (T) obj;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}