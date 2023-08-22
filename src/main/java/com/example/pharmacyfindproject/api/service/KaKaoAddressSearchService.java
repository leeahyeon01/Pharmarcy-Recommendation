package com.example.pharmacyfindproject.api.service;
import com.example.pharmacyfindproject.api.dto.KaKaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j //log 사용을 위한 어노테이션
@Service
@RequiredArgsConstructor //lombok에서 제공하는 생성자주입
public class KaKaoAddressSearchService {
    // parameter 값을 보내 카카오api 호출하여 응답값을 받아 dto에 담아 return 해주는 메서드
    private final RestTemplate restTemplate;
    private final KaKaoUriBuilderService KaKaoUriBuilderService;

    //value어노테이션을 사용해서 application.yml 환경변수값을 가져옴
    @Value("${kakao.rest.api.key}")
    private String kakaoRestApiKey;

    public KaKaoApiResponseDto requestAddressSearch(String address){
    //kakao api호출 -http 클라이언트 모듈필요함 =>spring에서 제공하는 rest템플릿 사용할것임// => 이미 설정해놓은 의존성에 추가해둠 => 이 의존성을 bean으로설정 해놓고 사용하겟음

     if(ObjectUtils.isEmpty(address))return null;

     URI uri = KaKaoUriBuilderService.buildUriByAddressSearch(address);

     //헤더값에 rest.api값을 담아서 호출해야함
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "KaKaoAK" +kakaoRestApiKey);

        HttpEntity httpEntity = new HttpEntity<>(headers);

     //kakao api 호출
     return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, KaKaoApiResponseDto.class).getBody();


    }
}
