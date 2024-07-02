package com.app.whatsupmessage.repository;

import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.BlockTypeStatus;
import com.app.whatsupmessage.enums.RecordStatus;
import com.app.whatsupmessage.projection.BlockMenuProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlockSubMenuRepository extends JpaRepository<BlockSubMenu, Long> {

    Optional<BlockSubMenu> findByBlockSubMenuNameAndRecordStatusNot(String blockSubMenuName, RecordStatus recordStatus);

    Optional<BlockSubMenu> findByIdAndRecordStatusNot(Long id, RecordStatus recordStatus);

    @Query(value = """
      SELECT BM.BLOCK_MENU_ID AS menuId
     ,BM.BLOCK_MENU_NAME AS menuName
     ,BSM.BLOCK_SUBMENU_ID AS subMenuId
     ,BSM.BLOCK_SUBMENU_NAME AS subMenuName
     ,BSM.BLOCK_TYPE_STATUS AS blockType
     FROM BLOCK_SUBMENU AS BSM
     INNER JOIN BLOCK_MENU BM ON BM.BLOCK_MENU_ID =BSM.BLOCK_MENU_ID
     WHERE BSM.RECORD_STATUS <> 'DELETED'
     AND BM.RECORD_STATUS <> 'DELETED'
     AND BSM.BLOCK_TYPE_STATUS = 'DEFAULT'
     """,
        nativeQuery = true)
    List<BlockMenuProjection> defaultBlockMenuList();



    @Query(value = """
      SELECT BM.BLOCK_MENU_ID AS menuId
     ,BM.BLOCK_MENU_NAME AS menuName
     ,BSM.BLOCK_SUBMENU_ID AS subMenuId
     ,BSM.BLOCK_SUBMENU_NAME AS subMenuName
     ,BSM.BLOCK_TYPE_STATUS AS blockType
     FROM BLOCK_SUBMENU AS BSM
     INNER JOIN BLOCK_MENU BM ON BM.BLOCK_MENU_ID =BSM.BLOCK_MENU_ID
     WHERE BSM.RECORD_STATUS <> 'DELETED'
     AND BM.RECORD_STATUS <> 'DELETED'
     AND BSM.BLOCK_TYPE_STATUS = 'GENERAL'
     """,
            nativeQuery = true)
    List<BlockMenuProjection> generalBlockMenuList();

    @Query("SELECT b FROM BlockSubMenu b WHERE " +
            "b.blockSubMenuName LIKE CONCAT('%', :blockSubName, '%') AND " +
            "(:blockMenuId is null OR b.blockMenu.id =:blockMenuId ) AND " +
            "(:blockTypeStatus is null OR b.blockTypeStatus =:blockTypeStatus ) AND " +
            "b.recordStatus <> 'DELETED' "
    )
    Page<BlockSubMenu> searchBlockSubMenuList(@Param("blockSubName") String blockSubName, @Param("blockMenuId") Long blockMenuId, @Param("blockTypeStatus") BlockTypeStatus blockTypeStatus, Pageable pageable);

}
