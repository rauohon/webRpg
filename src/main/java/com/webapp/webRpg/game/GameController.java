package com.webapp.webRpg.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {
	
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	
	@RequestMapping(value = "village", method = RequestMethod.POST)
	public String village() {
		logger.info("game start!");
		
		return "village.tiles";
	}

}
