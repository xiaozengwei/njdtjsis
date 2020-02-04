package com.gx.soft.sys.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaWenhaoMax entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_wenhao_max")
public class GxOaWenhaoMax implements java.io.Serializable {

	// Fields

	private String wenhaoMaxRowId;
	private String maxWenhao;//文号最大值
	private String extend1;
	private String extend2;

	// Constructors

	/** default constructor */
	public GxOaWenhaoMax() {
	}

	/** full constructor */
	public GxOaWenhaoMax(String maxWenhao, String extend1, String extend2) {
		this.maxWenhao = maxWenhao;
		this.extend1 = extend1;
		this.extend2 = extend2;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "wenhao_max_row_id", unique = true, nullable = false, length = 50)
	public String getWenhaoMaxRowId() {
		return this.wenhaoMaxRowId;
	}

	public void setWenhaoMaxRowId(String wenhaoMaxRowId) {
		this.wenhaoMaxRowId = wenhaoMaxRowId;
	}

	@Column(name = "max_wenhao", length = 50)
	public String getMaxWenhao() {
		return this.maxWenhao;
	}

	public void setMaxWenhao(String maxWenhao) {
		this.maxWenhao = maxWenhao;
	}

	@Column(name = "extend1", length = 40)
	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	@Column(name = "extend2", length = 40)
	public String getExtend2() {
		return this.extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

}