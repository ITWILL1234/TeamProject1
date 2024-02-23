package test.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

/*
 * 들여올 데이터 목록
 * HashMap<Intger, ItemVO>
 * UserVO
 * boolean
 */
// == 멀티채팅 서버측 기능 ===
// 다중 접속 처리할 수 있는 서버(서버에서 읽기만 - 독립적인 쓰레드)
// 읽기전용 쓰레드 : 접속자가 보낸 메시지를 언제든지 읽을 수 있어야함
// 접속자 명단 가지고 있기
// 받은(읽은) 메시지를 접속자 모두에게 전송하는 기능
public class TCPServerMultiChat {
    // 클라이언트의 출력 스트림을 관리하는 HashMap
    // 각 클라이언트는 고유한 이름(여기서는 IP 주소)으로 구분됩니다.
    private HashMap<String, ObjectOutputStream> clients;

    public TCPServerMultiChat() {
        // 클라이언트 정보를 저장할 HashMap을 초기화합니다.
        clients = new HashMap<String, ObjectOutputStream>();
    }

    public void startServer() {
        // 서버소켓을 생성하고, 클라이언트의 접속을 반복해서 처리합니다.
        try (ServerSocket server = new ServerSocket(10000)) {
            while (true) {
                // 서버 IP와 포트를 출력하며 접속을 대기합니다.
                System.out.println(">> 접속 대기중 ~~~ "
                        + InetAddress.getLocalHost().getHostAddress()
                        + ":" + server.getLocalPort());

                // 클라이언트의 접속을 수락합니다.
                Socket socket = server.accept();
                System.out.println("사용자가 접속되었습니다 - "
                        + socket.getRemoteSocketAddress());

                // 접속된 클라이언트를 처리하기 위해 새로운 쓰레드를 생성하고 시작합니다.
                ServerReveiver thread = new ServerReveiver(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 각 클라이언트의 연결을 처리하는 내부 클래스입니다.
    private class ServerReveiver extends Thread {
        private Socket socket;
        private ObjectInputStream inData;
        private ObjectOutputStream out;
        private String name; // 클라이언트의 이름(별칭)

        public ServerReveiver(Socket socket) {
            this.socket = socket;

            try {
                // 클라이언트와 데이터를 주고받기 위한 입력 및 출력 스트림을 초기화합니다.
                inData = new ObjectInputStream(socket.getInputStream());
                
                out = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            // 쓰레드가 시작되면, 클라이언트를 clients 명단에 추가합니다.
            name = socket.getInetAddress().getHostAddress();
            // clients라는 HashMap에 클라이언트의 식별자(name)와 이 클라이언트로 데이터를 전송할 수 있는 out(DataOutputStream 객체)를 저장합니다. 
            clients.put(name, out);

            try {
                // 클라이언트로부터 메시지를 받아서 모든 클라이언트에게 전송합니다.
                while (true) {
                	ItemVO item1 = (ItemVO) inData.readObject();
                    System.out.println(name + "> " + item1);
                    
                    String type = inData.readUTF();
                    System.out.println(type);
                    
                    // 받은 메시지를 모든 접속자에게 전송합니다.
                    sendToClientItemVO(name, item1);
                    //sendToClientCUDResult(name, true);
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("[예외발생] " + e.getMessage());
            } finally {
                // 클라이언트 연결이 종료되면, clients 명단에서 제거하고 모두에게 알립니다.
                clients.remove(name);
            }
        }

        private void sendToClientItemVO(String clientName, ItemVO item) {
            // clientName을 이용하여 해당 클라이언트의 DataOutputStream을 가져옵니다.
            ObjectOutputStream out = clients.get(clientName);
            if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(item);
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                    // 예외가 발생한 경우, 클라이언트 명단에서 제거할 수도 있습니다.
                    clients.remove(clientName);
                }
            }
        }
        
        private void sendToClientLoginResult(String clientName, UserVO user) {
            ObjectOutputStream out = clients.get(clientName);
            if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(user);
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                    // 예외가 발생한 경우, 클라이언트 명단에서 제거할 수도 있습니다.
                    clients.remove(clientName);
                }
            }
        }
        
        private void sendToClientCUDResult(String clientName, boolean result) {
        	ObjectOutputStream out = clients.get(clientName);
        	if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeBoolean(result);
                    
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                    // 예외가 발생한 경우, 클라이언트 명단에서 제거할 수도 있습니다.
                    clients.remove(clientName);
                }
            }
        }
        
        private void sendToClientItemVOHashMap(String clientName, HashMap<Integer, ItemVO>map) {
        	ObjectOutputStream out = clients.get(clientName);
        	if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(map);
                    
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                    // 예외가 발생한 경우, 클라이언트 명단에서 제거할 수도 있습니다.
                    clients.remove(clientName);
                }
            }
        }
    }
}










