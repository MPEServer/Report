package tech.teslex.mpes.report.config;

public class Vk {

	private String senderToken;

	private Long receiverId;

	private boolean use;

	public Vk(String senderToken, Long receiverId, boolean use) {
		this.senderToken = senderToken;
		this.receiverId = receiverId;
		this.use = use;
	}

	public String getSenderToken() {
		return senderToken;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public boolean isUse() {
		return use;
	}
}
