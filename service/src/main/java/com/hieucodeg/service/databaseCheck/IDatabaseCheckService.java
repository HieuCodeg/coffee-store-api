package com.hieucodeg.service.databaseCheck;

import com.hieucodeg.domain.entity.DatabaseCheck;
import com.hieucodeg.service.IGeneralService;

public interface IDatabaseCheckService extends IGeneralService<DatabaseCheck> {
    DatabaseCheck getDatabaseCheck();

    DatabaseCheck updateWithTableCheck();

    DatabaseCheck updateWithProductCheck();
}
