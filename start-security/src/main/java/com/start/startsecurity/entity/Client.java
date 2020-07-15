package com.start.startsecurity.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OAuth 客户端
 *
 * @author bojiangzhou 2018/11/03
 */
@Table(name = "oauth_client")
public class Client {

    public static final String FIELD_CLIENT_ID = "clientId";

    @Id
    private Long id;
    /**
     * 客户端ID
     */
    private String clientId;
    /**
     * 客户端秘钥
     */
    private String clientSecret;
    /**
     * 授权范围
     */
    private String scope;
    /**
     * 资源ID列表，目前只使用default
     */
    private String resourceIds;
    /**
     * 支持的授权类型列表
     */
    private String grantTypes;
    /**
     * 授权重定向URL
     */
    private String redirectUris;
    /**
     * 自动授权范围列表
     */
    private String autoApproveScopes;
    /**
     * 客户端AccessToken超时时间
     */
    private Integer accessTokenValidity;
    /**
     * 客户端RefreshToken超时时间
     */
    private Integer refreshTokenValidity;
    /**
     * 客户端附加信息
     */
    private String additionalInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public String getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(String autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", grantTypes='" + grantTypes + '\'' +
                ", redirectUris='" + redirectUris + '\'' +
                ", autoApproveScopes='" + autoApproveScopes + '\'' +
                ", accessTokenValidity=" + accessTokenValidity +
                ", refreshTokenValidity=" + refreshTokenValidity +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
