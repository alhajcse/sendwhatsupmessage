package com.app.whatsupmessage.service.impl;

import com.app.whatsupmessage.dto.BlockMenuDto;
import com.app.whatsupmessage.entity.BlockMenu;
import com.app.whatsupmessage.enums.RecordStatus;
import com.app.whatsupmessage.exception.CustomMessagePresentException;
import com.app.whatsupmessage.helper.BlockMenuHelper;
import com.app.whatsupmessage.helper.GetListHelper;
import com.app.whatsupmessage.repository.BlockMenuRepository;
import com.app.whatsupmessage.service.BlockMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BlockMenuServiceImpl implements BlockMenuService {

    private final BlockMenuRepository repository;
    private final BlockMenuHelper helper;
    private final EntityManager em;


    @Override
    public BlockMenu findById(Long id) {
        return repository.findByIdAndRecordStatusNot(id, RecordStatus.DELETED)
                .orElseThrow(() -> new CustomMessagePresentException("Block menu not exists by Id"));
    }

    @Override
    public Optional<BlockMenu> findByBlockMenuName(String blockMenuName) {
        return repository.findByBlockMenuNameAndRecordStatusNot(blockMenuName,RecordStatus.DELETED);
    }

    @Override
    public BlockMenu save(BlockMenuDto dto) {
        BlockMenu blockMenu=dto.to();
        helper.getSaveData(blockMenu);
        return repository.save(blockMenu);
    }

    @Override
    public BlockMenu update(BlockMenuDto dto) {
        BlockMenu blockMenu = repository.findByIdAndRecordStatusNot(dto.getId(), RecordStatus.DELETED)
                .orElseThrow(() -> new CustomMessagePresentException("Block menu not exists by Id"));
        blockMenu=dto.update(blockMenu);
        helper.getUpdateData(blockMenu,blockMenu.getRecordStatus());
        return repository.save(blockMenu);
    }


    @Override
    public void delete(Long id) {
        BlockMenu blockMenu = repository.findByIdAndRecordStatusNot(id, RecordStatus.DELETED)
                .orElseThrow(() -> new UsernameNotFoundException("Block menu not exists by Id"));
        blockMenu.setRecordStatus(RecordStatus.DELETED);
        repository.save(blockMenu);
    }

    @Override
    public Map<String, Object> searchBlockMenuList(String blockMenuName, Integer page, Integer size, String sortBy) {
        GetListHelper<BlockMenu> helper = new GetListHelper<>(em, BlockMenu.class);
        return helper.getList(repository.searchBlockList(blockMenuName, helper.getPageable(sortBy, page, size)), page, size);
    }

    @Override
    public List<BlockMenu> findAll() {
        return repository.blockList();
    }
}
