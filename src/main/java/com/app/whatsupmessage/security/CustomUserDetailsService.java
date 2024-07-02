package com.app.whatsupmessage.security;

import com.app.whatsupmessage.entity.Users;
import com.app.whatsupmessage.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		Users users = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

		Set<GrantedAuthority> authorities = users.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toSet());
		return new User(usernameOrEmail, users.getPassword(), authorities);
	}
}
