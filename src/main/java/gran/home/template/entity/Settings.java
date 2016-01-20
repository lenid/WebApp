package gran.home.template.entity;

import java.time.LocalTime;

public class Settings {
	
	private Integer issueTimeoutToCriticalDays;
	
	// Critical issues E-mail notifications
	private boolean enableNotifications;
	private LocalTime notificationsTime;
	private Integer notificationsAccount;
	
	public Integer getIssueTimeoutToCriticalDays() {
		return issueTimeoutToCriticalDays;
	}

	public void setIssueTimeoutToCriticalDays(Integer timeOut) {
		this.issueTimeoutToCriticalDays = timeOut;
	}

	public boolean isEnableNotifications() {
		return enableNotifications;
	}

	public void setEnableNotifications(boolean enableNotifications) {
		this.enableNotifications = enableNotifications;
	}

	public LocalTime getNotificationsTime() {
		return notificationsTime;
	}
	
	public void setNotificationsTime(LocalTime notificationsTime) {
		this.notificationsTime = notificationsTime;
	}

	public Integer getNotificationsAccount() {
		return notificationsAccount;
	}

	public void setNotificationsAccount(Integer notificationsAccount) {
		this.notificationsAccount = notificationsAccount;
	}
}
