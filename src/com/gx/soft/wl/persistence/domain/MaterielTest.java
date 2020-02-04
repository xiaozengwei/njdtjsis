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
 * MaterielTest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "materiel_test", catalog = "njdtjsis")
public class MaterielTest implements java.io.Serializable {

	// Fields

	private String rowId;
	private String reportNo;
	private String materielType;
	private String materielLevel;
	private String materielModel;
	private Date reportDate;
	private String manufacturer;
	private Double enterNumber;
	private String enterPh;
	private Date enterDate;
	private String useSite;
	private String samplePlace;
	private Date sampleDate;
	private String sampleUser;
	private String witness;
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
	public MaterielTest() {
	}

	/** full constructor */
	public MaterielTest(String reportNo, String materielType,
			String materielLevel, String materielModel, Date reportDate,
			String manufacturer, Double enterNumber, String enterPh,
			Date enterDate, String useSite, String samplePlace,
			Date sampleDate, String sampleUser, String witness, String remark,
			String createUserId, String createUserName, Timestamp createTime,
			String updateUserId, String updateUserName, Timestamp updateTime,
			String comOrgId, String comBdId, String ext1, Integer ext2,
			Timestamp ext3) {
		this.reportNo = reportNo;
		this.materielType = materielType;
		this.materielLevel = materielLevel;
		this.materielModel = materielModel;
		this.reportDate = reportDate;
		this.manufacturer = manufacturer;
		this.enterNumber = enterNumber;
		this.enterPh = enterPh;
		this.enterDate = enterDate;
		this.useSite = useSite;
		this.samplePlace = samplePlace;
		this.sampleDate = sampleDate;
		this.sampleUser = sampleUser;
		this.witness = witness;
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

	@Column(name = "report_no", length = 40)
	public String getReportNo() {
		return this.reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	@Column(name = "materiel_type", length = 40)
	public String getMaterielType() {
		return this.materielType;
	}

	public void setMaterielType(String materielType) {
		this.materielType = materielType;
	}

	@Column(name = "materiel_level", length = 40)
	public String getMaterielLevel() {
		return this.materielLevel;
	}

	public void setMaterielLevel(String materielLevel) {
		this.materielLevel = materielLevel;
	}

	@Column(name = "materiel_model", length = 40)
	public String getMaterielModel() {
		return this.materielModel;
	}

	public void setMaterielModel(String materielModel) {
		this.materielModel = materielModel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "report_date", length = 10)
	public Date getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	@Column(name = "manufacturer", length = 40)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "enter_number", precision = 22, scale = 0)
	public Double getEnterNumber() {
		return this.enterNumber;
	}

	public void setEnterNumber(Double enterNumber) {
		this.enterNumber = enterNumber;
	}

	@Column(name = "enter_ph", length = 40)
	public String getEnterPh() {
		return this.enterPh;
	}

	public void setEnterPh(String enterPh) {
		this.enterPh = enterPh;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enter_date", length = 10)
	public Date getEnterDate() {
		return this.enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	@Column(name = "use_site", length = 40)
	public String getUseSite() {
		return this.useSite;
	}

	public void setUseSite(String useSite) {
		this.useSite = useSite;
	}

	@Column(name = "sample_place", length = 40)
	public String getSamplePlace() {
		return this.samplePlace;
	}

	public void setSamplePlace(String samplePlace) {
		this.samplePlace = samplePlace;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "sample_date", length = 10)
	public Date getSampleDate() {
		return this.sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	@Column(name = "sample_user", length = 40)
	public String getSampleUser() {
		return this.sampleUser;
	}

	public void setSampleUser(String sampleUser) {
		this.sampleUser = sampleUser;
	}

	@Column(name = "witness", length = 40)
	public String getWitness() {
		return this.witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
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