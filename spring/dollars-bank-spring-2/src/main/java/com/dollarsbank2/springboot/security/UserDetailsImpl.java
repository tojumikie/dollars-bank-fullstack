package com.dollarsbank2.springboot.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dollarsbank2.springboot.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String username;
	@JsonIgnore
	private String password;
	private Double amount;
	private Collection<? extends GrantedAuthority> authorities;
	public UserDetailsImpl(Long id, String name, String username, String password, Double amount,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.amount = amount;
		this.authorities = authorities;
	}
	public UserDetailsImpl() {
		
	}
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getName(), user.getUsername(), 
				user.getPassword(), user.getAmount(), authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public Double getAmount() {
		return amount;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		UserDetailsImpl user = (UserDetailsImpl) obj;
		return Objects.equals(id, user.id);
	}
}