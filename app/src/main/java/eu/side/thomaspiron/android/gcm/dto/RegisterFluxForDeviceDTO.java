package eu.side.thomaspiron.android.gcm.dto;

import java.util.List;


public class RegisterFluxForDeviceDTO{
	
	private String deviceUid;
	private String applicationUid;
	private List<String> fluxUidList;
	
	public RegisterFluxForDeviceDTO(){
		
	}

	public String getDeviceUid() {
		return deviceUid;
	}

	public void setDeviceUid(String deviceUid) {
		this.deviceUid = deviceUid;
	}

	public String getApplicationUid() {
		return applicationUid;
	}

	public void setApplicationUid(String applicationUid) {
		this.applicationUid = applicationUid;
	}

	public List<String> getFluxUidList() {
		return fluxUidList;
	}

	public void setFluxUidList(List<String> fluxUidList) {
		this.fluxUidList = fluxUidList;
	}

	
}
