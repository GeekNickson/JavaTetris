package timestuff;

import java.util.Date;

public class TimeManager {
	long tickDuration = 1000; // in milliseconds
	Date time = new Date(); // time provider
	long prevTime;
	
	
	public TimeManager(long tickDuration) {
		this.tickDuration = tickDuration;
		prevTime = time.getTime();
	}
	
	
	public boolean nextTick() {
		time = new Date();
		long nowTime = time.getTime();
		boolean res = (nowTime - prevTime) >= tickDuration;
		if (res) prevTime = time.getTime();
		//System.out.println("nowTime:" + nowTime + "---- prevTime:"+prevTime);
		return res;
	}
}
