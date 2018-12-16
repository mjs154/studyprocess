package com.mjs.licensing.controllers;

/**
 * @Description 许可证BEAN
 * @ClassName License
 * @Author Administrator
 * @Data 2018/8/25 11:56
 * @Version 1.0
 */
public class License {
    private String licenseId;
    private String productName;
    private String licenseType;
    private String organizationId;

    public License withId(String licenseId) {
        this.licenseId = licenseId;
        return this;
    }
    public License withProductName(String productName){
        this.productName = productName;
        return this;
    }
    public License withLicenseType(String licenseType){
        this.licenseType = licenseType;
        return this;
    }
    public License withOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
