package com.itwill.socket.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.itwill.utils.Config;

public class ClientCheckOrderHistory {
	private static final String CHECK_ORDER_HISTORY = "CHECK_ORDER_HISTORY";
	private static final String IP_ADDRESS = Config.getIpAddress();
	private static String Email;
	private static int ItemNum;
	private boolean resultValue;
	private boolean senderFlag = false;
	private boolean receiverFlag = false;
	
	public boolean getResult() {
        return this.resultValue;
    }
	
	public void start(String email, int itemNum) {
		resetValue();
		Email = email;
		ItemNum = itemNum;
		Socket socket = null;
		try  {
			socket = new Socket(IP_ADDRESS, 10000);
			
			System.out.println(">> 서버 접속 완료");
			
			//Output 전용 : 메시지 보내기 전용 쓰레드 생성(쓰기전용)
			ClientSender clientSender = new ClientSender(socket);
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientSender.start();
			clientSender.join();
			clientReceiver.start();
			clientReceiver.join();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				while (true) {
					if (senderFlag && receiverFlag) {						
						socket.close();
						break;
					}
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
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
	            outData.writeUTF(CHECK_ORDER_HISTORY);
	            outData.flush(); // 버퍼에 있는 데이터를 모두 출력시킴
	            
	            outData.writeUTF(Email);
	            outData.flush(); // 데이터 전송 후 버퍼 비우기
	            
	            outData.writeInt(ItemNum);
	            outData.flush();
	            
	            ClientSender.sleep(1500);
	            
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	        	senderFlag = true;
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
				Object result = in.readObject();
				ArrayList<String> list = (ArrayList<String>) result;
				if (list.get(0).equals("TRUE")) resultValue = true;
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			} finally {
				receiverFlag = true;
			}
		}
		
	}
	
	private void resetValue() {
		resultValue = false;
		senderFlag = false;
		receiverFlag = false;
	}	
}