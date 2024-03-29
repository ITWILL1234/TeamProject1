package com.itwill.socket.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.itwill.utils.Config;

public class ClientOrder {
	private static final String ORDER = "ORDER";
	private static final String IP_ADDRESS = Config.getIpAddress();
	private static HashMap<Integer, String> sqlPair;
	
	private boolean resultValue;

	public boolean getResult() {
        return this.resultValue;
    }

	public void start(HashMap<Integer, String> pair) {
		sqlPair = null;
		resultValue = false;
		sqlPair = pair;
		
		Socket socket = null;
		try  {
			socket = new Socket(IP_ADDRESS, 10000);
			
			System.out.println(">> 서버 접속 완료");
			
			//Output 전용 : 메시지 보내기 전용 쓰레드 생성(쓰기전용)
			ClientSender clientSender = new ClientSender(socket);
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientSender.start();
			clientReceiver.start();
			clientReceiver.join();
			
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private class ClientSender extends Thread {
	    private Socket socket;
	    private ObjectOutputStream outData;

	    public ClientSender(Socket socket) {
	        this.socket = socket;
	        try {
	            outData = new ObjectOutputStream(socket.getOutputStream());
	        } catch (IOException e) {
	            System.out.println("[예외발생] ClientSender 생성자 out 객체 생성 실패!!!");
	        }
	    }

	    @Override
	    public void run() {
	        if (outData == null) {
	            System.out.println(":: 출력객체가 없어서 작업종료");
	            return;
	        }
	        try {
	            outData.writeUTF(ORDER);
	            outData.flush(); // 버퍼에 있는 데이터를 모두 출력시킴
	            
	            outData.writeObject(sqlPair);
	            outData.flush(); // 데이터 전송 후 버퍼 비우기
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//메시지 읽기 전용 쓰레드
	private class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				resultValue = in.readBoolean();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}