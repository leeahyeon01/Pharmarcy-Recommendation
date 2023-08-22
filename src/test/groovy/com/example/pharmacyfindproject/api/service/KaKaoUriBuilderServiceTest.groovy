package com.example.pharmacyfindproject.api.service

import spock.lang.Specification

import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class KaKaoUriBuilderServiceTest extends Specification {

    //테스트케이스 작성

    private KaKaoUriBuilderService kakaoUriBuilderService

    def setup(){
        //테스트할 메소드를 인스턴스화 해줌
        kakaoUriBuilderService = new KaKaoUriBuilderService()
    }

    //한글주소를 입력하면 제대로 인코딩 되는지 테스트메소드
    def "buildUriByAddressSearch - 한글 파라미터의 경우 정상적으로 인코딩"(){
        given:
        String address ="서울 성북구"
        def charset = StandardCharsets.UTF_8

        when:
        def uri = kakaoUriBuilderService.buildUriByAddressSearch(address)
        //spock는 동적파일 프로그래밍 언어(groovy)이므로 동적으로 선언해줌
        def decodedResult = URLDecoder.decode(uri.toString(), charset)


        then:
        decodedResult == "https://dapi.kakao.com/v2/local/search/address.json?query=서울 성북구"

    }
}
