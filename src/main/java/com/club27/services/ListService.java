package com.club27.services;

import com.club27.web.dto.PageListRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    private static final int DEFAULT_ITEMS_PER_PAGE = 10;
    private static final int DEFAULT_PAGE_DISPLAY = 0;

    public int validatePageListRequestItemsPerPage(PageListRequestDto pageListRequestDto){
        return pageListRequestDto.numberPerPage() == null ||
                pageListRequestDto.numberPerPage() <= 0 ? DEFAULT_ITEMS_PER_PAGE : Math.toIntExact(pageListRequestDto.numberPerPage());
    }

    public int validatePageListRequestPageDisplay(PageListRequestDto pageListRequestDto){
        return pageListRequestDto.pageNumber() == null ||
                pageListRequestDto.pageNumber() <= 0 ? DEFAULT_PAGE_DISPLAY : Math.toIntExact(pageListRequestDto.pageNumber());
    }

}
