package com.gx.soft.sys.persistence.manager;

import org.springframework.stereotype.Service;

import com.gx.core.hibernate.HibernateEntityDao;

@Service("orgHasUserManager")
public class OrgHasUserManager extends
		HibernateEntityDao<GxSysUserInOrgManager> {

}
