package com.example.pharmacyfindproject.api.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KaKaoApiResponseDto {

    @JsonProperty("meta")
    private MetaDto metaDto;
    
    //값을 여러개 보내므로 list형식으로 받음
    private List<DocumentDto> documentDtoList;
}
