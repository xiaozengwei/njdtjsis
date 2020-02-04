package com.gx.soft.home.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.home.persistence.domain.SxpzRecord;
import org.springframework.stereotype.Service;

@Service("sxpzRecordManager")
public class SxpzRecordManager extends
		HibernateEntityDao<SxpzRecord> {

}
