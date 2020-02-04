package com.gx.soft.mobile.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.mobile.persistence.domain.VUserCopy;
import org.springframework.stereotype.Service;

@Service("vUserCopyManager")
public class VUserCopyManager extends HibernateEntityDao<VUserCopy>{
}
