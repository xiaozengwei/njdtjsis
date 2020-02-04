package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysAttRule;
import org.springframework.stereotype.Service;

@Service("gxSysAttRuleManager")
public class GxSysAttRuleManager extends HibernateEntityDao<GxSysAttRule>{
}
