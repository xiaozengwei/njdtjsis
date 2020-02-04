package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.GxSysAttendanceResult;
import org.springframework.stereotype.Service;

@Service("gxSysAttendanceResultManager")
public class GxSysAttendanceResultManager extends HibernateEntityDao<GxSysAttendanceResult> {
}
