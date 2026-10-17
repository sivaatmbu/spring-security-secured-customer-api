package com.sp.www.Beans;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyEmployees implements UserDetails {

	private Employees emp;

	public MyEmployees(Employees emp) {
		this.emp=emp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public @Nullable String getPassword() {
		return emp.getPassword();
	}

	@Override
	public String getUsername() {
		return emp.getName();
	}

}
