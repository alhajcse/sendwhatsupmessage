package com.app.whatsupmessage.resources;

import com.app.whatsupmessage.dto.LoginDto;
import com.app.whatsupmessage.dto.UserDto;
import com.app.whatsupmessage.response.LoginResponse;
import com.app.whatsupmessage.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.app.whatsupmessage.utils.ResponseBuilder.success;
import static org.springframework.http.ResponseEntity.ok;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UsersResource {

    private final UserService service;


    @PostMapping("/login")
    @Operation(summary = "User Login", description = "User Login")
    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponse.class))})
    public ResponseEntity<JSONObject> login( @RequestBody LoginDto dto) {

        LoginResponse response=service.login(dto);

        return ok(success(response).getJson());
    }

    @PostMapping("/registration")
    @Operation(summary = "User Registration", description = "User Registration")
    @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    public ResponseEntity<JSONObject> saveUser(@Valid @RequestBody UserDto dto) {

        service.saveUser(dto);
        return ok(success(null, "Block Menu Save Successfully").getJson());
    }
}
