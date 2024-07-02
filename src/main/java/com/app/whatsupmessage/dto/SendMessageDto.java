package com.app.whatsupmessage.dto;

import com.app.whatsupmessage.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class SendMessageDto {

    private String message;
    private Set<ToNumberDto> toNumberDtos;



}
