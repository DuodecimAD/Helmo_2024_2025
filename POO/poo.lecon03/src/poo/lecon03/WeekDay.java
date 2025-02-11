package poo.lecon03;

public enum WeekDay {

	Monday,  Friday, Tuesday, Wednesday, Sunday, Thursday, Saturday;
	
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
