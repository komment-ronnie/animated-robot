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
   * generates high-quality documentation for code by returning a `PageInfo` object
   * containing information about the number of pages, size of each page, total number
   * of pages, and total elements in a given pageable.
   * 
   * @param pageable pagination information of the page being processed, providing the
   * number of pages and elements per page.
   * 
   * @param page current page being processed and provides the total number of elements
   * on that page.
   * 
   * @returns a `PageInfo` object containing information about the current page of a
   * paginated result.
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
