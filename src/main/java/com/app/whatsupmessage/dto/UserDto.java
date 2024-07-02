package com.app.whatsupmessage.dto;

import com.app.whatsupmessage.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<RoleListDto> roles;


    public Users to() {
        Users user = new Users();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;

    }

    public Users update(Users user) {
        user.setId(id);
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
