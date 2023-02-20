package com.toy.boardproject.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View Controller TEST - 게시글")
@WebMvcTest(ArticleControllerTest.class) // 테스트 대상이 되는 컨트롤러만 빈으로 읽어오도록 설정
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view] [GET] 게시글 리스트 (게시판) 페이지 - 정상 호출 ")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk()) // 정상 호출. STATUS가 200인가를 확인
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출 ")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk()) // 정상 호출. STATUS가 200인가를 확인
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("article"));
    }

    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출 ")
    @Test
    public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk()) // 정상 호출. STATUS가 200인가를 확인
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view] [GET] 게시글 해시태그 검색 페이지 - 정상 호출 ")
    @Test
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk()) // 정상 호출. STATUS가 200인가를 확인
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}
