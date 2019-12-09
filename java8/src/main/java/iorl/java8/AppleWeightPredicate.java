package iorl.java8;

public class AppleWeightPredicate implements ApplePredicate{

	@Override
	public boolean test(Apple apple) {
		if(150 < apple.getWeight()) {
			return true;
		}
		return false;
	}

}
