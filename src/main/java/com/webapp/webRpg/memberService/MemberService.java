/**
 * 
 */
package com.webapp.webRpg.memberService;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.webRpg.dao.MyBatisDao;
import com.webapp.webRpg.dao.TranEx;
import com.webapp.webRpg.utils.Encryption;
import com.webapp.webRpg.utils.SessionManagement;

/**
 * @클래스명 : MemberService
 * @작성자 : 신태휘
 * @작성일 : 2017. 12. 18.
 * @설명 : 
 * @수정이력 - 수정일, 수정자, 수정내용
 */
@Service
public class MemberService extends TranEx{
	
	@Autowired
	private Encryption enc;
	@Autowired 
	private SessionManagement session;
	@Autowired
	private MyBatisDao dao;
	
	ModelAndView mav = new ModelAndView();
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	boolean transaction = false;
	
	@SuppressWarnings("unchecked")
	public Object entrance(int code, Object...object) {
		Object obj = null;
		logger.info("MemberService entrance 진입");
		
		switch(code) {
		case 0:
			logger.info("MemberService case 0 회원가입 진입");
			obj = signUp((HashMap<String, Object>) object[0]);
			break;
			
		case 1:
			logger.info("MemberService case 1 sign in 진입");
			obj = signIn((HashMap<String, Object>) object[0]);
			break;
		
		}
		logger.info("MemberService switch 종료");
		return obj;
	}

	/**
	 * 처리내용 : 아이디 확인
	 * 작성일 : 2017. 12. 17.
	 * 작성자 : 신태휘
	 * @Method Name : idCheck
	 * @return type : boolean
	 */
	private boolean idCheck(HashMap<String, Object> hashMap) {
		boolean result = false;
		
		if(dao.idCheck(hashMap.get("userId").toString()) == 0) {
			result = true;
			logger.info("아이디 중복 없음");
		}
		
		return result;
	}

	
	/**
	 * 처리내용 : 회원 가입
	 * 작성일 : 2017. 12. 18.
	 * 작성자 : 신태휘
	 * @Method Name : signUp
	 * @return type : ModelAndView
	 */
	private ModelAndView signUp(HashMap<String, Object> hashMap) {
		
		setTransactionConf(TransactionDefinition.PROPAGATION_REQUIRED,
				TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		
		if(idCheck(hashMap)) {
			hashMap.put("userPWD", 
					enc.encode(hashMap.get("userPWD").toString()));
			// 비밀번호 암호화
			if(dao.signUp(hashMap) != 0) {
				logger.info("회원 가입 성공");
				transaction = true;
				mav.setViewName("signIn");
			}else {
				logger.info("회원 가입 실패");
				mav.addObject("message", "회원가입을 실패 했습니다.");
				mav.setViewName("signUp");
			}
		}
		setTransactionResult(transaction);
		
		return mav;		
	}
	
	/**
	 * 처리내용 : 로그인
	 * 작성일 : 2018. 1. 2.
	 * 작성자 : 신태휘
	 * @Method Name : signIn
	 * @return type : Object
	 */
	private String signIn(HashMap<String, Object> hashMap) {
		String result = "";
		try {
			logger.info("로그인 시작");
			if(!idCheck(hashMap)) {	// 아이디 확인
				logger.info("로그인 시작 :: 아이디 확인");
				if(enc.matches(hashMap.get("userPWD").toString(), 
						dao.pwdCheck(hashMap.get("userId").toString()))) {
					// 비밀번호 확인
					logger.info("로그인 성공");
					
					session.setAttribute("userId", hashMap.get("userId").toString());
					result = "home.tiles";
				}else {
					logger.info("로그인 실패 :: 비밀번호 일치 하지 않음");
				}
			}else {
				logger.info("로그인 실패 :: 아이디 없음");
			}
		}catch(Exception e) {
			logger.info("세션 컨트롤 실패");
		}
		
		return result;
	}

}
