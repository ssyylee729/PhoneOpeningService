package com.example.mobilephoneopeningservice.domain.common;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedDt();
    LocalDateTime getUpdatedDt();

    void setCreatedDt(LocalDateTime createdDt);
    void setUpdatedDt(LocalDateTime updatedDt);
}
