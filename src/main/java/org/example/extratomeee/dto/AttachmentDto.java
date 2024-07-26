package org.example.extratomeee.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AttachmentDto {
    private String name;
    private String size;
    private String contentType;

}
