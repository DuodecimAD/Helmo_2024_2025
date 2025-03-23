package poo.lecon06;

import java.util.NoSuchElementException;

// DONE exercice 6.3 définir générique

public class Maybe<TValue> {
	
	private TValue value;
	
	private Maybe(TValue value) {
		this.value = value;
	}
	
	public static <T> Maybe<T> of(T value) {
		if(value == null) {
			return new Maybe<T>(null);
		}
		return new Maybe<T>(value);
	}

	public static <T> Maybe<T> empty() {
		return new Maybe<>(null);
	}

	public boolean isDefined() {
		return value != null;
	}

	public TValue get() {
		if(!isDefined()) {
			throw new NoSuchElementException();
		}
		return value;
	}

	public TValue getOrElse(TValue defaultValue) {
		return isDefined() ? value : defaultValue;
	}
}
