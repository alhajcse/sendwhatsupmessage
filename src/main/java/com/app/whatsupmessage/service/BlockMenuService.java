package com.app.whatsupmessage.service;

import com.app.whatsupmessage.dto.BlockMenuDto;
import com.app.whatsupmessage.entity.BlockMenu;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BlockMenuService {

    BlockMenu findById(Long id);

    Optional<BlockMenu> findByBlockMenuName(String blockMenuName);

    BlockMenu save(BlockMenuDto dto);

    BlockMenu update(BlockMenuDto dto);

    void delete(Long id);

    Map<String, Object> searchBlockMenuList(String blockMenuName, Integer page, Integer size, String sortBy);

    List<BlockMenu> findAll();
}
