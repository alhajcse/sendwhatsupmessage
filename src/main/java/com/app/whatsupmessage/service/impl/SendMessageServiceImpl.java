package com.app.whatsupmessage.service.impl;

import com.app.whatsupmessage.dto.SendMessageDto;
import com.app.whatsupmessage.dto.ToNumberDto;
import com.app.whatsupmessage.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@RequiredArgsConstructor
public class SendMessageServiceImpl implements SendMessageService {

    private final RestTemplate restTemplate;

    @Override
    public String sendMessage(SendMessageDto dto) {

        dto.getToNumberDtos().forEach(f->{
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.setBearerAuth("EAAL34UIOZBLwBOzSdotlWKa8hYOkCD1iZCfEZAwtFEDN6UGPQzT9VDuPJi9sVCJYOgDt7MG2V1sf2MAItC6L8sqNprTF9ZB9sYXkfEhjLZBdISrUIrVmwyQw6eziZCWqB1qfViGbxGZB7jCp8AK2W3LYNR65dbOZCI30rwhZBnycriMfH4IhRHxgpbAqMk8UZCcOjTHiLGRoZABL9FHqqjd");
                headers.set("Content-Type", "application/json");
                

                JSONObject requestBody = new JSONObject();
                requestBody.put("messaging_product", "whatsapp");
                requestBody.put("to", f.getToNumber());
                requestBody.put("type", "template");

                JSONObject template = new JSONObject();
                template.put("name", dto.getMessage());

                JSONObject language = new JSONObject();
                language.put("code", "en_US");

                template.put("language", language);

                requestBody.put("template", template);


                HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);
                ResponseEntity<String> response = restTemplate.exchange("https://graph.facebook.com/v19.0/373412419184442/messages", HttpMethod.POST, request, String.class);

               // return response.getBody();
            } catch (Exception e) {
                e.printStackTrace();
               // return "Error sending message: " + e.getMessage();
            }


        });

        return null;
    }
}
