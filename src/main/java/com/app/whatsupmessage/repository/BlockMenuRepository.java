package com.app.whatsupmessage.repository;


import com.app.whatsupmessage.entity.BlockMenu;
import com.app.whatsupmessage.enums.RecordStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlockMenuRepository extends JpaRepository<BlockMenu, Long> {

    Optional<BlockMenu> findByBlockMenuNameAndRecordStatusNot(String blockMenuName,RecordStatus recordStatus);

    Optional<BlockMenu> findByIdAndRecordStatusNot(Long id, RecordStatus recordStatus);

    @Query("SELECT b FROM BlockMenu b WHERE " +
            "b.recordStatus <> 'DELETED'")
    List<BlockMenu> blockList();

    @Query("SELECT b FROM BlockMenu b WHERE " +
            "b.blockMenuName LIKE CONCAT('%', :blockName, '%') AND " +
            "b.recordStatus <> 'DELETED' "
    )
    Page<BlockMenu> searchBlockList(@Param("blockName") String blockName, Pageable pageable);

}
