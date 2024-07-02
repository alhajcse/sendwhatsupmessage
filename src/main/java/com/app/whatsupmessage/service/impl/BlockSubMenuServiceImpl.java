package com.app.whatsupmessage.service.impl;

import com.app.whatsupmessage.dto.BlockSubMenuDto;
import com.app.whatsupmessage.entity.BlockMenu;
import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.BlockTypeStatus;
import com.app.whatsupmessage.enums.RecordStatus;
import com.app.whatsupmessage.exception.CustomMessagePresentException;
import com.app.whatsupmessage.helper.BlockSubMenuHelper;
import com.app.whatsupmessage.helper.GetListHelper;
import com.app.whatsupmessage.projection.BlockMenuProjection;
import com.app.whatsupmessage.repository.BlockMenuRepository;
import com.app.whatsupmessage.repository.BlockSubMenuRepository;
import com.app.whatsupmessage.service.BlockSubMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BlockSubMenuServiceImpl implements BlockSubMenuService {

    private final BlockSubMenuRepository repository;
    private final BlockMenuRepository menuRepository;
    private final BlockSubMenuHelper helper;
    private final EntityManager em;

    @Override
    public BlockSubMenu findById(Long id) {
        return repository.findByIdAndRecordStatusNot(id, RecordStatus.DELETED)
                .orElseThrow(() -> new CustomMessagePresentException("Block Sub menu not exists by Id"));
    }

    @Override
    public Optional<BlockSubMenu> findByBlockSubMenuName(String blockSubMenuName) {
        return repository.findByBlockSubMenuNameAndRecordStatusNot(blockSubMenuName,RecordStatus.DELETED);
    }

    @Override
    public BlockSubMenu save(BlockSubMenuDto dto) {
        BlockSubMenu subMenu=dto.to();
        BlockMenu blockMenu = menuRepository.findByIdAndRecordStatusNot(dto.getBlockMenuId(), RecordStatus.DELETED)
                .orElseThrow(() -> new CustomMessagePresentException("Block menu not exists by Id"));
        subMenu.setBlockMenu(blockMenu);
        helper.getSaveData(subMenu);
        return repository.save(subMenu);
    }

    @Override
    public BlockSubMenu update(BlockSubMenuDto dto) {
        BlockSubMenu subMenu = repository.findByIdAndRecordStatusNot(dto.getId(), RecordStatus.DELETED)
                .orElseThrow(() -> new CustomMessagePresentException("Block Sub menu not exists by Id"));
        subMenu=dto.update(subMenu);
        helper.getUpdateData(subMenu,subMenu.getRecordStatus());
        return repository.save(subMenu);
    }

    @Override
    public void delete(Long id) {
        BlockSubMenu subMenu = repository.findByIdAndRecordStatusNot(id, RecordStatus.DELETED)
                .orElseThrow(() -> new UsernameNotFoundException("Block menu not exists by Id"));
        subMenu.setRecordStatus(RecordStatus.DELETED);
        repository.save(subMenu);
    }

    @Override
    public Map<String, Object> searchBlockSubMenuList(String blockSubMenuName, Long blockMenuId, BlockTypeStatus blockTypeStatus, Integer page, Integer size, String sortBy) {
        GetListHelper<BlockSubMenu> helper = new GetListHelper<>(em, BlockSubMenu.class);
        return helper.getList(repository.searchBlockSubMenuList(blockSubMenuName,blockMenuId,blockTypeStatus, helper.getPageable(sortBy, page, size)), page, size);
    }
    @Override
    public List<BlockSubMenu> findAll() {
        return null;
    }

    @Override
    public List<BlockMenuProjection> defaultBlockMenuList() {
        return repository.defaultBlockMenuList();
    }

    @Override
    public List<BlockMenuProjection> generalBlockMenuList() {
        return repository.generalBlockMenuList();
    }
}
