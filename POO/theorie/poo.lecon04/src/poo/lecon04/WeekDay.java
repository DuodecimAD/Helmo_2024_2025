package poo.lecon04;

public enum WeekDay {

	Monday(1), Tuesday(2), Wednesday(3), Sunday(0), Thursday(4), Friday(5), Saturday(6);
	
    private final int pos;
    
	WeekDay(int pos) {
    	this.pos = pos;
    }

	public WeekDay yesterday() {
        int pos = (this.pos +6) % 7;
        return getAt(pos);
    }

    public WeekDay tomorrow() {
        int pos = (this.pos + 1)%7;
        return getAt(pos);
    }

	private WeekDay getAt(int pos) {
		WeekDay result = null;
        
        for(WeekDay wd : WeekDay.values()) {
        	if(wd.pos == pos) {
        		result = wd;
        	}
        }
        
        return result;
	}
	
//  Solution performante et robuste
//  private static EnumMap<WeekDay, WeekDay> tomorows = new EnumMap<>(WeekDay.class);
//  static {
//  	WeekDay.tomorows.put(Monday, Tuesday);
//  	WeekDay.tomorows.put(Tuesday, Wednesday);
//  	WeekDay.tomorows.put(Wednesday, Thursday);
//  	WeekDay.tomorows.put(Thursday, Friday);
//  	WeekDay.tomorows.put(Friday, Saturday);
//  	WeekDay.tomorows.put(Saturday, Sunday);
//  	WeekDay.tomorows.put(Sunday, Monday);
//  }
}
