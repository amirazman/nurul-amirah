import java.io.*;
import java.net.*;

public class JLedClient {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("127.0.0.1");

        if (args.length > 0)
           serverHostname = args[0];
        System.out.println ("Attemping to connect to host " +
                serverHostname + " on port 10007.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverHostname, 10007);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) 
        {
            System.err.println("Don't know about host: " +serverHostname);
            System.exit(1);
        } catch (IOException e) 
        {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: " +serverHostname);
            System.exit(1);
        }
        
        echoSocket.close();
    }
}
