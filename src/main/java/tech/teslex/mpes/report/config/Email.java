package tech.teslex.mpes.report.config;

public class Email {

	private String smtpAuth;

	private String smtpHost;

	private Integer smtpPort;

	private String username;

	private String password;

	private String receiverMail;

	private String senderEmail;

	private String title;

	private String type;

	private boolean use;

	public Email(String smtpAuth, String smtpHost, Integer smtpPort, String username, String password, String receiverMail, String senderEmail, String title, String type, boolean use) {
		this.smtpAuth = smtpAuth;
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
		this.username = username;
		this.password = password;
		this.receiverMail = receiverMail;
		this.senderEmail = senderEmail;
		this.title = title;
		this.type = type;
		this.use = use;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReceiverMail() {
		return receiverMail;
	}

	public void setReceiverMail(String receiverMail) {
		this.receiverMail = receiverMail;
	}

	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}
}
