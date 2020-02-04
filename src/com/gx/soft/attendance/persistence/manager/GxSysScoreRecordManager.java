package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysScoreRecord;
import org.springframework.stereotype.Service;

@Service("gxSysScoreRecordManager")
public class GxSysScoreRecordManager extends HibernateEntityDao<GxSysScoreRecord>{
}
