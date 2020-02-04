package com.gx.soft.sys.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sys.persistence.domain.OrgDataOrderDefault;
import org.springframework.stereotype.Service;

@Service("orgDataOrderDefaultManager")
public class OrgDataOrderDefaultManager extends HibernateEntityDao<OrgDataOrderDefault>{
}
