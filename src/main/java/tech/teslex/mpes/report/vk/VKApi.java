package tech.teslex.mpes.report.vk;

import java.io.IOException;

public interface VKApi {

	String sendMessage(String id, String token, String text) throws IOException;

}
