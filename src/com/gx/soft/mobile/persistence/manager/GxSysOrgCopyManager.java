package com.gx.soft.mobile.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.mobile.persistence.domain.GxSysOrgCopy;
import org.springframework.stereotype.Service;

@Service("gxSysOrgCopyManager")
public class GxSysOrgCopyManager extends HibernateEntityDao<GxSysOrgCopy> {
}
