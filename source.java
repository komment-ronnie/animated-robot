package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * Is an object that contains essential information about a page of data retrieved
 * from a database or other source. It has four fields: currentPage, pageLimit,
 * totalPages, and totalElements. These fields provide the number of the current page,
 * the maximum number of pages, the total number of pages, and the total number of
 * elements, respectively. The class also includes a factory method for creating new
 * instances of PageInfo based on a Pageable object and its associated Page.
 */
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
   * Converts a `Pageable` object and a `Page` object into a `PageInfo` object, providing
   * information about the page number, size, total pages, and total elements.
   * 
   * @param pageable pagination context, providing information about the current page
   * and the total number of pages in the result set.
   * 
   * @param page current page being processed, providing information on its position
   * within the overall range of pages and the number of elements it contains.
   * 
   * @returns a `PageInfo` object containing four properties: page number, page size,
   * total pages, and total elements.
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
