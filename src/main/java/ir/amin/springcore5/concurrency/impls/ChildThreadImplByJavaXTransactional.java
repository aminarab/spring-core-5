package ir.amin.springcore5.concurrency.impls;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ir.amin.springcore5.concurrency.ChildThreadByJavaXTransactional;

@Service
public class ChildThreadImplByJavaXTransactional implements ChildThreadByJavaXTransactional {

	@Override
	public void sendMessagesByMANDATORY(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("MANDATORY id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void sendMessagesByNEVER(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NEVER id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void sendMessagesByNOTSUPPORTED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NOT_SUPPORTED id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void sendMessagesByREQUIRED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRED id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void sendMessagesByREQUIRESNEW(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRES_NEW id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void sendMessagesBySUPPORTS(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("SUPPORTS id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Async
	@Override
	public void sendMessagesByAsynchronous(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("Asynchronous id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());

	}
}
