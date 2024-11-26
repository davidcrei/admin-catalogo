package com.dcvideo.admin.catalogo.application.category.update;

import com.dcvideo.admin.catalogo.application.UseCase;
import com.dcvideo.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase
        extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
