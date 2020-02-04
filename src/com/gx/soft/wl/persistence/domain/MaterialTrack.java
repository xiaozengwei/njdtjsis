package com.gx.soft.wl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * MaterialTrack entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "material_track", catalog = "njdtjsis")
public class MaterialTrack implements java.io.Serializable {

	// Fields

	private String rowId;
	private String relationId;
	private String materialType;
	private Integer useNumber;
	private Timestamp useTime;
	private String useReason;
	private String operatorId;
	private String opertaorName;
	private Timestamp createTime;
	private String createUserId;
	private String createUserName;
	private String dataStatus;
	private String dataOrder;
	private String ext1;
	private Timestamp ext2;
	private Integer ext3;

	// Constructors

	/** default constructor */
	public MaterialTrack() {
	}

	/** full constructor */
	public MaterialTrack(String relationId, String materialType,
			Integer useNumber, Timestamp useTime, String useReason,
			String operatorId, String opertaorName, Timestamp createTime,
			String createUserId, String createUserName, String dataStatus,
			String dataOrder, String ext1, Timestamp ext2, Integer ext3) {
		this.relationId = relationId;
		this.materialType = materialType;
		this.useNumber = useNumber;
		this.useTime = useTime;
		this.useReason = useReason;
		this.operatorId = operatorId;
		this.opertaorName = opertaorName;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
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

	@Column(name = "relation_id", length = 40)
	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@Column(name = "material_type", length = 40)
	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	@Column(name = "use_number")
	public Integer getUseNumber() {
		return this.useNumber;
	}

	public void setUseNumber(Integer useNumber) {
		this.useNumber = useNumber;
	}

	@Column(name = "use_time", length = 19)
	public Timestamp getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}

	@Column(name = "use_reason", length = 200)
	public String getUseReason() {
		return this.useReason;
	}

	public void setUseReason(String useReason) {
		this.useReason = useReason;
	}

	@Column(name = "operator_id", length = 40)
	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name = "opertaor_name", length = 40)
	public String getOpertaorName() {
		return this.opertaorName;
	}

	public void setOpertaorName(String opertaorName) {
		this.opertaorName = opertaorName;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_order", length = 40)
	public String getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(String dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "ext1", length = 40)
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

	@Column(name = "ext3")
	public Integer getExt3() {
		return this.ext3;
	}

	public void setExt3(Integer ext3) {
		this.ext3 = ext3;
	}

}