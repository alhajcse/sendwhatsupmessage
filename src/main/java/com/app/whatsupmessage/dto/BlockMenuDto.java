package com.app.whatsupmessage.dto;

import com.app.whatsupmessage.entity.BlockMenu;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class BlockMenuDto {

    private Long id;
    @NotBlank
    private String blockMenuName;
    private String blockMenuDesc;

    public BlockMenu to() {
        BlockMenu blockMenu = new BlockMenu();
        blockMenu.setBlockMenuName(blockMenuName);
        blockMenu.setBlockMenuDesc(blockMenuDesc);
        return blockMenu;
    }

    public BlockMenu update(BlockMenu blockMenu) {
        blockMenu.setId(id);
        blockMenu.setBlockMenuName(blockMenuName);
        blockMenu.setBlockMenuDesc(blockMenuDesc);
        return blockMenu;
    }
}
