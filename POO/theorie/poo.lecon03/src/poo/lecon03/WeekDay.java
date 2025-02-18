package poo.lecon03;

public enum WeekDay {
	// TODO exercice 15
	Monday(0), Friday(4), Tuesday(1), Wednesday(2), Sunday(6), Thursday(3), Saturday(5);
	
	private final int weekPos;
	
	WeekDay(int pos) {
		weekPos = pos;
	}
	
    public int getWeekPos() {
		return weekPos;
	}

	public WeekDay yesterday() {
        int pos = (this.ordinal() +6) % 7;
        return getAt(pos);
    }

    public WeekDay tomorrow() {
        int pos = (this.ordinal() + 1)%7;
        return getAt(pos);
    }

	private WeekDay getAt(int pos) {
		return WeekDay.values()[pos];
	}
}
