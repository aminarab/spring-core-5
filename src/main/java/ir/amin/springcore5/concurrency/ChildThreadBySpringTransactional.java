package ir.amin.springcore5.concurrency;

public interface ChildThreadBySpringTransactional {

	public void sendMessagesByMANDATORY(Long id);

	public void sendMessagesByNEVER(Long id);

	public void sendMessagesByNOTSUPPORTED(Long id);

	public void sendMessagesByREQUIRED(Long id);

	public void sendMessagesByREQUIRESNEW(Long id);

	public void sendMessagesBySUPPORTS(Long id);

	public void sendMessagesByAsynchronous(Long id);

}
