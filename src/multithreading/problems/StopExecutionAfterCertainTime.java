package multithreading.problems;

import java.util.Timer;
import java.util.TimerTask;

/* Stop a thread in between the execution of the thread. ( since stop method in thread is deprecated )
 * Network or I/O calls are the exception where the underlying api will provide the timer out task
 * */

public class StopExecutionAfterCertainTime {
	/* using interrupt is the only way to stop a thread from execution.
	 * */
	static class LongRunningTask implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 0; i < Long.MAX_VALUE; i++) {
	            if(Thread.interrupted()) {
	                return;
	            }
	        }
	    }
	}
	
	
	/* Using Timer class we are indirectly calling a method which checks if the thread is still alive and interrupts the thread
	 * from execution.
	 * */
	
	static class TimeOutTask extends TimerTask {
	    private Thread thread;
	    private Timer timer;

	    public TimeOutTask(Thread thread, Timer timer) {
	        this.thread = thread;
	        this.timer = timer;
	    }

	    @Override
	    public void run() {
	        if(thread != null && thread.isAlive()) {
	            thread.interrupt();
	            timer.cancel();
	        }
	    }
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new LongRunningTask());
		thread.start();

		Timer timer = new Timer();
		TimeOutTask timeOutTask = new TimeOutTask(thread, timer);
		timer.schedule(timeOutTask, 3000);
	}
	
}
