package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysEnt;
import org.springframework.stereotype.Service;

@Service("gxSysEntManager")
public class GxSysEntManager extends HibernateEntityDao<GxSysEnt>{
}
