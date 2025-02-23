package poo.lecon04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Bottle {
	private int[] volumeCapacity;

	public Bottle(int capacity) {
		volumeCapacity = new int[] {
			0, capacity
		};
	}
	
	//DONE: exercice 2
	public Bottle(Bottle original) {
		
		this.volumeCapacity = Arrays.copyOf(original.volumeCapacity, 2);
	}

	public int getVolume() {
		return this.volumeCapacity[0];
	}
	
	private void setVolume(int value) {
		if(value > getCapacity()) return;
		if(value < 0) return;
		
		volumeCapacity[0] = value;
	}
	
	public int getCapacity() {
		return this.volumeCapacity[1];
	}
	
	public boolean isEmpty() {
		return getVolume() == 0;
	}

	public boolean isFull() {
		return getVolume() == getCapacity();
	}

	public float getFillRatio() {
		return getVolume() / (float) getCapacity();
	}
	
	public void fill(int quantity) {
		if (quantity <= 0) {
			return;
		}

		int newVolume = Math.min(getVolume() + quantity, getCapacity());
		
		setVolume(newVolume);
	}

	public void empty(int quantity) {
		if(quantity <= 0) return;
		
		int newVolume = Math.max(getVolume() - quantity, 0);
		setVolume(newVolume);
	}

}
