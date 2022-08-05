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
    public static void writeFile(String fileName,ArrayList<String> arrayList){
        for (String message:arrayList) writeFile(fileName,message);
    }

    public static ArrayList<String> readFile(String fileName) {
        try (FileReader fr = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fr)) {
            String line;
            ArrayList<String> arrayList = new ArrayList<>();
            while ((line = reader.readLine()) != null) arrayList.add(line);
            return arrayList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializeFile(String fileName, Object recipient) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(recipient);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Object deserializeFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();

        }  catch (IOException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


}



