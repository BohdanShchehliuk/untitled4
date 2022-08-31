import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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


// Add an event listener to be notified when an USB storage device is connected or removed
        driveDetector.addDriveListener(System.out::println);

// Unmount a device

    }
}
