import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Thread dt = new Thread();
        dt.setDaemon(true);
        dt.start();
        USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();

// Display all the USB storage devices currently connected
    List <USBStorageDevice> usbStorageDeviceList = driveDetector.getRemovableDevices();

        File folder = new File(usbStorageDeviceList.get(0).getRootDirectory().getPath());
        File[] listOfFiles = folder.listFiles();
        System.out.println(listOfFiles.length);
File test = Arrays.stream(listOfFiles).filter(file ->file.getName().endsWith(".docx")).findFirst().get();
System.out.println("LLL"+ test.toPath());


        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".docx")) {

                System.out.println(file.getName());
            }
        }

//        FileInputStream in = new FileInputStream(listOfFiles[0]);
System.out.println(listOfFiles[0].getAbsoluteFile().getPath());
System.out.println(dt.isDaemon());
        EncryptGen encryptGen = new EncryptGen();

        try {


            String oldFile = new String("C:/Users/Buhgalter2/IdeaProjects/untitled4/src/Новий Документ Microsoft Word (2).docx");
            String newFile = new String("C:/Users/Buhgalter2/IdeaProjects/untitled4/src/NewНовий Документ Microsoft Word (2).docx");
            // Зашифровать
            encryptGen.encryptFile(oldFile, newFile);

            System.out.println ("Полное шифрование");


            String oldFile1 = "C:/Users/Buhgalter2/IdeaProjects/untitled4/src/NewНовий Документ Microsoft Word (2).docx";
            String newFile1 = "C:/Users/Buhgalter2/IdeaProjects/untitled4/src/NEWNewНовий Документ Microsoft Word (2).docx";

            encryptGen.decryptFile(oldFile1,newFile1);
            System.out.println ("Полная расшифровка");

        } catch (Exception e) {
            e.printStackTrace();
        }

// Add an event listener to be notified when an USB storage device is connected or removed
        driveDetector.addDriveListener(System.out::println);

// Unmount a device

    }
}
