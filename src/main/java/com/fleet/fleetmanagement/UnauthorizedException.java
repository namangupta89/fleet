package com.fleet.fleetmanagement;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7522677709267331968L;
	protected static MessageSourceAccessor messageSourceAccessor = SpringSecurityMessageSource.getAccessor();
	
	
	public UnauthorizedException() {
		super(messageSourceAccessor.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied !!!!"));
	}

	public UnauthorizedException(String message) {
		super(message);
	}
	
}
