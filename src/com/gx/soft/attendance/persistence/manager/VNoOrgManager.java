package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.VNoOrg;
import org.springframework.stereotype.Service;

@Service("vNoOrgManager")
public class VNoOrgManager extends HibernateEntityDao<VNoOrg> {
}
