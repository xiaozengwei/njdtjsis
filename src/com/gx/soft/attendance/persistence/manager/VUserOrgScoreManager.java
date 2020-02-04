package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.VUserOrgScore;
import org.springframework.stereotype.Service;

@Service("vUserOrgScoreManager")
public class VUserOrgScoreManager extends HibernateEntityDao<VUserOrgScore>{
}
