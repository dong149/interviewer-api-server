package com.interview.api.util;


import com.interview.api.exception.link.InvalidUrlFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkUtilTest {

    private String correctUrl;
    private String wrongUrl;


    /*
    url 검증 테스트
     */
    @Test
    @DisplayName("프로토콜 부분이 잘못들어왔을 때")
    public void validateUrlFormatTest1() {
        wrongUrl = "htt://www.naver.com";
        assertWrongUrl(wrongUrl);
    }

    @Test
    @DisplayName("알파벳 혹은 숫자외의 문자가 들어왔을 때")
    public void validateUrlFormatTest2() {
        wrongUrl = "http://wwww.안녕.com";
        assertWrongUrl(wrongUrl);
    }

    @Test
    @DisplayName("url 검증 통과시")
    public void validateUrlFormatTest3() {
        correctUrl = "http://www.naver.com";
        assertCorrectUrl();
    }


    @Test
    @DisplayName("길이가 긴 url 검증 통과시")
    public void validateUrlFormatTest4() {
        correctUrl = "https://stackoverflow.com/questions/60165526/handling-multiple-exception-using-junit5-test-cases";
        assertCorrectUrl();
    }


    // TODO : queryString 포함된 링크도 통과시켜줄 수 있어야 됩니다. 로직 수정 필요
//    @Test
//    @DisplayName("queryString 포함된 url 검증 통과시")
//    public void validateUrlFormatTest5() {
//        correctUrl = "https://www.google.com/search?q=Junit5+exception+several+cases&newwindow=1&sxsrf=ALeKk01zA07hwOO6fBU_bwMSVpWidVcE5w%3A1628691891398&ei=s90TYYzcF4aS0gTMmoCAAg&oq=Junit5+exception+several+cases&gs_lcp=Cgdnd3Mtd2l6EAM6CAgAELADEM0COgQIIxAnOgUIABCABDoFCAAQywE6BAgAEB46BggAEAUQHjoGCAAQCBAeOgUIIRCgAToHCCEQChCgAToECCEQFUoECEEYAVC7wwJY2NYCYKfXAmgCcAB4AIABsAKIAY0bkgEIMS4xMi42LjGYAQCgAQHIAQTAAQE&sclient=gws-wiz&ved=0ahUKEwjMgYqNlqnyAhUGiZQKHUwNACAQ4dUDCA4&uact=5";
//        assertCorrectUrl();
//    }


    private void assertCorrectUrl() {
        assertDoesNotThrow(() -> LinkUtil.validateUrlFormat(correctUrl));
    }


    private void assertWrongUrl(String wrongUrl) {
        assertThrows(InvalidUrlFormatException.class, () -> LinkUtil.validateUrlFormat(wrongUrl));
    }

}
