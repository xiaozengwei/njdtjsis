package com.gx.soft.wl.persistence.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * UnqualifiedTest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "unqualified_test", catalog = "njdtjsis")
public class UnqualifiedTest implements java.io.Serializable {

	// Fields

	private String rowId;
	private String materialName;
	private Date entrustDate;
	private Date testDate;
	private String usePosition;
	private String testProject;
	private String testReportNo;
	private String testResult;
	private String cjFj;
	private String handleOpinion;
	private String handleResult;
	private String qualifiedReportNo;
	private String remark;
	private String createUserId;
	private String createUserName;
	private Timestamp createTime;
	private String updateUserId;
	private String updateUserName;
	private Timestamp updateTime;
	private String comOrgId;
	private String comBdId;
	private String ext1;
	private Integer ext2;
	private Timestamp ext3;

	// Constructors

	/** default constructor */
	public UnqualifiedTest() {
	}

	/** full constructor */
	public UnqualifiedTest(String materialName, Date entrustDate,
			Date testDate, String usePosition, String testProject,
			String testReportNo, String testResult, String cjFj,
			String handleOpinion, String handleResult,
			String qualifiedReportNo, String remark, String createUserId,
			String createUserName, Timestamp createTime, String updateUserId,
			String updateUserName, Timestamp updateTime, String comOrgId,
			String comBdId, String ext1, Integer ext2, Timestamp ext3) {
		this.materialName = materialName;
		this.entrustDate = entrustDate;
		this.testDate = testDate;
		this.usePosition = usePosition;
		this.testProject = testProject;
		this.testReportNo = testReportNo;
		this.testResult = testResult;
		this.cjFj = cjFj;
		this.handleOpinion = handleOpinion;
		this.handleResult = handleResult;
		this.qualifiedReportNo = qualifiedReportNo;
		this.remark = remark;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.updateTime = updateTime;
		this.comOrgId = comOrgId;
		this.comBdId = comBdId;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "material_name", length = 40)
	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "entrust_date", length = 10)
	public Date getEntrustDate() {
		return this.entrustDate;
	}

	public void setEntrustDate(Date entrustDate) {
		this.entrustDate = entrustDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "test_date", length = 10)
	public Date getTestDate() {
		return this.testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Column(name = "use_position", length = 120)
	public String getUsePosition() {
		return this.usePosition;
	}

	public void setUsePosition(String usePosition) {
		this.usePosition = usePosition;
	}

	@Column(name = "test_project", length = 40)
	public String getTestProject() {
		return this.testProject;
	}

	public void setTestProject(String testProject) {
		this.testProject = testProject;
	}

	@Column(name = "test_report_no", length = 40)
	public String getTestReportNo() {
		return this.testReportNo;
	}

	public void setTestReportNo(String testReportNo) {
		this.testReportNo = testReportNo;
	}

	@Column(name = "test_result", length = 40)
	public String getTestResult() {
		return this.testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	@Column(name = "cj_fj", length = 40)
	public String getCjFj() {
		return this.cjFj;
	}

	public void setCjFj(String cjFj) {
		this.cjFj = cjFj;
	}

	@Column(name = "handle_opinion", length = 40)
	public String getHandleOpinion() {
		return this.handleOpinion;
	}

	public void setHandleOpinion(String handleOpinion) {
		this.handleOpinion = handleOpinion;
	}

	@Column(name = "handle_result", length = 40)
	public String getHandleResult() {
		return this.handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	@Column(name = "qualified_report_no", length = 40)
	public String getQualifiedReportNo() {
		return this.qualifiedReportNo;
	}

	public void setQualifiedReportNo(String qualifiedReportNo) {
		this.qualifiedReportNo = qualifiedReportNo;
	}

	@Column(name = "remark", length = 120)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "create_user_id", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_user_name", length = 40)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_user_id", length = 40)
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Column(name = "update_user_name", length = 40)
	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "com_org_id", length = 40)
	public String getComOrgId() {
		return this.comOrgId;
	}

	public void setComOrgId(String comOrgId) {
		this.comOrgId = comOrgId;
	}

	@Column(name = "com_bd_id", length = 40)
	public String getComBdId() {
		return this.comBdId;
	}

	public void setComBdId(String comBdId) {
		this.comBdId = comBdId;
	}

	@Column(name = "ext1", length = 40)
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public Integer getExt2() {
		return this.ext2;
	}

	public void setExt2(Integer ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3", length = 19)
	public Timestamp getExt3() {
		return this.ext3;
	}

	public void setExt3(Timestamp ext3) {
		this.ext3 = ext3;
	}

}