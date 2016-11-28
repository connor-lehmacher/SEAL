package main;

public class Run {
	private static int clock = 0;
	
	public static void run(boolean run) {
		while(run) {
			clock++;
			if(clock == 0) {
				//Setup
			}
			try{
				Thread.sleep(1000);
			} catch(InterruptedException i){}
		}
	}
}
