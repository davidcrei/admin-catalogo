package com.dcvideo.admin.catalogo.application.category.create;

import com.dcvideo.admin.catalogo.application.UseCase;
import com.dcvideo.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}