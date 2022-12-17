package ir.amin.springcore5.concurrency.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.amin.springcore5.concurrency.ChildThreadByJavaXTransactional;
import ir.amin.springcore5.concurrency.ParentThreadByJavaXTransactional;

@Service
public class ParentThreadImplByJavaXTransactional  implements ParentThreadByJavaXTransactional{

	@Autowired
	private ChildThreadByJavaXTransactional childThreadByJavaXTransactional;

	@Transactional
	public void preparedMessage(Long id) {
		printCurrentThread(id);
		childThreadByJavaXTransactional.sendMessagesByMANDATORY(id);
		childThreadByJavaXTransactional.sendMessagesByREQUIRED(id);
		childThreadByJavaXTransactional.sendMessagesByREQUIRESNEW(id);
		childThreadByJavaXTransactional.sendMessagesBySUPPORTS(id);
		childThreadByJavaXTransactional.sendMessagesByNOTSUPPORTED(id);
		childThreadByJavaXTransactional.sendMessagesByNEVER(id);
		

	}

	@Transactional
	public void asynchronousPreparedMessage(Long id) {
		printCurrentThread(id);
		childThreadByJavaXTransactional.sendMessagesByAsynchronous(id);
	}


	private void printCurrentThread(Long id) {
		Thread currentThread = Thread.currentThread();
		System.out.println("id : " + id + " -  currentThread Name : " + currentThread.getName()
				+ " - currentThread Id : " + currentThread.getId());
	}

	@Override
	public void preparedMessageByCallable(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preparedMessageByRunnable(Long id) {
		// TODO Auto-generated method stub
		
	}
}
