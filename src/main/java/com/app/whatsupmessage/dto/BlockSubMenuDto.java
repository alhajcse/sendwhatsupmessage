package com.app.whatsupmessage.dto;
import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.BlockTypeStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class BlockSubMenuDto {

    private Long id;
    @NotNull
    private Long blockMenuId;
    @NotBlank
    private String blockSubMenuName;
    private String blockSubMenuDesc;
    private BlockTypeStatus blockTypeStatus;
    // Default value set to false

    public BlockSubMenu to() {
        BlockSubMenu blockMenu = new BlockSubMenu();
        blockMenu.setBlockSubMenuName(blockSubMenuName);
        blockMenu.setBlockSubMenuDesc(blockSubMenuDesc);
        blockMenu.setBlockTypeStatus(blockTypeStatus);
        return blockMenu;
    }

    public BlockSubMenu update(BlockSubMenu blockMenu) {
        blockMenu.setId(id);
        blockMenu.setBlockSubMenuName(blockSubMenuName);
        blockMenu.setBlockSubMenuDesc(blockSubMenuDesc);
        blockMenu.setBlockTypeStatus(blockTypeStatus);
        return blockMenu;
    }
}
