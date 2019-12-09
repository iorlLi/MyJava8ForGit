package iorl.java8;

public class Apple {
	private Integer color;
	private Integer weight;

	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Apple(Integer color, Integer weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	public Apple() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Apple [color=" + AppleEnum.getColorByCode(color) + ", weight=" + weight + "]";
	}
	
	
}
