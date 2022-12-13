package hubSideProject.hubApi.common.hubEnum;

public enum HubRole {
	ROLE_ADMIN("ROLE_ADMIN", 1)
	, ROLE_USER("ROLE_USER", 2);
	
	
	private String code;
	private Integer num;
	
	HubRole(String code, Integer num){
		this.code = code;
		this.num = num;
	}
	
	public Integer getNum(){
		return num;
	}
	
	//HubRole.ROLE_USER.getNum()
	
}
