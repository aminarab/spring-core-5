package ir.amin.springcore5.concurrency.impls;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ir.amin.springcore5.concurrency.ChildThreadBySpringTransactional;

@Service
public class ChildThreadImplBySpringTransactional implements ChildThreadBySpringTransactional {

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void sendMessagesByMANDATORY(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("MANDATORY id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}


	@Transactional(propagation = Propagation.NEVER)
	@Override
	public void sendMessagesByNEVER(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NEVER id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Override
	public void sendMessagesByNOTSUPPORTED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("NOT_SUPPORTED id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}


	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void sendMessagesByREQUIRED(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRED id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void sendMessagesByREQUIRESNEW(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("REQUIRES_NEW id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}


	@Transactional(propagation = Propagation.SUPPORTS)
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
