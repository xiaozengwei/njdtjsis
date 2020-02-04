package com.gx.soft.wl.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/7/25.
 */
@Entity
@Table(name = "material_info", schema = "njdtjsis", catalog = "")
public class MaterialInfo {
    private String rowId;
    private String materialType;
    private String materialName;
    private String materialModel;
    private String manufacturer;
    private String managerPerson;
    private String telephone;
    private Timestamp enterTime;
    private String outerTime;
    private Double enterNumber;
    private String measurementUnit;
    private String useSite;
    private String batchNumber;
    private String testStatus;
    private String certificateNum;
    private String customMessage;
    private String monitoringReport;
    private Timestamp createTime;
    private String createUserId;
    private String createUserName;
    private Timestamp updateTime;
    private String updateUserId;
    private String updateUserName;
    private String dataStatus;
    private Integer dataOrder;
    private String ext1;
    private Timestamp ext2;
    private Integer ext3;
    private String orgDwId;
    private String bdId;
    private String strengthGrade;
    private String curingCondition;
    private String reportNumber;
    private String testItem;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "row_id", unique = true, nullable = false, length = 40)
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "material_type")
    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Basic
    @Column(name = "material_name")
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    @Basic
    @Column(name = "material_model")
    public String getMaterialModel() {
        return materialModel;
    }

    public void setMaterialModel(String materialModel) {
        this.materialModel = materialModel;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "manager_person")
    public String getManagerPerson() {
        return managerPerson;
    }

    public void setManagerPerson(String managerPerson) {
        this.managerPerson = managerPerson;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "enter_time")
    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    @Basic
    @Column(name = "outer_time")
    public String getOuterTime() {
        return outerTime;
    }

    public void setOuterTime(String outerTime) {
        this.outerTime = outerTime;
    }

    @Basic
    @Column(name = "enter_number")
    public Double getEnterNumber() {
        return enterNumber;
    }

    public void setEnterNumber(Double enterNumber) {
        this.enterNumber = enterNumber;
    }

    @Basic
    @Column(name = "measurement_unit")
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Basic
    @Column(name = "use_site")
    public String getUseSite() {
        return useSite;
    }

    public void setUseSite(String useSite) {
        this.useSite = useSite;
    }

    @Basic
    @Column(name = "batch_number")
    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Basic
    @Column(name = "test_status")
    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }

    @Basic
    @Column(name = "certificate_num")
    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    @Basic
    @Column(name = "custom_message")
    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    @Basic
    @Column(name = "monitoring_report")
    public String getMonitoringReport() {
        return monitoringReport;
    }

    public void setMonitoringReport(String monitoringReport) {
        this.monitoringReport = monitoringReport;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "create_user_name")
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_user_id")
    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Basic
    @Column(name = "update_user_name")
    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    @Basic
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Basic
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "ext1")
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "ext2")
    public Timestamp getExt2() {
        return ext2;
    }

    public void setExt2(Timestamp ext2) {
        this.ext2 = ext2;
    }

    @Basic
    @Column(name = "ext3")
    public Integer getExt3() {
        return ext3;
    }

    public void setExt3(Integer ext3) {
        this.ext3 = ext3;
    }

    @Basic
    @Column(name = "org_dw_id")
    public String getOrgDwId() {
        return orgDwId;
    }

    public void setOrgDwId(String orgDwId) {
        this.orgDwId = orgDwId;
    }

    @Basic
    @Column(name = "bd_id")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    @Basic
    @Column(name = "strength_grade")
    public String getStrengthGrade() {
        return strengthGrade;
    }

    public void setStrengthGrade(String strengthGrade) {
        this.strengthGrade = strengthGrade;
    }

    @Basic
    @Column(name = "curing_condition")
    public String getCuringCondition() {
        return curingCondition;
    }

    public void setCuringCondition(String curingCondition) {
        this.curingCondition = curingCondition;
    }

    @Basic
    @Column(name = "report_number")
    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    @Basic
    @Column(name = "test_item")
    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialInfo that = (MaterialInfo) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (materialType != null ? !materialType.equals(that.materialType) : that.materialType != null) return false;
        if (materialName != null ? !materialName.equals(that.materialName) : that.materialName != null) return false;
        if (materialModel != null ? !materialModel.equals(that.materialModel) : that.materialModel != null)
            return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (managerPerson != null ? !managerPerson.equals(that.managerPerson) : that.managerPerson != null)
            return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (enterTime != null ? !enterTime.equals(that.enterTime) : that.enterTime != null) return false;
        if (outerTime != null ? !outerTime.equals(that.outerTime) : that.outerTime != null) return false;
        if (enterNumber != null ? !enterNumber.equals(that.enterNumber) : that.enterNumber != null) return false;
        if (measurementUnit != null ? !measurementUnit.equals(that.measurementUnit) : that.measurementUnit != null)
            return false;
        if (useSite != null ? !useSite.equals(that.useSite) : that.useSite != null) return false;
        if (batchNumber != null ? !batchNumber.equals(that.batchNumber) : that.batchNumber != null) return false;
        if (testStatus != null ? !testStatus.equals(that.testStatus) : that.testStatus != null) return false;
        if (certificateNum != null ? !certificateNum.equals(that.certificateNum) : that.certificateNum != null)
            return false;
        if (customMessage != null ? !customMessage.equals(that.customMessage) : that.customMessage != null)
            return false;
        if (monitoringReport != null ? !monitoringReport.equals(that.monitoringReport) : that.monitoringReport != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createUserName != null ? !createUserName.equals(that.createUserName) : that.createUserName != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;
        if (updateUserName != null ? !updateUserName.equals(that.updateUserName) : that.updateUserName != null)
            return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (ext1 != null ? !ext1.equals(that.ext1) : that.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;
        if (orgDwId != null ? !orgDwId.equals(that.orgDwId) : that.orgDwId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (strengthGrade != null ? !strengthGrade.equals(that.strengthGrade) : that.strengthGrade != null)
            return false;
        if (curingCondition != null ? !curingCondition.equals(that.curingCondition) : that.curingCondition != null)
            return false;
        if (reportNumber != null ? !reportNumber.equals(that.reportNumber) : that.reportNumber != null) return false;
        if (testItem != null ? !testItem.equals(that.testItem) : that.testItem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (materialType != null ? materialType.hashCode() : 0);
        result = 31 * result + (materialName != null ? materialName.hashCode() : 0);
        result = 31 * result + (materialModel != null ? materialModel.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (managerPerson != null ? managerPerson.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (enterTime != null ? enterTime.hashCode() : 0);
        result = 31 * result + (outerTime != null ? outerTime.hashCode() : 0);
        result = 31 * result + (enterNumber != null ? enterNumber.hashCode() : 0);
        result = 31 * result + (measurementUnit != null ? measurementUnit.hashCode() : 0);
        result = 31 * result + (useSite != null ? useSite.hashCode() : 0);
        result = 31 * result + (batchNumber != null ? batchNumber.hashCode() : 0);
        result = 31 * result + (testStatus != null ? testStatus.hashCode() : 0);
        result = 31 * result + (certificateNum != null ? certificateNum.hashCode() : 0);
        result = 31 * result + (customMessage != null ? customMessage.hashCode() : 0);
        result = 31 * result + (monitoringReport != null ? monitoringReport.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createUserName != null ? createUserName.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (updateUserName != null ? updateUserName.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        result = 31 * result + (orgDwId != null ? orgDwId.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (strengthGrade != null ? strengthGrade.hashCode() : 0);
        result = 31 * result + (curingCondition != null ? curingCondition.hashCode() : 0);
        result = 31 * result + (reportNumber != null ? reportNumber.hashCode() : 0);
        result = 31 * result + (testItem != null ? testItem.hashCode() : 0);
        return result;
    }
}
