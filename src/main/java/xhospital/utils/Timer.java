package xhospital.utils;

public class Timer {

	private long finishTime;
	
	public Timer() {
		this.finishTime = 0L;
	}
	
	public boolean isDone() {
		return (System.currentTimeMillis() >= this.finishTime);
	}
	
	public void sleep(long milliseconds) {
		this.finishTime = System.currentTimeMillis() + milliseconds;
	}
}
