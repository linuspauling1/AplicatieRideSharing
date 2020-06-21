package services;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemServiceTest {
    private FileSystemService fs=new FileSystemService();

    @Test
    public void testPhotoPath() {
        assertEquals(FileSystemService.getPathToFile("src/main/resources/drive.jpg"),FileSystemService.getPhoto());
    }

    @Test
    public void testCustomersPath() {
        assertEquals(FileSystemService.getPathToFile("src/main/resources/customers.json"),FileSystemService.getUser());
    }

    @Test
    public void testDriversPath() {
        assertEquals(FileSystemService.getPathToFile("src/main/resources/drivers.json"),FileSystemService.getDrivers());
    }

    @Test
    public void testComNepPath() {
        assertEquals(FileSystemService.getPathToFile("src/main/resources/data.xml"),FileSystemService.getComNep());
    }

    @Test
    public void testComEfPath() {
        assertEquals(FileSystemService.getPathToFile("src/main/resources/completed.xml"),FileSystemService.getComEf());
    }
}