package ir.amin.springcore5.concurrency;

import javax.transaction.Transactional.TxType;

public interface ChildThreadByJavaXTransactional {

	@javax.transaction.Transactional(value = TxType.MANDATORY)
	public void sendMessagesByMANDATORY(Long id);

	@javax.transaction.Transactional(value = TxType.NEVER)
	public void sendMessagesByNEVER(Long id);

	@javax.transaction.Transactional(value = TxType.NOT_SUPPORTED)
	public void sendMessagesByNOTSUPPORTED(Long id);

	@javax.transaction.Transactional(value = TxType.REQUIRED)
	public void sendMessagesByREQUIRED(Long id);

	@javax.transaction.Transactional(value = TxType.REQUIRES_NEW)
	public void sendMessagesByREQUIRESNEW(Long id);

	@javax.transaction.Transactional(value = TxType.SUPPORTS)
	public void sendMessagesBySUPPORTS(Long id);

	public void sendMessagesByAsynchronous(Long id);

}
