package com.gx.soft.mobile.persistence.vo;

import com.gx.soft.home.persistence.domain.SxpzRecord;
import com.gx.soft.restservice.persistence.domain.VUserInOrgAtt;
import com.gx.soft.view.persistence.domain.DeviceCameraRecord;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adminstrator on 2019/7/3.
 */
public class HomeIndexVo {
    private String rowId;
    private String sxpzId;
    private String sxpzName;
    private String sxpzComId;
    private String sxpzBdId;
    private String sxpzComName;
    private String sxpzStatus;
    private Integer sxpzOrder;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String v1="0";
    private String v2="0";
    private String v3="0";
    private String v4="0";
    private String v5="0";
    private String h1="0";
    private String h2="0";
    private String h3="0";
    private String h4="0";
    private ArrayList<DeviceCameraRecord> h5;
    private String bdIntro="0";
    private String b1="0";
    private String b2="0";
    private String v6="0";
    private String v7="0";
    private String doorControl;

    public String getDoorControl() {
        return doorControl;
    }

    public void setDoorControl(String doorControl) {
        this.doorControl = doorControl;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getSxpzId() {
        return sxpzId;
    }

    public void setSxpzId(String sxpzId) {
        this.sxpzId = sxpzId;
    }

    public String getSxpzName() {
        return sxpzName;
    }

    public void setSxpzName(String sxpzName) {
        this.sxpzName = sxpzName;
    }

    public String getSxpzComId() {
        return sxpzComId;
    }

    public void setSxpzComId(String sxpzComId) {
        this.sxpzComId = sxpzComId;
    }

    public String getSxpzBdId() {
        return sxpzBdId;
    }

    public void setSxpzBdId(String sxpzBdId) {
        this.sxpzBdId = sxpzBdId;
    }

    public String getSxpzComName() {
        return sxpzComName;
    }

    public void setSxpzComName(String sxpzComName) {
        this.sxpzComName = sxpzComName;
    }

    public String getSxpzStatus() {
        return sxpzStatus;
    }

    public void setSxpzStatus(String sxpzStatus) {
        this.sxpzStatus = sxpzStatus;
    }

    public Integer getSxpzOrder() {
        return sxpzOrder;
    }

    public void setSxpzOrder(Integer sxpzOrder) {
        this.sxpzOrder = sxpzOrder;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public String getV4() {
        return v4;
    }

    public void setV4(String v4) {
        this.v4 = v4;
    }

    public String getV5() {
        return v5;
    }

    public void setV5(String v5) {
        this.v5 = v5;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getH4() {
        return h4;
    }

    public void setH4(String h4) {
        this.h4 = h4;
    }

    public ArrayList<DeviceCameraRecord> getH5() {
        return h5;
    }

    public void setH5(ArrayList<DeviceCameraRecord> h5) {
        this.h5 = h5;
    }

    public String getBdIntro() {
        return bdIntro;
    }

    public void setBdIntro(String bdIntro) {
        this.bdIntro = bdIntro;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getV6() {
        return v6;
    }

    public void setV6(String v6) {
        this.v6 = v6;
    }

    public String getV7() {
        return v7;
    }

    public void setV7(String v7) {
        this.v7 = v7;
    }
}
