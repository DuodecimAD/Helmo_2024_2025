package poo.lecon04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Bottle {
	private int[] volumeCapacity;

	public Bottle(int capacity) {
		this(0, capacity);
	}
	
	public Bottle(int volume, int capacity) {
		
		this.volumeCapacity = new int[] {
				Math.min(volume >= 0 ? volume : Math.abs(volume), capacity >= 0 ? capacity : Math.abs(capacity)), capacity >= 0 ? capacity : Math.abs(capacity)
		};
		
	}
	
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
