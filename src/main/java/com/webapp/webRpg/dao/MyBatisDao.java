/**
 * 
 */
package com.webapp.webRpg.dao;

import java.util.HashMap;

/**
 * @클래스명 : MyBatisDao
 * @작성자 : 신태휘
 * @작성일 : 2017. 12. 18.
 * @설명 : 
 * @수정이력 - 수정일, 수정자, 수정내용
 */
public interface MyBatisDao {
	
	/*회원 관련*/
	public int idCheck(String string);
	
	public int signUp(HashMap<String, Object> resMap);

	public String pwdCheck(String string);

}
