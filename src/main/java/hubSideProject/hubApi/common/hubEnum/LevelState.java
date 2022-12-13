package hubSideProject.hubApi.common.hubEnum;

public enum LevelState {
	
	NOVICE ("NOVICE", "새싹")
	, BEGINNER ("BEGINNER", "초보")
	, INTERMEDIATE("BEGINNER", "중수")
	, ADVANCED("ADVANCED", "고수")
	, PRO("PRO", "고인물")
	;
	
	private String code;
	private String name;
	
	LevelState(String code,String name){
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
