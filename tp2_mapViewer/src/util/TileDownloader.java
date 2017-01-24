package util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TileDownloader {

	public static void main(String[] args) {
		Proxy.autenticar();
		// http://tile.openstreetmap.org/11/690/1233.png
		// tiles/12/1380/2465.png Zoom 12
		for (int i = 2000; i < 3000; i++) {
			try (InputStream in = new URL("http://tile.openstreetmap.org/12/1380/" + i + ".png").openStream()) {
				Files.copy(in, Paths.get(i + ".png"), StandardCopyOption.REPLACE_EXISTING);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
