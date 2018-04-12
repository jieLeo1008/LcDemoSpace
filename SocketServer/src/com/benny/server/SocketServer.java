package com.benny.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class SocketServer {

	public static void main(String[] args) {

		SocketServer socketServer =new SocketServer();
		
		socketServer.start();
		
	}

	
	
	public void start() {
		ServerSocket serverSocket = null ;
		BufferedReader reader = null  ;
		Socket socket=null;
		BufferedWriter bufferedWriter=null;
		try {
			//设置端口
			serverSocket=new ServerSocket(9898);
			System.out.println("Server started");
			socket=serverSocket.accept();
			System.out.println("client"+socket.hashCode()+"connected");
			//从socket读数据
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String receiveMessage;
			
			while((receiveMessage=reader.readLine())!=null){
				System.out.println(receiveMessage);
				bufferedWriter.write("server reply:"+receiveMessage+"\n");
				bufferedWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				serverSocket.close();
				reader.close();
				socket.close();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}





	public void startServerReplyListener(final BufferedReader reader){
		new Thread(new Runnable() {
			@Override
			public void run() {
				String resopnse;
				try {
					while ((resopnse=reader.readLine())!=null){

                    }
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
