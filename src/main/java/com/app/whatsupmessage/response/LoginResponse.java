package com.app.whatsupmessage.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    private Long expiresIn;

    private String accessToken;

    private String refreshToken;

    private UserResponse user;
}
