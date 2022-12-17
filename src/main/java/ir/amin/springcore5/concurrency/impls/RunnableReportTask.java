package ir.amin.springcore5.concurrency.impls;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableReportTask implements Runnable {

	Logger logger = Logger.getLogger(getClass().getSimpleName());

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			Thread currentThread = Thread.currentThread();
			System.out.println("RunnableReportTask :  currentThread Name : " + currentThread.getName()
					+ " - currentThread Id : " + currentThread.getId());
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Thread interrupted", e);
		}
		
	}
}
