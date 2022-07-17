import java.util.ArrayList;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client extends Thread{
    private UDPManager udpThing;//Everyone needs a UDPthing! so we can shout to the World!
    private int port = 30303;//UDP Port nothing special yet
    private TextSocketChannel conn;//this thing can send and recieve over a TCP Connection
    public boolean bistdran;
    int spielernummer;
    TTTViewSpielfeld t;
    //private static InetSocketAddress serverIP; We dont need this at the moment maybe when my code gets better!
    public Client(){//new Client new luck!
  
        super();//have to invoke this because of extends Thread!
        t = new TTTViewSpielfeld(this);
        bistdran = false;
        spielernummer = -1;
        this.udpThing = new UDPManager() {//have to make the UDP Thing concrete! looks complicated but its usefull here
            //Now we have all methods that belong to a Client in one class. And we don't need this concrete implementation anywhere else.
            @Override
            public void handleTheMessage(Message whatIsThere) {//So what does a Client do when recieving a UDP Broadcast
                if(whatIsThere.getMessage()!=null){//empty messages get ignored
                    if(whatIsThere.getMessage().equals("ClientConnect")){//A Client sends this message so as a Client i have to ignore it!
                        //System.out.println("Found a Client but not a server");//Some random catch thing to know what happened YOU SHOULD MAKE THIS BETTER!
                    }
                    else{//If it is not a client message (You should probably make this more precise!!!
                        //System.out.println("Recieved UDP Broadcast from Server");//Just say sth so that i know this worked!
                        //System.out.println(whatIsThere.getAdresse().getAddress() + " " + whatIsThere.getMessage());
                        this.serverIP = new InetSocketAddress(whatIsThere.getAdresse().getAddress(),Integer.parseInt(whatIsThere.getMessage()));
                        //System.out.println(serverIP);
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

    public void sendnewchoice(String a)
    {   
        if(bistdran){
            try{
       
   
                conn.send(a+ " "+String.valueOf(spielernummer)+" ");
                bistdran = false;
                //update view!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
            catch (IOException e1) {//random catch!!!!!!!!!!!!!!!!!!!!!!!!!
                e1.printStackTrace();//random print
            }

        }
        else{
            //view write: "du bist nicht dran"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }
    }

    private void tcpConnection(InetSocketAddress remote){//Has everything you need to initiate a TCP connection
        SocketChannel channel;//ok so we need a Channel!
        //System.out.println("Trying to init tcpConnection");//I was here!
        try{//may fail be careful!
            channel = SocketChannel.open(remote);//open channel to see if others are ready
        }
        catch(IOException e) {//this catch actually makes some sense, but still needs better handling!
            //System.out.println(remote.toString());//test sysout pls handle better
            e.printStackTrace();//please handle better!
            return;//return to skip the rest if connection failed!
        }
        conn = new TextSocketChannel(channel, Charset.forName("UTF-8"), remote.toString());//use the Class from Erich because i am lazy now!

        System.out.println("Client connected ");

        while(conn.isOpen()) {
            try{
                
                String z = conn.read();
                
                String []message = z.split(" ");
                
                
                if(!message[1].equals(String.valueOf(spielernummer))){
                if(message[0].equals("erster")){
                    
                    
                    spielernummer = 1;
                }
                if(message[0].equals("start")){
                    
                    
                    bistdran = true;
                }
                if(message[0].equals("zweiter")){
                    
                    spielernummer = 2;
                }
                if( 
                message[0].equals("1")||
                message[0].equals("2")||
                message[0].equals("3")||
                message[0].equals("4")||
                message[0].equals("5")||
                message[0].equals("6")||
                message[0].equals("7")||
                message[0].equals("8")||
                message[0].equals("9")
                ){
                    bistdran = true;
                    t.updatebutton(message[0], false);
                    //view setzt !meinZeichen bei dem Feld "message"!!!!!!!!!!!!!!!!!!!!!!!!!
                    //in der View, wenn auf Feld gedrückt: mach sendnewchoice(feldnummer)!!!!!!!!!!!!!!!!!!!!!!!!!
                }
                System.out.println("Client"+spielernummer+": "+message[0]);
            }
                
                if(message == null) {
                    break; // Disconnected.

                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("I wanted the divorce!");//after 7 years pls....
    }

    //DONE!!!
    //Observer pattern
    // public void waituntilfeedback(){
    // while (feedback ==""){

    // }
    // System.out.println("feedback received");

    // }

    public static void main(String[] args) {
        new Client();
    }

}
