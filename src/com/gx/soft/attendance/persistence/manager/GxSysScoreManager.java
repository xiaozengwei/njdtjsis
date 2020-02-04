package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.GxSysScore;
import org.springframework.stereotype.Service;

@Service("gxSysScoreManager")
public class GxSysScoreManager extends HibernateEntityDao<GxSysScore>{
}
