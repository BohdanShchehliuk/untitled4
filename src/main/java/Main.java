import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();

// Display all the USB storage devices currently connected
    List <USBStorageDevice> usbStorageDeviceList = driveDetector.getRemovableDevices();

//        File folder = new File(usbStorageDeviceList.get(0).getRootDirectory().getPath());
//        File[] listOfFiles = folder.listFiles();
//        System.out.println(listOfFiles.length);
//File test = Arrays.stream(listOfFiles).filter(file ->file.getName().endsWith(".docx")).findFirst().get();

File file = new File("C:\\Users\\User\\Desktop\\java\\java-starter-materials\\001_Intro\\MyStringAdditional\\untitled4\\src\\CV_Shchehliuk_UKR_27.08.2022.doc");
System.out.println(file.getName().toString());

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        //Adding data to the cipher
        System.out.println(file.toString());
        byte[] input = new Iost.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println(new String(cipherText, "UTF8"));

//System.out.println("LLL"+ test.toPath());


//        for (File file : listOfFiles) {
//            if (file.isFile() && file.getName().endsWith(".docx")) {
//
//                System.out.println(file.getName());
//            }
//        }


// Add an event listener to be notified when an USB storage device is connected or removed
        driveDetector.addDriveListener(System.out::println);

// Unmount a device

    }
}
