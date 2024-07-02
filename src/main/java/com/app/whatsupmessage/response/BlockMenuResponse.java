package com.app.whatsupmessage.response;

import com.app.whatsupmessage.entity.BlockMenu;
import com.app.whatsupmessage.enums.RecordStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlockMenuResponse {

    private Long id;
    private String blockMenuName;
    private String blockMenuDesc;
    private RecordStatus recordStatus;

    public static BlockMenuResponse from(BlockMenu blockMenu) {
        BlockMenuResponse response = new BlockMenuResponse();
        response.setId(blockMenu.getId());
        response.setBlockMenuName(blockMenu.getBlockMenuName());
        response.setBlockMenuDesc(blockMenu.getBlockMenuDesc());
        response.setRecordStatus(blockMenu.getRecordStatus());
        return response;
    }
}
