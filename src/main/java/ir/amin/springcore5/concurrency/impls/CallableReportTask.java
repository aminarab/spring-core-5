package ir.amin.springcore5.concurrency.impls;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallableReportTask implements Callable<Report> {

	Logger logger = Logger.getLogger(getClass().getSimpleName());

	public Report call() {
		try {
			Thread.sleep(3000);
			Thread currentThread = Thread.currentThread();
			System.out.println("CallableReportTask :  currentThread Name : " + currentThread.getName()
					+ " - currentThread Id : " + currentThread.getId());
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Thread interrupted", e);
		}
		return new Report();

	}
}
