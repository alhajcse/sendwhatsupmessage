package com.app.whatsupmessage.service;

import com.app.whatsupmessage.dto.BlockSubMenuDto;
import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.BlockTypeStatus;
import com.app.whatsupmessage.projection.BlockMenuProjection;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BlockSubMenuService {

    BlockSubMenu findById(Long id);

    Optional<BlockSubMenu> findByBlockSubMenuName(String blockSubMenuName);

    BlockSubMenu save(BlockSubMenuDto dto);

    BlockSubMenu update(BlockSubMenuDto dto);

    void delete(Long id);

    Map<String, Object> searchBlockSubMenuList(String blockSubMenuName, Long blockMenuId, BlockTypeStatus blockTypeStatus, Integer page, Integer size, String sortBy);

    List<BlockSubMenu> findAll();

    List<BlockMenuProjection> defaultBlockMenuList();

    List<BlockMenuProjection> generalBlockMenuList();


}
