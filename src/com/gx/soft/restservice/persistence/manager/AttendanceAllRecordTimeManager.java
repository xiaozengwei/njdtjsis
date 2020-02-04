package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.AttendanceAllRecordTime;
import org.springframework.stereotype.Service;

@Service("attendanceAllRecordTimeManager")
public class AttendanceAllRecordTimeManager extends HibernateEntityDao<AttendanceAllRecordTime> {
}
