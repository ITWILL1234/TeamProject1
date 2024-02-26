package com.itwill.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.crud.Read;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;


public class Server {
	private static final String LOGIN = "LOGIN";
	private static final String REGISTRATION = "REGISTRATION";
	private static final String EDIT_PASSWORD = "EDIT_PASSWORD";
	private static final String EDIT_ADDRESS = "EDIT_ADDRESS";
	private static final String SIGN_OUT = "SIGN_OUT";
	
	private static final String PRODUCT_LIST = "PRODUCT_LIST";
	private static final String EDIT_PRODUCT_NAME = "EDIT_PRODUCT_NAME";
	private static final String EDIT_PRODUCT_PRICE = "EDIT_PRODUCT_PRICE";
	private static final String EDIT_PRODUCT_IMAGE = "EDIT_PRODUCT_IMAGE";
	private static final String DELETE_PRODUCT = "DELETE_PRODUCT";
	private static final String REGISTERING_PRODUCT = "REGISTERING_PRODUCT";
	private static final String GET_ITEM = "GET_ITEM";
	private static final String ORDER = "ORDER";
	
    private HashMap<String, OutputStream> clients;

    public Server() {
        clients = new HashMap<String, OutputStream>();
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
        private OutputStream out;
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
                    String clientRequest = inData.readUTF();
                    checkClientRequest(clientRequest);
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("[예외발생] " + e.getMessage());
            } finally {
                // 클라이언트 연결이 종료되면, clients 명단에서 제거하고 모두에게 알립니다.
                clients.remove(name);
            }
        }
        
        private void checkClientRequest(String req) throws IOException, ClassNotFoundException {
        	if (req.equals(LOGIN)) {
        		String email = inData.readUTF();
        		String password = inData.readUTF();
        		sendToClientLoginResult(name, Read.selectUser(email, password));
        	} else if (req.equals(REGISTRATION)) { 
        		Object inObject = inData.readObject();
        		processUserCUD(inObject, "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) VALUES (?, ?, ?, ?, ?, ?, SYSDATE) ");
        	} else if (req.equals(EDIT_PASSWORD)) {
        		Object inObject = inData.readObject();
        		processUserCUD(inObject, "UPDATE USERR SET PASSWORD = ? WHERE EMAIL = ? ");
        	} else if (req.equals(EDIT_ADDRESS)) {
        		Object inObject = inData.readObject();
        		processUserCUD(inObject, "UPDATE USERR SET ADDRESS = ? WHERE EMAIL = ? ");
        	} else if (req.equals(SIGN_OUT)) {
        		Object inObject = inData.readObject();
        		processUserCUD(inObject, "DELETE FROM USERR WHERE EMAIL = ? ");
        	} else if (req.equals(PRODUCT_LIST)) {
        		sendToClientItemVOHashMap(name, Read.getProductList());
        	} else if (req.equals(EDIT_PRODUCT_NAME)) {
        		Object inObject = inData.readObject();
        		processItemCUD(inObject, "UPDATE PRODUCT SET NAME = ? WHERE NUM = ? ");
        	} else if (req.equals(EDIT_PRODUCT_PRICE)) {
        		Object inObject = inData.readObject();
        		processItemCUD(inObject, "UPDATE PRODUCT SET PRICE = ? WHERE NUM = ? ");
        	} else if (req.equals(EDIT_PRODUCT_IMAGE)) {
        		Object inObject = inData.readObject();
        		processItemCUD(inObject, "UPDATE PRODUCT SET IMAGE = ? WHERE NUM = ? ");
        	} else if (req.equals(DELETE_PRODUCT)) {
        		Object inObject = inData.readObject();
        		processItemCUD(inObject, "DELETE FROM PRODUCT WHERE NUM = ? ");
        	} else if (req.equals(REGISTERING_PRODUCT)) {
        		Object inObject = inData.readObject();
        		processItemCUD(inObject, "INSERT INTO PRODUCT (NAME, PRICE, IMAGE) VALUES (?, ?, ?) ");
        	} else if (req.equals(GET_ITEM)) {
        		int itemNum = inData.readInt();
        		sendToClientItemVO(name, Read.selectItem(itemNum));
        	} else if (req.equals(ORDER)) {
        		Object inObject = inData.readObject();
        		processOrderCUD(inObject, "INSERT INTO ORDERS (NUM, ITEMNUM, EMAIL, ADDRESS, COUNT, PRICE) VALUES (num_order.nextval, ?, ?, ?, ? ,?) ");
        	}
        }
        
        private void processUserCUD(Object inObject, String sql) {
        	if (inObject instanceof HashMap) {
        		@SuppressWarnings("unchecked")
        		HashMap<Integer, String> pstmtPair = (HashMap<Integer, String>) inObject;
        		Boolean result = CUD.exeUser(sql, pstmtPair);
        		sendToClientCUDResult(name, result);
        	} else {
        		sendToClientCUDResult(name, false);
        	}
        }
        
        private void processItemCUD(Object inObject, String sql) {
        	if (inObject instanceof HashMap) {
        		@SuppressWarnings("unchecked")
        		HashMap<Integer, String> pstmtPair = (HashMap<Integer, String>) inObject;
        		Boolean result = CUD.exeItem(sql, pstmtPair);
        		sendToClientCUDResult(name, result);
        	} else {
        		sendToClientCUDResult(name, false);
        	}
        }
        
        private void processOrderCUD(Object inObject, String sql) {
        	if (inObject instanceof HashMap) {
        		@SuppressWarnings("unchecked")
        		HashMap<Integer, String> pstmtPair = (HashMap<Integer, String>) inObject;
        		Boolean result = CUD.exeOrder(sql, pstmtPair);
        		sendToClientCUDResult(name, result);
        	} else {
        		sendToClientCUDResult(name, false);
        	}
        }

        private void sendToClientItemVO(String clientName, ItemVO item) {
            // clientName을 이용하여 해당 클라이언트의 DataOutputStream을 가져옵니다.
            ObjectOutputStream out = (ObjectOutputStream) clients.get(clientName);
            if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(item);
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                }
                clients.remove(clientName);
            }
        }
        
        private void sendToClientLoginResult(String clientName, UserVO user) {
            ObjectOutputStream out = (ObjectOutputStream) clients.get(clientName);
            if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(user);
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                }
                clients.remove(clientName);
            }
        }
        
        private void sendToClientCUDResult(String clientName, boolean result) {
        	DataOutputStream out = (DataOutputStream) clients.get(clientName);
        	if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeBoolean(result);
                    
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                }
                clients.remove(clientName);
            }
        }
        
        private void sendToClientItemVOHashMap(String clientName, HashMap<Integer, ItemVO>map) {
        	ObjectOutputStream out = (ObjectOutputStream) clients.get(clientName);
        	if (out != null) {
                try {
                    // 해당 클라이언트에게만 메시지를 전송합니다.
                    out.writeObject(map);
                    
                } catch (IOException e) {
                    System.out.println("[예외발생] " + e.getMessage());
                }
                clients.remove(clientName);
            }
        }
    }
}
