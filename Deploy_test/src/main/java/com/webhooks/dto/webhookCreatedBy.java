package com.webhooks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class webhookCreatedBy {

    private String id;
    private String name;
    private String email;

}
