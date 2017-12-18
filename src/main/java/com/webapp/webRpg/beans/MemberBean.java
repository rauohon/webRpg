/**
 * 
 */
package com.webapp.webRpg.beans;

/**
 * @클래스명 : MemberBean
 * @작성자 : 신태휘
 * @작성일 : 2017. 12. 18.
 * @설명 : 
 * @수정이력 - 수정일, 수정자, 수정내용
 */
public class MemberBean {
	
	private String userId;
	private String userPWD;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

}
