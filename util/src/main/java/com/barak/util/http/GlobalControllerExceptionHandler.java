package com.barak.util.http;

import com.barak.util.exceptions.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    public HttpErrorInfo handleException(ServerHttpRequest request, Throwable throwable) {
        return createHttpErrorInfo(request, throwable);
    }

    private HttpErrorInfo createHttpErrorInfo(ServerHttpRequest request, Throwable throwable) {

        if (throwable instanceof ApplicationException) {
            ApplicationException applicationException = (ApplicationException) throwable;

            final String errorName = applicationException.getErrorType().getErrorName();
            final int errorNumber = applicationException.getErrorType().getErrorNumber();
            final String path = request.getPath().pathWithinApplication().value();
            final String message = applicationException.getMessage();

            LOG.debug("Returning HTTP status: {}, with status number {}, for path: {}, message: {}", errorName, errorNumber, path, message);
            return new HttpErrorInfo(errorName, errorNumber, path, message);
        } else {
            String errorMessage = throwable.getMessage();
            LOG.warn("Unexpected error with cause: {}, message: {}", throwable.getCause(), throwable.getMessage());
            return new HttpErrorInfo("GENERAL_ERROR", 800
                    , "Something happened, info about the error has been logged", errorMessage);
        }

    }
}
