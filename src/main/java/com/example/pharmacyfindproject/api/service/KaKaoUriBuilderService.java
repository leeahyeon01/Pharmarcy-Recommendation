package com.example.pharmacyfindproject.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class KaKaoUriBuilderService {

    private static final String KAKAO_LOCAL_SEARCH_ADDRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    //URL 만드는 메소드
    public URI buildUriByAddressSearch(String address){
        //리턴값 URI                    //파라미터
        // URI는 인터넷상의 리소스 “자원 자체”를 식별하는 고유한 문자열 시퀀스입니다.
        // URL 네트워크상에서 통합 자원(리소스)의 “위치”를 나타내기 위한 규약

    // Spring에서 제공하는 컴포넌트
        //UriComponentsBuilder.@@@() - uri 만드는 컴포넌트
        //queryParam() - query 파라미터생성
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KAKAO_LOCAL_SEARCH_ADDRESS_URL);

        //전달하고자하는 주소값을 query형태로 Parm에 담아줌
        uriBuilder.queryParam("query",address);


        URI uri = uriBuilder.build().encode().toUri();
        log.info("[KaKaoUriBuilderService buildUriByAddressSearch] address:{} , uri:{} ", address , uri);

        return uri;
    }

}
