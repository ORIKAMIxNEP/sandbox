package com.spring_boot_template.domain.shared;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
final class IdGeneratorTest {
    private final IdGenerator idGenerator;

    @Test
    public void generateIdTest() {
        final String id = idGenerator.generateId();

        assertThat(id.length()).isEqualTo(26);
    }
}
