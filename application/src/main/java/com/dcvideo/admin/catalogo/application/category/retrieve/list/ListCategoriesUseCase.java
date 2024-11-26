package com.dcvideo.admin.catalogo.application.category.retrieve.list;

import com.dcvideo.admin.catalogo.application.UseCase;
import com.dcvideo.admin.catalogo.domain.pagination.SearchQuery;
import com.dcvideo.admin.catalogo.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase
        extends UseCase<SearchQuery, Pagination<CategoryListOutput>> {
}
