package com.gx.soft.sb.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SysTypeDic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_type_dic", catalog = "njdtjsis")
public class SysTypeDic implements java.io.Serializable {

	// Fields

	private String rowId;
	private String dicName;
	private String dicType;
	private Integer dicTotal;
	private String dataOrdre;
	private String dataStatus;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public SysTypeDic() {
	}

	/** full constructor */
	public SysTypeDic(String dicName, String dicType, Integer dicTotal,
			String dataOrdre, String dataStatus, String dataDelete) {
		this.dicName = dicName;
		this.dicType = dicType;
		this.dicTotal = dicTotal;
		this.dataOrdre = dataOrdre;
		this.dataStatus = dataStatus;
		this.dataDelete = dataDelete;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rowId", unique = true, nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "dic_name", length = 40)
	public String getDicName() {
		return this.dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	@Column(name = "dic_type", length = 40)
	public String getDicType() {
		return this.dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	@Column(name = "dic_total")
	public Integer getDicTotal() {
		return this.dicTotal;
	}

	public void setDicTotal(Integer dicTotal) {
		this.dicTotal = dicTotal;
	}

	@Column(name = "data_ordre", length = 40)
	public String getDataOrdre() {
		return this.dataOrdre;
	}

	public void setDataOrdre(String dataOrdre) {
		this.dataOrdre = dataOrdre;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}