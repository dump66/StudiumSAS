import java.io.IOException;

public class Tick implements Runnable {
	
	private int secondsToShutdown;

	@Override
	public void run() {
		while (secondsToShutdown > 0) {
			try {
				splitSeconds(secondsToShutdown--);
				this.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		try {
			Runtime.getRuntime().exec("shutdown -s");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void splitSeconds(int seconds) {
		Main.setHours(""+seconds/3600);
		seconds = seconds%3600;
		Main.setMinutes(""+seconds/60);
		Main.setSeconds(""+seconds%60);
	}
	
	public void setSecondsToShutdown(int seconds) {
		secondsToShutdown = seconds;
	}

}
//Runtime.getRuntime().exec("shutdown -s");
//Runtime.getRuntime().exec("shutdown /p");