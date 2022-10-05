package kr.bit.frontController;

import java.util.HashMap;

import kr.bit.Controller.Controller;
import kr.bit.Controller.MemberContentController;
import kr.bit.Controller.MemberDeleteController;
import kr.bit.Controller.MemberInsertController;
import kr.bit.Controller.MemberListController;
import kr.bit.Controller.MemberRegisterController;
import kr.bit.Controller.MemberUpdateController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberList.do", new MemberListController()); 
		mappings.put("/memberInsert.do", new MemberInsertController()); 
		mappings.put("/memberRegister.do", new MemberRegisterController()); 
		mappings.put("/memberContent.do", new MemberContentController()); 
		mappings.put("/memberDelete.do", new MemberDeleteController()); 
		mappings.put("/memberUpdate.do", new MemberUpdateController()); 
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
