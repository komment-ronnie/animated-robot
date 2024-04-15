package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
  
  /**
   * generates high-quality documentation for code given to it by returning a `PageInfo`
   * object containing information about the number of pages, page size, total pages,
   * and total elements of a pageable input.
   * 
   * @param pageable pagination information for the page being processed, providing the
   * page number, page size, total pages, and total elements.
   * 
   * @param page current page being processed, providing its total elements and pages
   * count to the `PageInfo` object returned by the function.
   * 
   * @returns a `PageInfo` object containing page-related information.
   */
  public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
