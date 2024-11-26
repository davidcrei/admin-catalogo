package com.dcvideo.admin.catalogo.domain.exceptions;

import com.dcvideo.admin.catalogo.domain.AggregateRoot;
import com.dcvideo.admin.catalogo.domain.Identifier;
import com.dcvideo.admin.catalogo.domain.validation.Error;
import com.dcvideo.admin.catalogo.domain.validation.handler.Notification;

import java.util.Collections;
import java.util.List;

public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }

    public static class NotFoundException extends DomainException {

        protected NotFoundException(final String aMessage, final List<com.dcvideo.admin.catalogo.domain.validation.Error> anErrors) {
            super(aMessage, anErrors);
        }

        public static NotFoundException with(
                final Class<? extends AggregateRoot<?>> anAggregate,
                final Identifier id
        ) {
            final var anError = "%s with ID %s was not found".formatted(
                    anAggregate.getSimpleName(),
                    id.getValue()
            );
            return new NotFoundException(anError, Collections.emptyList());
        }

        public static NotFoundException with(final Error error) {
            return new NotFoundException(error.message(), List.of(error));
        }
    }
}
