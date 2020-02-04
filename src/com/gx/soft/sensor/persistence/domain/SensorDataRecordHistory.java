package com.gx.soft.sensor.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SensorDataRecordHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sensor_data_record_history", catalog = "njdtjsis")
public class SensorDataRecordHistory implements java.io.Serializable {

	// Fields

	private String rowId;
	private String sensorSiteName;
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
	private String sensorDataPm25;
	private String sensorDataPm10;
	private String sensorDataHumidity;
	private String sensorDataWindSpeed;
	private String sensorDataWindDirection;
	private String sensorDataTemperature;
	private String sensorDataExt1;
	private String sensorDataExt2;
	private String sensorDataExt3;
	private String sensorDataExt4;
	private String sensorDataExt5;

	// Constructors

	/** default constructor */
	public SensorDataRecordHistory() {
	}

	/** full constructor */
	public SensorDataRecordHistory(String sensorSiteName, String sensorSiteJd,
			String sensorSiteWd, String sensorSiteId, String sensorSiteBd,
			String sensorSiteBdId, String sensorSiteType, Timestamp createTime,
			Timestamp updateTime, String status, Long orderNum,
			String sensorDataPm25, String sensorDataPm10,
			String sensorDataHumidity, String sensorDataWindSpeed,
			String sensorDataWindDirection, String sensorDataTemperature,
			String sensorDataExt1, String sensorDataExt2,
			String sensorDataExt3, String sensorDataExt4, String sensorDataExt5) {
		this.sensorSiteName = sensorSiteName;
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
		this.sensorDataPm25 = sensorDataPm25;
		this.sensorDataPm10 = sensorDataPm10;
		this.sensorDataHumidity = sensorDataHumidity;
		this.sensorDataWindSpeed = sensorDataWindSpeed;
		this.sensorDataWindDirection = sensorDataWindDirection;
		this.sensorDataTemperature = sensorDataTemperature;
		this.sensorDataExt1 = sensorDataExt1;
		this.sensorDataExt2 = sensorDataExt2;
		this.sensorDataExt3 = sensorDataExt3;
		this.sensorDataExt4 = sensorDataExt4;
		this.sensorDataExt5 = sensorDataExt5;
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

	@Column(name = "sensor_data_pm25", length = 140)
	public String getSensorDataPm25() {
		return this.sensorDataPm25;
	}

	public void setSensorDataPm25(String sensorDataPm25) {
		this.sensorDataPm25 = sensorDataPm25;
	}

	@Column(name = "sensor_data_pm10", length = 19)
	public String getSensorDataPm10() {
		return this.sensorDataPm10;
	}

	public void setSensorDataPm10(String sensorDataPm10) {
		this.sensorDataPm10 = sensorDataPm10;
	}

	@Column(name = "sensor_data_humidity", precision = 10, scale = 0)
	public String getSensorDataHumidity() {
		return this.sensorDataHumidity;
	}

	public void setSensorDataHumidity(String sensorDataHumidity) {
		this.sensorDataHumidity = sensorDataHumidity;
	}

	@Column(name = "sensor_data_wind_speed", length = 20)
	public String getSensorDataWindSpeed() {
		return this.sensorDataWindSpeed;
	}

	public void setSensorDataWindSpeed(String sensorDataWindSpeed) {
		this.sensorDataWindSpeed = sensorDataWindSpeed;
	}

	@Column(name = "sensor_data_wind_direction", length = 20)
	public String getSensorDataWindDirection() {
		return this.sensorDataWindDirection;
	}

	public void setSensorDataWindDirection(String sensorDataWindDirection) {
		this.sensorDataWindDirection = sensorDataWindDirection;
	}

	@Column(name = "sensor_data_temperature", length = 20)
	public String getSensorDataTemperature() {
		return this.sensorDataTemperature;
	}

	public void setSensorDataTemperature(String sensorDataTemperature) {
		this.sensorDataTemperature = sensorDataTemperature;
	}

	@Column(name = "sensor_data_ext1", length = 20)
	public String getSensorDataExt1() {
		return this.sensorDataExt1;
	}

	public void setSensorDataExt1(String sensorDataExt1) {
		this.sensorDataExt1 = sensorDataExt1;
	}

	@Column(name = "sensor_data_ext2", length = 20)
	public String getSensorDataExt2() {
		return this.sensorDataExt2;
	}

	public void setSensorDataExt2(String sensorDataExt2) {
		this.sensorDataExt2 = sensorDataExt2;
	}

	@Column(name = "sensor_data_ext3", length = 20)
	public String getSensorDataExt3() {
		return this.sensorDataExt3;
	}

	public void setSensorDataExt3(String sensorDataExt3) {
		this.sensorDataExt3 = sensorDataExt3;
	}

	@Column(name = "sensor_data_ext4", length = 20)
	public String getSensorDataExt4() {
		return this.sensorDataExt4;
	}

	public void setSensorDataExt4(String sensorDataExt4) {
		this.sensorDataExt4 = sensorDataExt4;
	}

	@Column(name = "sensor_data_ext5", length = 20)
	public String getSensorDataExt5() {
		return this.sensorDataExt5;
	}

	public void setSensorDataExt5(String sensorDataExt5) {
		this.sensorDataExt5 = sensorDataExt5;
	}

}