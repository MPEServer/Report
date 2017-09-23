package tech.teslex.mpes.report.config;

public class Config {

	private String messageTemplate;

	private String onSendMessage;

	private Email email;

	private Vk vk;

	public Config(String messageTemplate, String onSendMessage, Email email, Vk vk) {
		this.messageTemplate = messageTemplate;
		this.onSendMessage = onSendMessage;
		this.email = email;
		this.vk = vk;
	}

	public String getOnSendMessage() {
		return onSendMessage;
	}

	public void setOnSendMessage(String onSendMessage) {
		this.onSendMessage = onSendMessage;
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = messageTemplate;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Vk getVk() {
		return vk;
	}

	public void setVk(Vk vk) {
		this.vk = vk;
	}
}
