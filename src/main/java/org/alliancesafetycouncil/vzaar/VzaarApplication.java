package org.alliancesafetycouncil.vzaar;

import com.vzaar.Video;
import com.vzaar.VideoPageRequest;
import com.vzaar.Vzaar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Calendar;

@SpringBootApplication
public class VzaarApplication implements CommandLineRunner {

	@Autowired
	private VzaarConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(VzaarApplication.class, args);
	}

	@Override
	public void run(String... args) {

		try {
			Vzaar client = Vzaar.make(config.clientId, config.token);

			String title = "upload-test-" + Calendar.getInstance().getTimeInMillis();

			File videoFile = new File(config.videoFilePath);

			Video video = client.videos().uploadWithFile()
					.withFile(videoFile)
					.withTitle(title)
					.withUploader("System")
					.result();

			System.out.println(video.getId());
		}
		catch (Exception e) {
			e.printStackTrace();;
		}
	}
}
