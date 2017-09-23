package tech.teslex.mpes.report.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {

	public static String sendGet(String requestUrl) throws IOException {
		URL url = new URL(requestUrl);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String response = reader.readLine();
		reader.close();
		return response;
	}

}
