
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client extends Thread{
    private UDPManager udpThing;//Everyone needs a UDPthing! so we can shout to the World!
    private int port = 30303;//UDP Port nothing special yet
    private TextSocketChannel conn;//this thing can send and recieve over a TCP Connection
    String feedback;
    //private static InetSocketAddress serverIP; We dont need this at the moment maybe when my code gets better!
    public Client(){//new Client new luck!
        super();//have to invoke this because of extends Thread!
        feedback = "";
        this.udpThing = new UDPManager() {//have to make the UDP Thing concrete! looks complicated but its usefull here
            //Now we have all methods that belong to a Client in one class. And we don't need this concrete implementation anywhere else.
            @Override
            public void handleTheMessage(Message whatIsThere) {//So what does a Client do when recieving a UDP Broadcast
                if(whatIsThere.getMessage()!=null){//empty messages get ignored
                    if(whatIsThere.getMessage().equals("ClientConnect")){//A Client sends this message so as a Client i have to ignore it!
                        System.out.println("Found a Client but not a server");//Some random catch thing to know what happened YOU SHOULD MAKE THIS BETTER!
                    }
                    else{//If it is not a client message (You should probably make this more precise!!!
                        System.out.println("Recieved UDP Broadcast from Server");//Just say sth so that i know this worked!
                        System.out.println(whatIsThere.getAdresse().getAddress() + " " + whatIsThere.getMessage());
                        this.serverIP = new InetSocketAddress(whatIsThere.getAdresse().getAddress(),Integer.parseInt(whatIsThere.getMessage()));
                        System.out.println(serverIP);
                        /*The server sends us a message which contains its port. Every UDP Message has the ip in it without further coding needed
                         * Just imagine a Postcard where you have to write your name down to know where its from!
                         * Same thing here!
                         */
                        tcpConnection(udpThing.serverIP);//Hurayyy we can connect now

                    }
                }

            }
        };/*END OF THE INNER ANONYMOUS CLASS - this is the solution for the lazy ones! If you want you can extract this to another class!*/

        //Remember: At this point we are still in the initialization of the Client so:
        try {//try because it may fail!
            udpThing.sendBroadcast("Greetings", port, "ClientConnect");//Sending a Message as Client to UDP to recieve answers from a Server!
            udpThing.start();//Listen to answers from the server!
            start();//The run basically waits for a TCP Destination!
        } catch (IOException e) {//You should better catch this right
            e.printStackTrace();//print this stupid thing man do it !! NOW
        }
    }

    @Override
    public void run(){
        while(udpThing.serverIP==null){//wait till
            //DO NOTHING !!
        }
        //System.out.println("lol");
        //tcpConnection(udpThing.serverIP);//Hurayyy we can connect now
    }// this is just ... a Bracket... a Bracket!

    public void send(String a)
    {   
        try{
            conn.send(a);
        }
        catch (IOException e1) {//random catch
            e1.printStackTrace();//random print
        }
    }

    private void tcpConnection(InetSocketAddress remote){//Has everything you need to initiate a TCP connection
        SocketChannel channel;//ok so we need a Channel!
        System.out.println("Trying to init tcpConnection");//I was here!
        try{//may fail be careful!
            channel = SocketChannel.open(remote);//open channel to see if others are ready
        }
        catch(IOException e) {//this catch actually makes some sense, but still needs better handling!
            System.out.println(remote.toString());//test sysout pls handle better
            e.printStackTrace();//please handle better!
            return;//return to skip the rest if connection failed!
        }
        System.out.println("success!?");//nice we have someone who wants to talk!
        conn = new TextSocketChannel(channel, Charset.forName("UTF-8"), remote.toString());//use the Class from Erich because i am lazy now!
        try {//time for try---al and error?
            conn.send("Hello World Client is here!");//test send you will change this!
            //conn.send("hi my name is kili and i made it");
            //you can now send whatever you want!
        } catch (IOException e1) {//random catch
            e1.printStackTrace();//random print
        }
        // hier modifizieren
        //try {//may fail pls catch me if you can

        System.out.println("done");

        while(conn.isOpen()) {
            try{String message = conn.read();
                System.out.println(message);
                //send to view
                //Controller check if game goes  on yes?
                waituntilfeedback();
                if(message == null) {
                    break; // Disconnected.

                }
                conn.send(feedback);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("I wanted the divorce!");//after 7 years pls....
    }

    //DONE!!!
    //Observer pattern
    public void waituntilfeedback(){
        feedback = "";
        while (feedback !=""){

        }
    }

    public void changefeedback(String s){
        feedback = s;
    }

    public static void main(String[] args) {
        new Client();
    }

}
