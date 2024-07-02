
package com.app.whatsupmessage.helper;
import com.app.whatsupmessage.entity.BlockMenu;
import com.app.whatsupmessage.enums.RecordStatus;
import com.app.whatsupmessage.security.ActiveUserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
@RequiredArgsConstructor
public class BlockMenuHelper {

    @Resource
    private ActiveUserContext context;

    public void getSaveData(BlockMenu blockMenu) {
        blockMenu.setCreatedBy(context.getCurrentUserId());
        blockMenu.setRecordStatus(RecordStatus.ACTIVE);
    }

    public void getUpdateData(BlockMenu blockMenu, RecordStatus status) {
        blockMenu.setUpdatedBy(context.getCurrentUserId());
        blockMenu.setRecordStatus(status);
    }

}
