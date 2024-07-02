package com.app.whatsupmessage.response;

import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.BlockTypeStatus;
import com.app.whatsupmessage.enums.RecordStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlockSubMenuResponse {

    private Long id;
    private Long blockMenuId;
    private String blockSubMenuName;
    private String blockSubMenuDesc;
    private BlockTypeStatus blockTypeStatus;
    private RecordStatus recordStatus;

    public static BlockSubMenuResponse from(BlockSubMenu subMenu) {
        BlockSubMenuResponse response = new BlockSubMenuResponse();
        response.setId(subMenu.getId());
        response.setBlockMenuId(subMenu.getBlockMenu().getId());
        response.setBlockSubMenuName(subMenu.getBlockSubMenuName());
        response.setBlockSubMenuDesc(subMenu.getBlockSubMenuDesc());
        response.setBlockTypeStatus(subMenu.getBlockTypeStatus());
        response.setRecordStatus(subMenu.getRecordStatus());
        return response;
    }
}
