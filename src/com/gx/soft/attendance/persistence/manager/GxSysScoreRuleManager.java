package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysScoreRule;
import org.springframework.stereotype.Service;

@Service("gxSysScoreRuleManager")
public class GxSysScoreRuleManager extends HibernateEntityDao<GxSysScoreRule>{
}
