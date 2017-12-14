package eu.side.thomaspiron.android.gcm.dto;

import java.util.List;


public class CategoryDeviceDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1971190506994472340L;
	private String name;
	private String elementUid;
	private List<FluxDeviceDTO> fluxList;
	
	public CategoryDeviceDTO() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getElementUid() {
		return elementUid;
	}

	public void setElementUid(String elementUid) {
		this.elementUid = elementUid;
	}

	public List<FluxDeviceDTO> getFluxList() {
		return fluxList;
	}

	public void setFluxList(List<FluxDeviceDTO> fluxList) {
		this.fluxList = fluxList;
	}
	
}
