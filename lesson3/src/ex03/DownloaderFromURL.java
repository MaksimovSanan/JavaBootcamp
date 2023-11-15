package ex03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloaderFromURL implements  Runnable{
    String pathURL;
    int downloadCounter;

    public DownloaderFromURL(String pathURL, int downloadCounter) {
        this.pathURL = pathURL;
        this.downloadCounter = downloadCounter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start download file number " + downloadCounter);
        try {
            URL URLFile = new URL(pathURL);
            byte[] buffer = new byte[2048];
            InputStream is = URLFile.openStream();

//            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
//            String tmp;
//            while((tmp = bf.readLine()) != null) {
//                System.out.println(tmp);
//            }


            try (FileOutputStream fos = new FileOutputStream("Downloads//" + pathURL.substring(pathURL.lastIndexOf("/") + 1))) {
                int length = 0;
                while((length = is.read(buffer)) != -1) {
//                    System.out.println(Arrays.toString(buffer));
                    fos.write(buffer, 0, length);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " finish download file number " + downloadCounter);
    }
}
