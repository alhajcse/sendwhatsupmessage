package com.app.whatsupmessage.service;

import com.app.whatsupmessage.dto.LoginDto;
import com.app.whatsupmessage.dto.MessageTemplateDto;
import com.app.whatsupmessage.dto.SendMessageDto;
import com.app.whatsupmessage.dto.UserDto;
import com.app.whatsupmessage.entity.Users;
import com.app.whatsupmessage.response.LoginResponse;

public interface SendMessageService {
     String sendMessage(SendMessageDto dto);

     String createMessageTemplate(MessageTemplateDto dto);



     }
