package jp.spring_boot_template.application.dto;

import lombok.Builder;

@Builder
public record UpdateInput(long recordId, byte column1, String column2) {}
