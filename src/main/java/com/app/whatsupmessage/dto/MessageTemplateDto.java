package com.app.whatsupmessage.dto;

import com.app.whatsupmessage.entity.BlockMenu;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageTemplateDto {
    private String name;
    private String language;
    private String content;
}
