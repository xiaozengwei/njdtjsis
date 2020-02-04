package com.gx.soft.common.persistence.manager;

import org.springframework.stereotype.Service;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.common.persistence.domain.GxOaFormPrivillegeRelation;

@Service("formPrevillegeRelationManager")
public class GxOaFormPrevillegeRelationManager extends
		HibernateEntityDao<GxOaFormPrivillegeRelation> {

}
