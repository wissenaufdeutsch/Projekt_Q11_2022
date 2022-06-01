
import java.util.ArrayList;
import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.LinkedList;

public class Server extends Thread {

    private UDPManager udpThing;//manager for all UDP related problems (see UDPManager Class)
    
    private int port = 30303;//Port for UDP

    private int tcpPort;//Port for TCP and yes it is NOT the same as the UDPPort!!

    private ServerSocketChannel ssc;//The TcpChannel: needs to be opend from both sides

    private boolean shutdown = false;//Some Random Boolean for shutdown of the Server

    private ArrayList<ConnectionThread> threads = new ArrayList<ConnectionThread>();//Every f****** Client needs new Thread so we give you a collection here 
   //Every f****** Client needs new Thread so we give you a collection here 

    public Server(){//Constructor
        super();//needs to be cast, because of "extends Thread"
        start();//starting this Thread see at run() method! (especially opens the TCP connector)
        this.udpThing = new UDPManager() {//implementing the Inner Class UDPManager for the Server
            //Now we have all methods that belong to a Server in one class. And we don't need this concrete implementation anywhere else.
            @Override
            public void handleTheMessage(Message whatIsThere) { 
                //what does a server with a UDP Broadcast Message

                if(whatIsThere.getMessage().equals("ClientConnect")){//if a client writes that it is ready to connect
                    try {
                        System.out.println("Recieved UDP Broadcast from Client");//Random sysout for test purposes
                        //Send everyone ip and port of this server. The Client can then initiate the TCP-connection
                        udpThing.sendBroadcast("Greetings", port, ""+tcpPort/*The real art of casting int to String!*/);

                    } catch (IOException e) {//i dont have another catchy phrase for this one...
                        e.printStackTrace();//securing of evidence
                    }
                }

            }
        };//End of inner Class! This implementation is only for lazy ones. Maybe you want to specify this in a different class
        try {//REMEMBER: We are still inside the Constructor even if it does not look/feel like it
            //Make UDP Broadcast. So if a Client is already running he hears it and can respond
            udpThing.sendBroadcast("Greetings", port, ""+tcpPort/*The real art of casting int to String!*/);
            udpThing.start();//After the Broadcast(above) the UDPManager starts to listen for answers from UDP!
        } catch (IOException e) {//if it does fail you have to catch this one
            e.printStackTrace();//Make better solution for catch!
        }

    }

    @Override
    public void run(){//Thread method: basically listens to TCP connections
        try {//the following can possibly go terribly wrong! You open a channel and get the port where you listen
            ssc = ServerSocketChannel.open();//open the TCP connection
            ssc.bind(null); // Bind to an arbitrary port.
            tcpPort = ((InetSocketAddress) ssc.getLocalAddress()).getPort();//get the Port where this Server is listening
        } catch (IOException e1) {//You need the Port to send it to your Clients! (btw. another catch...)
            e1.printStackTrace();//Stack blaaaa: You can do this better!
        }
        int x = 0;
        while(x!=2 && !shutdown) {//as long as nobody wants to kill the server real badly
            try {// Wait for a new connection.
                System.out.println("im here");//test sysout
                SocketChannel chan = ssc.accept();//try to accept an incoming connection
                System.out.print("accept");
                String remotename = chan.getRemoteAddress().toString();//Get the RemoteName because the TextSocketChannel from Erich Schubert wants it
                TextSocketChannel conn = new TextSocketChannel(chan, Charset.forName("UTF-8"), remotename);//new Textsocketchannel holds basically all the 
                synchronized(this) {//synchronize it to make sure we don't get in trouble with some random other Threads
                    ConnectionThread t = new ConnectionThread(conn,this);//we have to open a new Thread for every connection
                    t.start();//start the new Thread
                    threads.add(t);//add it to the Collection!
                    t.conn.send("Hello Client, are you there?");
                    System.out.print("connected");
                }    
                x = x+1;
            }
            catch(IOException e) {//in case something went wrong
                e.printStackTrace();//random catch thing
                shutdown = true;//Server leaves the building if it is on fire!!!
                break;
            }
        }
    }
    
    void sendmessanges(String m){
        for(int i=0; i<threads.size(); i++){
            try{
                threads.get(i).conn.send(m);
            }
        catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
        
    
    //IGNORE ALL BELOW!! YOU DONT HAVE TO KNOW ANYTHING ABOUT IT

    /**
     * Thread for a single connection.
     * 
     * @author Erich Schubert
     */
    public class ConnectionThread extends Thread {
        /** Connection channel */
        public TextSocketChannel conn;
        Server s;
        /**
         * Constructor.
         * 
         * @param conn Connection
         */
        public ConnectionThread(TextSocketChannel conn,Server se) {
            this.conn = conn;
            this.s=se;
        }

        @Override
        public void run() {
            // String remotename = conn.getInfo();
            // fireConnected(remotename, conn);
            
            try {
                while(conn.isOpen()) {
                    String message = conn.read();
                    if(message == null){
                        break; // Disconnected.
                    }
        
                    System.out.println("Server: " +message);
                    
                    s.sendmessanges(message);
                    //for(int i=0; i<threads.size();i++){
                    //    threads.conn.send(message);
                    //}
                    //conn.send(message);
                   
                    //fireReceived(conn, message);
                }
                System.out.println("failed");
            }
            
            catch(IOException e) {
                e.printStackTrace();
            }
            // fireDisconnected(remotename);
        }
    
    }

    public static void main(String[] args) {
        new Server();
    }

}
