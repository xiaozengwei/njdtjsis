package com.gx.soft.monitor.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.monitor.persistence.domain.YcMonitor;
import org.springframework.stereotype.Service;

@Service("ycMonitorManager")
public class YcMonitorManager extends HibernateEntityDao<YcMonitor> {
}
