package ie.dit;

class Matrix2DException extends Exception {
	
	private String message;
	
	Matrix2DException(String msg)  {
		setMessage(message);
	}

	public String getMessage()  {
		return message;
	}


	public void setMessage(String message)  {
		this.message=message;
	}
}