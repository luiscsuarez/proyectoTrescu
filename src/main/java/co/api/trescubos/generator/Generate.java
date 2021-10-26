package co.api.trescubos.generator;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Cliente que consume api remoto de trescubos para creacion y emision de bono
 * especifico
 *
 * @author luissuarez
 */
public class Generate {

    public void generateInTrescubos() {
        try {
            URL url = new URL("http://www.example.com/example");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/xml");

            OutputStream os = connection.getOutputStream();
            os.flush();

            connection.getResponseCode();
            connection.disconnect();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
