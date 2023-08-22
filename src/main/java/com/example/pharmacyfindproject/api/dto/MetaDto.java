package com.example.pharmacyfindproject.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class MetaDto {


    @JsonProperty("total_count")
    //json으로 받은 응답값을 자바 필드와 매칭시켜주는 어노테이션
    private Integer totalCount;

}
