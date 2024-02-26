package com.itwill.socket.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.itwill.utils.Config;
import com.itwill.vo.ItemVO;

public class ClientGetProductVO {
	private static final String GET_ITEM = "GET_ITEM";
	private static final String IP_ADDRESS = Config.getIpAddress();
	private ItemVO result;
	private int ItemNum;
	
	public ItemVO getData() {
		return this.result;
	}

	public void start(int itemNum) {
		Socket socket = null;
		ItemNum = itemNum;
		result = null;
		try  {
			socket = new Socket(IP_ADDRESS, 10000);
			System.out.println(">> 서버 접속 완료");
			
			ClientSender clientSender = new ClientSender(socket);
			ClientReceiver clientReceiver = new ClientReceiver(socket);
		    clientSender.start();
		    clientReceiver.start();
		    clientReceiver.join(); // ClientReceiver 작업이 끝날 때까지 대기

			
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
	            outData.writeUTF(GET_ITEM);
	            outData.flush();
	            
	            outData.writeInt(ItemNum);
	            outData.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	//메시지 읽기 전용 쓰레드
	private class ClientReceiver extends Thread {
		private Socket socket;
		private ObjectInputStream in;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			//메시지 받아서 화면 출력
			try {
				while (true) {
					try {
						result = (ItemVO) in.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			}
		}
		
	}
	
}

