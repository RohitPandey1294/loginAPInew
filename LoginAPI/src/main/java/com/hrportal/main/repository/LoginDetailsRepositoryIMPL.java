package com.hrportal.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrportal.main.domain.LoginDetails;

@Repository
public class LoginDetailsRepositoryIMPL implements LoginDetailsRepositoryInterface {
	private static final String SELECT_ALL_LOGIN_DETAILS = "SELECT * FROM LOGIN_DETAILS";
	private static final String SELECT_SINGLE_LOGIN = "SELECT * FROM LOGIN_DETAILS WHERE LOGIN_ID=?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<LoginDetails> getallLoginDetailsList() {
		List<LoginDetails> allUsers = jdbcTemplate.query(SELECT_ALL_LOGIN_DETAILS, new LoginRowMapper());
		return allUsers;
	}

	@Override
	public LoginDetails getLoginDetailsbyLoginId(String loginId) {

		LoginDetails loginDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_LOGIN, new LoginRowMapper(), loginId);
		return loginDetails;

	}

}
