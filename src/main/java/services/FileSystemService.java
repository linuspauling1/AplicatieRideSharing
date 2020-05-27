package services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    private static final String USER_FOLDER = System.getProperty("user.dir");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER);
    private static final Path USERS_PATH = FileSystemService.getPathToFile("src/main/resources/customers.json");
    private static final Path DRIVERS_PATH = FileSystemService.getPathToFile("src/main/resources/drivers.json");
    private static final Path PHOTO_PATH = FileSystemService.getPathToFile("src/main/resources/drive.jpg");
    private static final Path COM_NEP_PATH = FileSystemService.getPathToFile("src/main/resources/data.xml");
    private static final Path COM_EF_PATH = FileSystemService.getPathToFile("src/main/resources/completed.xml");
    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get("", path));
    }
    public static Path getUser(){
        return USERS_PATH;
    }
    public static Path getDrivers(){
        return DRIVERS_PATH;
    }
    public static Path getPhoto(){
        return PHOTO_PATH;
    }
    public static Path getComNep(){
        return COM_NEP_PATH;
    }
    public static Path getComEf(){
        return COM_EF_PATH;
    }
}
