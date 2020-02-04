package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.AttendanceRecordTime;
import org.springframework.stereotype.Service;

@Service("attendanceRecordTimeManager")
public class AttendanceRecordTimeManager extends HibernateEntityDao<AttendanceRecordTime> {
}
