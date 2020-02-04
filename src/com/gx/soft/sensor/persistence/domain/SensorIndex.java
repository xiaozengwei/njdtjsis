package com.gx.soft.sensor.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SensorIndex entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sensor_index", catalog = "njdtjsis")
public class SensorIndex implements java.io.Serializable {

	// Fields

	private String rowId;
	private String sensorSiteName;
	private String sensorSiteAddress;
	private String sensorSiteDesc;
	private String sensorSiteJd;
	private String sensorSiteWd;
	private String sensorSiteId;
	private String sensorSiteBd;
	private String sensorSiteBdId;
	private String sensorSiteType;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String status;
	private Long orderNum;
	private String ext1;
	private Timestamp ext2;
	private Long ext3;

	// Constructors

	/** default constructor */
	public SensorIndex() {
	}

	/** full constructor */
	public SensorIndex(String sensorSiteName, String sensorSiteAddress,
			String sensorSiteDesc, String sensorSiteJd, String sensorSiteWd,
			String sensorSiteId, String sensorSiteBd, String sensorSiteBdId,
			String sensorSiteType, Timestamp createTime, Timestamp updateTime,
			String status, Long orderNum, String ext1, Timestamp ext2, Long ext3) {
		this.sensorSiteName = sensorSiteName;
		this.sensorSiteAddress = sensorSiteAddress;
		this.sensorSiteDesc = sensorSiteDesc;
		this.sensorSiteJd = sensorSiteJd;
		this.sensorSiteWd = sensorSiteWd;
		this.sensorSiteId = sensorSiteId;
		this.sensorSiteBd = sensorSiteBd;
		this.sensorSiteBdId = sensorSiteBdId;
		this.sensorSiteType = sensorSiteType;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.status = status;
		this.orderNum = orderNum;
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

	@Column(name = "sensor_site_name", length = 140)
	public String getSensorSiteName() {
		return this.sensorSiteName;
	}

	public void setSensorSiteName(String sensorSiteName) {
		this.sensorSiteName = sensorSiteName;
	}

	@Column(name = "sensor_site_address", length = 240)
	public String getSensorSiteAddress() {
		return this.sensorSiteAddress;
	}

	public void setSensorSiteAddress(String sensorSiteAddress) {
		this.sensorSiteAddress = sensorSiteAddress;
	}

	@Column(name = "sensor_site_desc", length = 240)
	public String getSensorSiteDesc() {
		return this.sensorSiteDesc;
	}

	public void setSensorSiteDesc(String sensorSiteDesc) {
		this.sensorSiteDesc = sensorSiteDesc;
	}

	@Column(name = "sensor_site_jd", length = 20)
	public String getSensorSiteJd() {
		return this.sensorSiteJd;
	}

	public void setSensorSiteJd(String sensorSiteJd) {
		this.sensorSiteJd = sensorSiteJd;
	}

	@Column(name = "sensor_site_wd", length = 20)
	public String getSensorSiteWd() {
		return this.sensorSiteWd;
	}

	public void setSensorSiteWd(String sensorSiteWd) {
		this.sensorSiteWd = sensorSiteWd;
	}

	@Column(name = "sensor_site_id", length = 40)
	public String getSensorSiteId() {
		return this.sensorSiteId;
	}

	public void setSensorSiteId(String sensorSiteId) {
		this.sensorSiteId = sensorSiteId;
	}

	@Column(name = "sensor_site_bd", length = 120)
	public String getSensorSiteBd() {
		return this.sensorSiteBd;
	}

	public void setSensorSiteBd(String sensorSiteBd) {
		this.sensorSiteBd = sensorSiteBd;
	}

	@Column(name = "sensor_site_bd_id", length = 40)
	public String getSensorSiteBdId() {
		return this.sensorSiteBdId;
	}

	public void setSensorSiteBdId(String sensorSiteBdId) {
		this.sensorSiteBdId = sensorSiteBdId;
	}

	@Column(name = "sensor_site_type", length = 40)
	public String getSensorSiteType() {
		return this.sensorSiteType;
	}

	public void setSensorSiteType(String sensorSiteType) {
		this.sensorSiteType = sensorSiteType;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "order_num", precision = 10, scale = 0)
	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "ext1", length = 140)
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2", length = 19)
	public Timestamp getExt2() {
		return this.ext2;
	}

	public void setExt2(Timestamp ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3", precision = 10, scale = 0)
	public Long getExt3() {
		return this.ext3;
	}

	public void setExt3(Long ext3) {
		this.ext3 = ext3;
	}

}