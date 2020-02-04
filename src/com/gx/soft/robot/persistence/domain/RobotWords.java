package com.gx.soft.robot.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RobotWords entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "robot_words", catalog = "njdtjsis")
public class RobotWords implements java.io.Serializable {

	// Fields

	private String rowId;
	private String rwordsType;
	private String askRwords;
	private String answerRwords;
	private String nextRwords;
	private String rwordsStatus;
	private Long rwordsOrder;
	private String rwordsId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String ext1;
	private Timestamp ext2;
	private Long ext3;

	// Constructors

	/** default constructor */
	public RobotWords() {
	}

	/** full constructor */
	public RobotWords(String rwordsType, String askRwords, String answerRwords,
			String nextRwords, String rwordsStatus, Long rwordsOrder,
			String rwordsId, Timestamp createTime, Timestamp updateTime,
			String ext1, Timestamp ext2, Long ext3) {
		this.rwordsType = rwordsType;
		this.askRwords = askRwords;
		this.answerRwords = answerRwords;
		this.nextRwords = nextRwords;
		this.rwordsStatus = rwordsStatus;
		this.rwordsOrder = rwordsOrder;
		this.rwordsId = rwordsId;
		this.createTime = createTime;
		this.updateTime = updateTime;
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

	@Column(name = "rwords_type", length = 140)
	public String getRwordsType() {
		return this.rwordsType;
	}

	public void setRwordsType(String rwordsType) {
		this.rwordsType = rwordsType;
	}

	@Column(name = "ask_rwords", length = 540)
	public String getAskRwords() {
		return this.askRwords;
	}

	public void setAskRwords(String askRwords) {
		this.askRwords = askRwords;
	}

	@Column(name = "answer_rwords", length = 540)
	public String getAnswerRwords() {
		return this.answerRwords;
	}

	public void setAnswerRwords(String answerRwords) {
		this.answerRwords = answerRwords;
	}

	@Column(name = "next_rwords", length = 50)
	public String getNextRwords() {
		return this.nextRwords;
	}

	public void setNextRwords(String nextRwords) {
		this.nextRwords = nextRwords;
	}

	@Column(name = "rwords_status", length = 20)
	public String getRwordsStatus() {
		return this.rwordsStatus;
	}

	public void setRwordsStatus(String rwordsStatus) {
		this.rwordsStatus = rwordsStatus;
	}

	@Column(name = "rwords_order", precision = 10, scale = 0)
	public Long getRwordsOrder() {
		return this.rwordsOrder;
	}

	public void setRwordsOrder(Long rwordsOrder) {
		this.rwordsOrder = rwordsOrder;
	}

	@Column(name = "rwords_id", length = 120)
	public String getRwordsId() {
		return this.rwordsId;
	}

	public void setRwordsId(String rwordsId) {
		this.rwordsId = rwordsId;
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