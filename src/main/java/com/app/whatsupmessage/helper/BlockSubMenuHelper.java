
package com.app.whatsupmessage.helper;
import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.enums.RecordStatus;
import com.app.whatsupmessage.security.ActiveUserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RequiredArgsConstructor
public class BlockSubMenuHelper {

    @Resource
    private ActiveUserContext context;

    public void getSaveData(BlockSubMenu subMenu) {
        subMenu.setCreatedBy(context.getCurrentUserId());
        subMenu.setRecordStatus(RecordStatus.ACTIVE);
    }

    public void getUpdateData(BlockSubMenu subMenu, RecordStatus status) {
        subMenu.setUpdatedBy(context.getCurrentUserId());
        subMenu.setRecordStatus(status);
    }

}
