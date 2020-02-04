package com.gx.soft.restservice.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import org.springframework.stereotype.Service;

@Service("vUserInOrgAttManager")
public class VUserInOrgAttManager extends HibernateEntityDao<VUserInOrgAtt> {
}
