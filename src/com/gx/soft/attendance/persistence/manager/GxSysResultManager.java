package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysResult;
import org.springframework.stereotype.Service;

@Service("gxSysResultManager")
public class GxSysResultManager extends HibernateEntityDao<GxSysResult>{
}
