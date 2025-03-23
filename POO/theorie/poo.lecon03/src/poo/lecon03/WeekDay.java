package poo.lecon03;

public enum WeekDay {
	Monday(0), Friday(4), Tuesday(1), Wednesday(2), Sunday(6), Thursday(3), Saturday(5);
	
	private final int weekPos;
	
	WeekDay(int pos) {
		weekPos = pos;
	}
	
    public int getWeekPos() {
		return weekPos;
	}

	public WeekDay yesterday() {
        int pos = (weekPos +6) % 7;
        return getAt(pos);
    }

    public WeekDay tomorrow() {
        int pos = (weekPos + 1)%7;
        return getAt(pos);
    }

    // TODO essayer de comprendre :
	private WeekDay getAt(int pos) {
		for (WeekDay day : values()) {
			if(day.weekPos == pos) {
				return day;
			}
		}
		return null;
	}
}
