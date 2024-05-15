package jp.spring_boot_template.presentation.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "レコード")
@Builder
public record FetchResponse(
    @Schema(description = "カラム1") short column1, @Schema(description = "カラム2") String column2) {}