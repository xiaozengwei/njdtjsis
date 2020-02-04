package com.gx.soft.sys.persistence.manager;

import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.stereotype.Service;
import com.gx.core.hibernate.HibernateEntityDao;

@Service("vUserManager")
public class VUserManager extends HibernateEntityDao<VUser>{

}
