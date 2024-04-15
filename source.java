package com.myhome.utils;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * is a data structure that represents information about a page of results from a
 * query. It contains the current page being displayed, the maximum number of pages
 * allowed, and the total number of pages and elements in the result set. The class
 * also provides a method for creating a new instance of the class based on a pageable
 * object and a page of results.
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
   * generates a `PageInfo` object containing information about a given pageable and
   * page, such as the page number, size, total pages, and total elements.
   * 
   * @param pageable pageable object that contains information about the current page
   * being processed, including the page number and the total number of pages in the
   * result set.
   * 
   * 	- The `getPageNumber()` method returns the page number of the current page being
   * processed.
   * 	- The `getPageSize()` method returns the size of a single page of data in the
   * collection being processed.
   * 	- The `getTotalPages()` method returns the total number of pages in the collection
   * being processed.
   * 	- The `getTotalElements()` method returns the total number of elements in the
   * collection being processed.
   * 
   * @param page current page being processed, providing information on its position
   * within the total number of pages and the number of elements it contains.
   * 
   * 	- `pageNumber`: The page number of the result, which can be retrieved from the
   * `Pageable` object passed as an argument.
   * 	- `pageSize`: The size of each page in the result, also obtained from the `Pageable`
   * object.
   * 	- `totalPages`: The total number of pages in the result, calculated by multiplying
   * the `pageSize` by the `pageable.getPageCount()` (or `pageable.getTotalPages()`).
   * 	- `totalElements`: The total number of elements in the result, which can be derived
   * from the `pageable.getTotalElements()` (or `page.getTotalElements()`) and the `pageSize`.
   * 
   * @returns a `PageInfo` object containing information about the page number, size,
   * total pages, and total elements of a given pageable and page.
   * 
   * 	- The first element is pageNumber, which represents the number of the current
   * page being displayed.
   * 	- pageSize represents the total number of elements that can be displayed on one
   * page.
   * 	- TotalPages represents the total number of pages in the dataset.
   * 	- TotalElements represents the total number of elements in the dataset.
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
