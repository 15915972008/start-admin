package com.start.startsecurity.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 配置
 *
 * @author bojiangzhou 2018/09/17
 */
@Table(name = "sys_config")
public class Config {

    public static final String FIELD_CODE = "code";

    @Id
    private Long configId;
    private String code;
    private String value;

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
