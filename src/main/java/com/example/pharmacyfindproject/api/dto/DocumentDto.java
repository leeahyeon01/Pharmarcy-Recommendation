package com.example.pharmacyfindproject.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {

    @JsonProperty("address_name")
    private String addressName;
    @JsonProperty("y") //위도
    private double latitude;
    @JsonProperty("x")  //경도
    private double longitde;
}
