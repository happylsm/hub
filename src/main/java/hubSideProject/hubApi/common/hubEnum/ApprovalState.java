package hubSideProject.hubApi.common.hubEnum;

public enum ApprovalState {
	
	WAIT("WAIT", "승인 대기")
	, DONE("APPROVAL", "승인 완료")
	, REFUSAL("REFUSAL", "승인 거절")
	
	;
	
	
	private String code;
	private String name;
	
	ApprovalState(String code,String name){
		this.code = code;
		this.name = name;
	}
	
	public String getCode(){
		return code;
	}
	
	public String getName(){
		return name;
	}
		
}
