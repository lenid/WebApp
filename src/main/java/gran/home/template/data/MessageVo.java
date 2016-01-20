package gran.home.template.data;

import java.io.Serializable;

public class MessageVo implements Serializable {
	private static final long serialVersionUID = -4543971047732329210L;
	
	boolean success;
	String text;
	
	public MessageVo() { }

	public MessageVo(boolean success, String text) {
		this.success = success;
		this.text = text;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
