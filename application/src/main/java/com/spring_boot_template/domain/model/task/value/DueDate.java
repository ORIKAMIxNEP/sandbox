package com.spring_boot_template.domain.model.task.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DueDate {
    @Getter private final String value;
}