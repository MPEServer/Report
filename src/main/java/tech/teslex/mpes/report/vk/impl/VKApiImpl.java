package tech.teslex.mpes.report.vk.impl;

import tech.teslex.mpes.report.utils.Request;
import tech.teslex.mpes.report.vk.VKApi;

import java.io.IOException;

public class VKApiImpl implements VKApi {
	public String sendMessage(String id, String token, String text) throws IOException {
		return Request.sendGet("https://api.vk.com/method/" +
				"messages.send" +
				"?user_id=" + id +
				"&message=" + text +
				"&access_token=" + token +
				"&v=5.60");
	}
}
