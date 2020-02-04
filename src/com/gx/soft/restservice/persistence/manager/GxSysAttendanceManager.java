package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.GxSysAttendance;
import org.springframework.stereotype.Service;

@Service("gxSysAttendanceManager")
public class GxSysAttendanceManager extends HibernateEntityDao<GxSysAttendance>{
}
