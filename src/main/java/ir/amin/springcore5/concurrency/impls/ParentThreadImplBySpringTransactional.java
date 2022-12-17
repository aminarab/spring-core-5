package ir.amin.springcore5.concurrency.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.amin.springcore5.concurrency.ChildThreadBySpringTransactional;
import ir.amin.springcore5.concurrency.ParentThreadBySpringTransactional;


@Service
public class ParentThreadImplBySpringTransactional  implements ParentThreadBySpringTransactional  {


	@Autowired
	private ChildThreadBySpringTransactional childThreadBySpringTransactional;

	@Transactional
	public void preparedMessage(Long id) {
		printCurrentThread(id);
		

		childThreadBySpringTransactional.sendMessagesByMANDATORY(id);
		childThreadBySpringTransactional.sendMessagesByREQUIRED(id);
		childThreadBySpringTransactional.sendMessagesByREQUIRESNEW(id);
		childThreadBySpringTransactional.sendMessagesBySUPPORTS(id);
		childThreadBySpringTransactional.sendMessagesByNOTSUPPORTED(id);
		childThreadBySpringTransactional.sendMessagesByNEVER(id);

	}

	@Transactional
	public void asynchronousPreparedMessage(Long id) {
		printCurrentThread(id);
		childThreadBySpringTransactional.sendMessagesByAsynchronous(id);
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
