package com.gx.soft.mobile.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.mobile.persistence.domain.BuildProgressRecord;
import org.springframework.stereotype.Service;

@Service
public class BuildProgressManager extends
		HibernateEntityDao<BuildProgressRecord> {

}
