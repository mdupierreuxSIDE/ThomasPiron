package eu.side.thomaspiron.android.gcm.dto;

public class DeviceRegistrationDTO {

	private String deviceUniqueId;
	private String gcmRegisterToken;
	private String applicationUid;
	private String locale;
	private String os;
	private String osVersion;
	private String deviceType;
	private String applicationVersion;


	public DeviceRegistrationDTO() {

	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}


	public String getDeviceUniqueId() {
		return deviceUniqueId;
	}

	public void setDeviceUniqueId(String deviceUniqueId) {
		this.deviceUniqueId = deviceUniqueId;
	}

	public String getGcmRegisterToken() {
		return gcmRegisterToken;
	}

	public void setGcmRegisterToken(String gcmRegisterToken) {
		this.gcmRegisterToken = gcmRegisterToken;
	}

	public String getApplicationUid() {
		return applicationUid;
	}

	public void setApplicationUid(String applicationUid) {
		this.applicationUid = applicationUid;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

}
