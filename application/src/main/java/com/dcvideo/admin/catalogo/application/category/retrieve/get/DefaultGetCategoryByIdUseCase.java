package com.dcvideo.admin.catalogo.application.category.retrieve.get;
import com.dcvideo.admin.catalogo.domain.category.Category;
import com.dcvideo.admin.catalogo.domain.category.CategoryGateway;
import com.dcvideo.admin.catalogo.domain.category.CategoryID;
import com.dcvideo.admin.catalogo.domain.exceptions.NotFoundException;
import com.dcvideo.admin.catalogo.domain.exceptions.NotificationException;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultGetCategoryByIdUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CategoryOutput execute(final String anIn) {
        final var anCategoryID = CategoryID.from(anIn);

        return this.categoryGateway.findById(anCategoryID)
                .map(CategoryOutput::from)
                .orElseThrow(notFound(anCategoryID));
    }

    private Supplier<NotFoundException> notFound(final CategoryID anId) {
        return () -> NotFoundException.with(Category.class, anId);
    }
}
