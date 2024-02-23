package test.socket;

public class TCPServerMultiChatTest {

	public static void main(String[] args) {
		new TCPServerMultiChat().startServer();

	}

}

/*
 * cud - t, f
 * read itemvo - HashMap<Integer, ItemVO>
 * read user - UserVO 실패했을 경우엔 null
 */

/*
 * Object(ItemVO)
 */

// 클라이언트 측에서 데이터를 보낼 경우, 서버 측에선 그게 무슨 데이터인지 알 수가 없음.
// 그러다보니 서버측에서 여러가지 메서드를 구현을 해도 상황에 알맞게 메서드를 설정할 수 없음 (이유 : 보내는 데이터가 오브젝트 타입이니까.)
// 클라이언트측에서 서버에게 이게 무슨 데이터인지, 어떤 함수를 실행해야 하는지 알려주어야함.
// 데이터 하나만 보내면 상관없지만 이러한 문제가 얽혀있다!!
// 헤결방법은?
// 보내는 데이터 외에도 데이터를 더 보내본다?
// String타입으로 지시사항을 보내면 될 까?
// 그럼 이걸 어떻게 보내야 할 까?
// 파라미터 셋팅을 해두자
// 예) 

// 해결방법 1- 그러면...... 클라이언트측에서 데이터를 보낼 때, 해쉬 맵으로 붙여서 보내볼까... 근데 해쉬맵 안에 해쉬맵...? 아이템 리스트 때문에 안될거 같다.
// 해결방법 2-

// ObjectDataOutput
// String type = "User";
// String type = Item
// cast = CUD READ
