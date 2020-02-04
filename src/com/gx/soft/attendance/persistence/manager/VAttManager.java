package com.gx.soft.attendance.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.attendance.persistence.domain.VAtt;
import org.springframework.stereotype.Service;

@Service("vAttManager")
public class VAttManager extends HibernateEntityDao<VAtt> {
}
