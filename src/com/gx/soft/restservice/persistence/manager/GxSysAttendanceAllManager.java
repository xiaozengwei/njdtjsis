package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.GxSysAttendanceAll;
import org.springframework.stereotype.Service;

@Service("gxSysAttendanceAllManager")
public class GxSysAttendanceAllManager extends HibernateEntityDao<GxSysAttendanceAll>{
}
