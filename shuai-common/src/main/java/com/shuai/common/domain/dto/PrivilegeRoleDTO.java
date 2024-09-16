package com.shuai.common.domain.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PrivilegeRoleDTO {
    private Long id;
    private String antPath;
    private Boolean internal;
    private Set<Long> roles;
}
