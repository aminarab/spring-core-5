package ir.amin.springcore5.concurrency;

public interface ParentThreadByJavaXTransactional {

	public void preparedMessage(Long id);
	public void asynchronousPreparedMessage(Long id);
	public void preparedMessageByCallable(Long id);
	public void preparedMessageByRunnable(Long id);
	
}