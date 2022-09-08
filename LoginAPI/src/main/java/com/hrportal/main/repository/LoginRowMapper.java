package com.hrportal.main.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hrportal.main.domain.LoginDetails;

public class LoginRowMapper implements RowMapper<LoginDetails> {

	@Override
	public LoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String loginid = rs.getString("login_id");
		String username = rs.getString("user_name");
		String password = rs.getString("password");
		String designation = rs.getString("designation");
		LoginDetails loginDetails = new LoginDetails(loginid, username, password, designation);

		return loginDetails;
	}

}