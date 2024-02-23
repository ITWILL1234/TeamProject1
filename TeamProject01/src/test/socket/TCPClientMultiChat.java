package test.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.itwill.utils.Config;
import com.itwill.vo.ItemVO;


// 내부클래스를 사용한 읽기, 쓰기 쓰레드 생성해서 사용
// 쓰기쓰레드 : 메시지 작성 및 전송을 독립적으로 처리(언제든지 메시지 보내기-쓰기전용)
// 읽기쓰레드 : 서버쪽에서 보내온 메시지를 받아서 화면 표시(언제든지 메시지 읽기-읽기전용)
public class TCPClientMultiChat {
	
	private static final String IP_ADDRESS = Config.getIpAddress();

	public void start() {
		Socket socket = null;
		try  {
			socket = new Socket(IP_ADDRESS, 10000);
			//socket = new Socket("192.168.18.31", 10000);
			//내 아이피
			System.out.println(">> 서버 접속 완료");
			
			//Output 전용 : 메시지 보내기 전용 쓰레드 생성(쓰기전용)
			ClientSender clientSender = new ClientSender(socket);
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientSender.start();
			clientReceiver.start();
			
		} catch (IOException e) {
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

	        // 서버에 데이터 보내기
	        ItemVO item1 = new ItemVO(1, "one", 10);
	        try {
	            outData.writeObject(item1);
	            outData.flush(); // 버퍼에 있는 데이터를 모두 출력시킴
	            System.out.println("객체의 데이터를 내보냈습니다!");
	            
	            outData.writeUTF("BOOLEAN"); // 문자열 전송
	            outData.flush(); // 데이터 전송 후 버퍼 비우기
	            System.out.println("스트링 타입의 데이터를 내보냈습니다.");
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
						ItemVO item1 = (ItemVO) in.readObject();
						System.out.println(item1 + " ------ 클라이언트가 아이템을 읽어옵니다.");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			}
		}
		
	}
	
}
