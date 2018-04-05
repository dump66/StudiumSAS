import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyTask extends Service<Void> {

	private int secondsToShutdown;

	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				try {
					while (secondsToShutdown > 0 && !Thread.interrupted()) {
						splitSeconds(secondsToShutdown--);
						Thread.sleep(1000);

					}
					if (secondsToShutdown == 0) {
//						Runtime.getRuntime().exec("shutdown -s");
						Runtime.getRuntime().exec("shutdown /p");
						this.cancel();
					}
				} catch (InterruptedException e) {
				}
				return null;
			}
		};
	}

	// @Override
	// protected Object call() throws Exception {
	// while (secondsToShutdown > 0) {
	// try {
	// splitSeconds(secondsToShutdown--);
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// try {
	// Runtime.getRuntime().exec("shutdown -s");
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return null;
	// }

	
	private void setLabelsNull() {
		Main.setHours("");
		Main.setMinutes("");
		Main.setSeconds("");
	}
	private void splitSeconds(int seconds) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				int secs = seconds;
				Main.setHours("" + secs / 3600);
				secs = seconds % 3600;
				Main.setMinutes("" + secs / 60);
				Main.setSeconds("" + secs % 60);
			}
		});

	}

	public void setSecondsToShutdown(int seconds) {
		secondsToShutdown = seconds;
	}

}
