package com.gx.soft.sys.persistence.manager;

import org.springframework.stereotype.Service;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sys.persistence.domain.GxOaWenhaoConfig;

@Service("gxOaWenhaoConfigManager")
public class GxOaWenhaoConfigManager extends HibernateEntityDao<GxOaWenhaoConfig> {

}
