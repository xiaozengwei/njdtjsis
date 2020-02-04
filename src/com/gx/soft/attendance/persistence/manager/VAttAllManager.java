package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.VAttAll;
import org.springframework.stereotype.Service;

@Service("vAttAllManager")
public class VAttAllManager extends HibernateEntityDao<VAttAll> {
}
