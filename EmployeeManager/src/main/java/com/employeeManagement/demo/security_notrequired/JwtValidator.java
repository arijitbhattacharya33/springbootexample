package com.employeeManagement.demo.security_notrequired;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

//@Component
public class JwtValidator {

	/*
	 * String secretKey = "";
	 * 
	 * public Object validate(String token) { JwtUser user = null; try { Claims body
	 * = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	 * 
	 * user = new JwtUser(); user.setUsername(body.getSubject());
	 * user.setUserId(Long.parseLong((String) (body.get("userId"))));
	 * user.setRole((String) body.get("role")); } catch (Exception e) {
	 * 
	 * } return user; }
	 */
}
