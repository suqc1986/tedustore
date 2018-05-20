package cn.tedu.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5171191727655488132L;
	public UsernameAlreadyExistException(String msg) {
		super(msg);
	}
	
	public UsernameAlreadyExistException() {
		super();
	}
	
}
