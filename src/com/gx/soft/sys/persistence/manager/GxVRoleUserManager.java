package com.gx.soft.sys.persistence.manager;

import org.springframework.stereotype.Service;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sys.persistence.domain.VRoleUser;

@Service("vRoleUserManager")
public class GxVRoleUserManager extends HibernateEntityDao<VRoleUser>{

}
