package com.webhooks.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class sonyCiAssetsProcessingFinished {

    private String id;
    private String type;
    private webhookCreatedBy createdBy;
    private List<sonyCiAssets> assets;


}
