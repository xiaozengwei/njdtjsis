package com.gx.soft.process.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.process.persistence.domain.ProcInstance;
import org.springframework.stereotype.Service;

/**
 * Created by adminstrator on 2019/5/30.
 */
@Service
public class ProInstanceManager extends HibernateEntityDao<ProcInstance> {
}
