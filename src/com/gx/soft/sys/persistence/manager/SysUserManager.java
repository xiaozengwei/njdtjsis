package com.gx.soft.sys.persistence.manager;

import org.springframework.stereotype.Service;
import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sys.persistence.domain.GxSysUser;

@Service("sysUserManager")
public class SysUserManager extends HibernateEntityDao<GxSysUser>{

}
