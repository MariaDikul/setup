import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\src")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\res")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\savegames")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\temp")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\src\\main")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\src\\test")));
        log.append(createFile(new File("C:\\IdeaProjects\\Games\\src\\main", "Main.java")));
        log.append(createFile(new File("C:\\IdeaProjects\\Games\\src\\main", "Utils.java")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\res\\drawables")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\res\\vectors")));
        log.append(createDir(new File("C:\\IdeaProjects\\Games\\res\\icons")));
        log.append(createFile(new File("C:\\IdeaProjects\\Games\\temp", "temp.txt")));
        try(FileWriter writer = new FileWriter("C:\\IdeaProjects\\Games\\temp\\temp.txt", false)) {
            writer.write(String.valueOf(log));
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String createDir(File dir) {
        Date date = new Date();
        String status;
        if(dir.mkdir()) {
           status = date + " " + dir + " created \n";
        } else {
           status = date + " " + dir + " don't created \n";
        }
        return status;
    }

    public static String createFile(File file) {
        String status = null;
        Date date = new Date();
        try {
            if(file.createNewFile()) {
                status = date + " " + file + " created \n";
            } else {
                status = date + " " + file + " don't created \n"; 
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return status;
    }
}