
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class UDPManager extends Thread{

	private static final int port = 30303;
	
	private Charset charset = Charset.forName("UTF-8");
	
	private InetAddress BROADCAST;
	
	private DatagramSocket discoverySocket;
	
	private boolean connection = false;
	
	public InetSocketAddress serverIP;
	
	public UDPManager(){
		super();

		try {
		      BROADCAST = InetAddress.getByName("255.255.255.255");
		    }
		    catch(UnknownHostException e) {
		      // This should never happen.
		      e.printStackTrace();
		    }
	}
	
	@Override
	public void run(){
		try{//Listen if someone is there on UDP!
			discoverySocket = new DatagramSocket(null);//initialise new Socket
			discoverySocket.setReuseAddress(true);//whatever somehow we need this dont ask me
			discoverySocket.setBroadcast(true);//we want to broadcast so set this true
			InetSocketAddress adresse = new InetSocketAddress(port);//need new address we can listen to!
			discoverySocket.bind(adresse);//binding the adress to the new socket!
			byte[] buffer = new byte[1024 << 4];//We need some space to read the stuff which comes in!
			while(!connection){//While there is no tcp connection try to listen to broadcasts
				try{//This is the Listen Method thingy
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length);//DataGramSockets send DatagramPackets so we need one of them!
					discoverySocket.receive(packet);//Waiting for the mail to arrive!
					Message whatIsThere = getTheMessageAndTheIPFromPackage(packet);//Coding the recieved message to a Class
					handleTheMessage(whatIsThere);//Deals with the Message and reacts to it (see below!!)
				}
				catch(IOException e){//catch if sth went wrong, atm its not very good so rewrite this!!
					e.printStackTrace();
				}
			}
		}
		catch(SocketException e){//same
			e.printStackTrace();
		}
		try {
		      discoverySocket.close();//closing socket if connection is established!
		    }
		    catch(Exception e) {
		      // Probably already closed. Safe to ignore.
		    }
	}

	/**
	 * Must be overwritten to specify, how the Client/Server handles the Messages. 
	 * 
	 * @param whatIsThere - The recieved Message
	 */
	public abstract void handleTheMessage(Message whatIsThere);

	/**
	 * Just ignore this it makes everything easier! You only need to overwrite the handleTheMessage()!!
	 */
	private Message getTheMessageAndTheIPFromPackage(DatagramPacket packet) throws IOException {
		String message = getMessage(packet);
		int port = packet.getPort();
		InetAddress ip = packet.getAddress();
		return new Message(message, new InetSocketAddress(ip,port));
	}
	
	/**
	 * Ignore this too its just helpful for the getTheMessageAndIPFromPackage method!
	 */
	private String getMessage(DatagramPacket packet) throws IOException{
		return new String(packet.getData(),0,packet.getLength(), charset);
	}
	
	
	  /**
	   * Broadcast a service announcement.
	   * 
	   * @param port Port to announce
	   * @param countent Message content
	   * @throws IOException When sending failed
	   */
	  public void sendBroadcast(String type, int port, String message) throws IOException {
	    sendAnnouncement(BROADCAST, this.port, type, port, message);
	  }

	  /**
	   * Broadcast a service announcement.
	   * 
	   * @param addr Destination
	   * @param dport Destination port
	   * @param type Message type
	   * @param aport Port to announce
	   * @param countent Message content
	   * @throws IOException When sending failed
	   */
	  public void sendAnnouncement(InetAddress addr, int dport, String type, int aport, String message) throws IOException {
	    
		ByteBuffer bbuf = charset.encode(codeMyMessage(message));//change this line for your own Protocol
	    // Socket for sending.
	    DatagramSocket s = new DatagramSocket(null);
	    DatagramPacket packet = new DatagramPacket(bbuf.array(), bbuf.limit(), addr, dport);
	    s.send(packet);
	    s.close();
	  }
	  
	  /**
	   * THIS IS THE METHOD YOU ALL HAVE BEEN WAITING FOR!!!
	   * Here you have to define how your messages are coded!
	   * for example if you write sth like "server 120.12.34.15 30371 Hello world this network sucks!"
	   * to transfer who send it (maybe a playername) which ip he/she has which port he/she uses and what he/she has to say! 
	   * 
	   * @param hereShouldBeSomeSeriousAttributes
	   * @return
	   */
	  private String codeMyMessage(String hereShouldBeSomeSeriousAttributes){
		  //IMPORTANT: YOU MAYBE WANT TO MAKE TWO METHODS ONE FOR UDP AND ONE FOR TCP
		  //BUT YOU DONT HAVE TO!!
		  
		//should define the Protocol for Messages!
		  //So you want to make sth like:
		  /*
		   * String asdf = ""
		   * 
		   * asdf = "Your" + "Random" + "Protocol" + "that maybe the Erich Schubert guy tells you!" 
		   * 
		   * return asdf;
		   */
		  if(hereShouldBeSomeSeriousAttributes==null){
		  StringBuilder sbuf = new StringBuilder();
		  sbuf.append("something");
		  sbuf.append('\0'); // Separator
		  sbuf.append("even more text");
		  return sbuf.toString();
		  }
		  else{
			  return hereShouldBeSomeSeriousAttributes;
		  }
		 
	  }
}