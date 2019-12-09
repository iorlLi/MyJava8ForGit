package iorl.java8;

public enum AppleEnum {
	RED(0, "RED", "红"),
	GREEN(1, "GREEN", "绿"),
	YELLOW(2, "YELLOW", "黄"),
	NULLENUM(-1, "", "");
	private Integer CODE;
	private String COLOR;
	private String CNDESC;
	private AppleEnum(Integer cODE, String cOLOR, String cNDESC) {
		CODE = cODE;
		COLOR = cOLOR;
		CNDESC = cNDESC;
	}
	public Integer getCODE() {
		return CODE;
	}
	public void setCODE(Integer cODE) {
		CODE = cODE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public String getCNDESC() {
		return CNDESC;
	}
	public void setCNDESC(String cNDESC) {
		CNDESC = cNDESC;
	}
	
	public static String getColorByCode(Integer code) {
		if(code  == null) {
			return "C1";
		}
		AppleEnum[] values = AppleEnum.values();
		for(AppleEnum  value :values) {
			if(value.getCODE().equals(code)) {
				return value.getCOLOR();
			}
		}
		return "C2";
	}
	public static String getDescByCode(Integer code) {
		if(code  == null) {
			return "ɫ1";
		}
		AppleEnum[] values = AppleEnum.values();
		for(AppleEnum  value :values) {
			if(value.getCODE().equals(code)) {
				return value.getCNDESC();
			}
		}
		return "ɫ2";
	}
	
	public static AppleEnum getEnumByCode(Integer code) {
		if(code == null) {
			return NULLENUM;
		}
		AppleEnum[] values = AppleEnum.values();
		for(AppleEnum  value :values) {
			if(value.getCODE().equals(code)) {
				return value;
			}
		}
		return NULLENUM;
	}
	
}
