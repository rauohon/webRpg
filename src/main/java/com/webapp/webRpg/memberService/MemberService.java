/**
 * 
 */
package com.webapp.webRpg.memberService;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
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
	
	public Object entrance(int code, Object...object) {
		Object obj = null;
		logger.info("MemberService entrance 진입");
		
		switch(code) {
		case 0:
			logger.info("MemberService case 0 진입");
			signUp((HashMap) object[0]);
			break;
			
		case 1:
			break;
		
		}
		logger.info("MemberService switch 종료");
		return obj;
	}
	
	private boolean idCheck(HashMap hashMap) {
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
	private ModelAndView signUp(HashMap hashMap) {
		
		setTransactionConf(TransactionDefinition.PROPAGATION_REQUIRED,
				TransactionDefinition.ISOLATION_READ_COMMITTED, false);
		
		if(idCheck(hashMap)) {
			if(dao.signUp(hashMap) != 0) {
				logger.info("회원 가입 성공");
				transaction = true;
				mav.setViewName("signInPage");
			}else {
				logger.info("회원 가입 실패");
				mav.addObject("message", "회원가입을 실패 했습니다.");
				mav.setViewName("signUp");
			}
		}
		setTransactionResult(transaction);
		
		return mav;		
	}
	

}
