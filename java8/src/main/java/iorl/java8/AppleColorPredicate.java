package iorl.java8;

public class AppleColorPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		if(apple.getColor().equals(new Integer(0))) {
			return true;
		}
		return false;
	}

}
