package com.spring_boot_template.application.dto.record;

import lombok.Builder;

@Builder
public record DeleteRecordInput(long recordId) {}
