package com.mjs.licensing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 告诉spring boot 这是基于REST的服务，它将自动序列化/反序列化服务请求/响应到JSON
 * @RequestMapping注解 告诉spring容器该服务将要公开的HTTP端点 value属性为控制类中公开的所有端点URL的根
 */
@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
    /**
     * 创建一个Get端点/v1/organizations/{organizationId}/licenses/{licenseId}
     *
     * @param organizationId
     * @param licenseId
     * @return
     * @PathVariable 将值映射到方法参数内
     */
    @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return new License()
                .withId(licenseId)
                .withProductName("Teleco")
                .withLicenseType("Seat")
                .withOrganizationId(organizationId);
    }
}
