package com.gx.soft.common.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaFormPrivillegeRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_form_privillege_relation")
public class GxOaFormPrivillegeRelation implements java.io.Serializable {

	// Fields

	private String rowId;
	private String processTemplateId;//流程模版ID
	private String activityId;//流程节点ID
	private String businessKey;//业务类型sw/fw
	private String formElementName;//表单元素名称
	private String elementPrivillege;//元素权限(R/W)
	private Timestamp createTime;//创建时间
	private String createUserId;//
	private String relationStatus;
	private String relationComment;
	private String formElementComment;
	// Constructors

	/** default constructor */
	public GxOaFormPrivillegeRelation() {
	}

	/** full constructor */
	public GxOaFormPrivillegeRelation(String processTemplateId,
			String activityId, String businessKey, String formElementName,
			String elementPrivillege, Timestamp createTime,
			String createUserId, String relationStatus, String relationComment) {
		this.processTemplateId = processTemplateId;
		this.activityId = activityId;
		this.businessKey = businessKey;
		this.formElementName = formElementName;
		this.elementPrivillege = elementPrivillege;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.relationStatus = relationStatus;
		this.relationComment = relationComment;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 32)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "process_template_id", length = 40)
	public String getProcessTemplateId() {
		return this.processTemplateId;
	}

	public void setProcessTemplateId(String processTemplateId) {
		this.processTemplateId = processTemplateId;
	}

	@Column(name = "activity_id", length = 40)
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "business_key", length = 40)
	public String getBusinessKey() {
		return this.businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	@Column(name = "form_element_name", length = 200)
	public String getFormElementName() {
		return this.formElementName;
	}

	public void setFormElementName(String formElementName) {
		this.formElementName = formElementName;
	}

	@Column(name = "element_privillege", length = 200)
	public String getElementPrivillege() {
		return this.elementPrivillege;
	}

	public void setElementPrivillege(String elementPrivillege) {
		this.elementPrivillege = elementPrivillege;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user_id", length = 50)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "relation_status", length = 50)
	public String getRelationStatus() {
		return this.relationStatus;
	}

	public void setRelationStatus(String relationStatus) {
		this.relationStatus = relationStatus;
	}

	@Column(name = "relation_comment", length = 200)
	public String getRelationComment() {
		return this.relationComment;
	}

	public void setRelationComment(String relationComment) {
		this.relationComment = relationComment;
	}

	@Column(name = "form_element_comment", length = 200)
	public String getFormElementComment() {
		return formElementComment;
	}

	public void setFormElementComment(String formElementComment) {
		this.formElementComment = formElementComment;
	}

}