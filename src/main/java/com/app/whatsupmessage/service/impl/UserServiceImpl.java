package com.app.whatsupmessage.service.impl;

import com.app.whatsupmessage.dto.LoginDto;
import com.app.whatsupmessage.dto.RoleListDto;
import com.app.whatsupmessage.dto.UserDto;
import com.app.whatsupmessage.entity.Role;
import com.app.whatsupmessage.entity.Users;
import com.app.whatsupmessage.repository.RoleRepository;
import com.app.whatsupmessage.repository.UserRepository;
import com.app.whatsupmessage.response.LoginResponse;
import com.app.whatsupmessage.response.UserResponse;
import com.app.whatsupmessage.security.JwtGenerator;
import com.app.whatsupmessage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtTokenProvider;

    @Override
    @Transactional
    public Users saveUser(UserDto dto) {

        Set<Role> attachedRoles = new HashSet<>();
        Users user=dto.to();
        // Encrypt the user's password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        for (RoleListDto role : dto.getRoles()) {
            Optional<Role> existingRole = roleRepository.findByRoleName(role.getRoleName());
            Role role1=new Role();
            if (existingRole.isPresent()) {
                attachedRoles.add(existingRole.get());
            } else {
                role1.setRoleName(role.getRoleName());
                attachedRoles.add(role1);
            }
            user.setRoles(attachedRoles);
            roleRepository.save(role1);
        }
        return userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginDto dto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Users users = userRepository.findByUsernameOrEmail(dto.getUsername(), dto.getPassword())
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        String accessToken = jwtTokenProvider.generateAccessToken(authentication, users.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(authentication, users.getId());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);
        loginResponse.setExpiresIn(jwtTokenProvider.accessTokenExpire());
        loginResponse.setUser(UserResponse.from(users));
        return loginResponse;

    }
}
