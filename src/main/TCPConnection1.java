package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPConnection1 extends Thread {
	
	private Main ref;

    public void run() {
        try {
        	//Servidor en puerto 5000 
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Esperando cliente...");
            Socket socket = server.accept();
            System.out.println("Cliente 1 esta conectado");

            
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader breader = new BufferedReader(isr);

            
            while (true) {

                System.out.println("Esperando mensaje...");
                String mensajeRecibido = breader.readLine();
                
                System.out.println(mensajeRecibido);
                
                Gson gson = new Gson();
                
                //Aquí llega la acción 
                Acciones acc = gson.fromJson(mensajeRecibido, Acciones.class);

                System.out.println(acc.getAccion());

   
                //Notificar o avisar a MAIN
                ref.acciono(acc,this);
                
                
                

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public void setMain(Main main) {
		this.ref = main;
		
	}
	
    }
	


