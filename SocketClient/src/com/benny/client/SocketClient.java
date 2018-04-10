package com.benny.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by Benny on 2018/4/10.
 */
public class SocketClient {


    public static void main(String... args) {
        SocketClient socketClient = new SocketClient();

        socketClient.start();
    }


    public void start() {
        BufferedReader inputReader = null;
        BufferedReader reader =null;
        BufferedWriter writer = null;
        Socket socket = null;

        try {


            socket = new Socket("127.0.0.1", 9898);
            reader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //从控制台读数据
            inputReader = new BufferedReader(new InputStreamReader(System.in));

            String inputContent;

            while (!(inputContent = inputReader.readLine()).equals("bye")) {
//
                writer.write(inputContent+"\n");
                writer.flush();
                String response=reader.readLine();
                System.out.println(response);

//                System.out.println(inputContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader .close();
                socket.close();
                writer.close();
                inputReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
