
import java.net.InetSocketAddress;

public class Message {

	
	private String message;
	
	private InetSocketAddress adresse;
	
	
	public Message(String message, InetSocketAddress adresse){
		this.message = message;
		this.adresse = adresse;
	}


	public String getMessage() {
		return message;
	}

	public InetSocketAddress getAdresse() {
		return adresse;
	}	
	
}
