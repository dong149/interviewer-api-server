package com.interview.api.advice;


import com.interview.api.dto.common.ErrorResponseDto;
import com.interview.api.enumerator.ErrorType;
import com.interview.api.exception.category.CategoryNotFoundException;
import com.interview.api.exception.link.InvalidUrlFormatException;
import com.interview.api.exception.pack.PackNotFoundException;
import com.interview.api.exception.problem.ProblemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class ExceptionControllerAdvice {


    /**
     * @param e : RestController 에서 발생하는 Exception
     * @return : ResponseEntity<ErrorResponseDto>
     */

    // 404 NOT FOUND
    @ExceptionHandler(PackNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePackNotFoundException(PackNotFoundException e) {
        log.error(e.getMessage(), e);
        return error(ErrorType.PACK_NOT_FOUND_ERROR, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCategoryNotFoundException(CategoryNotFoundException e) {
        log.error(e.getMessage(), e);
        return error(ErrorType.NOT_FOUND_ERROR, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProblemNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProblemNotFoundException(ProblemNotFoundException e) {
        log.error(e.getMessage(), e);
        return error(ErrorType.NOT_FOUND_ERROR, HttpStatus.NOT_FOUND);
    }



    // 400 BAD REQUEST
    @ExceptionHandler(InvalidUrlFormatException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidUrlFormatException(InvalidUrlFormatException e) {
        log.error(e.getMessage(), e);
        return error(ErrorType.BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST);
    }

    // 500 INTERNAL SERVER ERROR


    // error Constructor
    private ResponseEntity<ErrorResponseDto> error(final ErrorType errorType, final HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorResponseDto(errorType.getErrorCode(), errorType.getErrorMessage(), new ArrayList<>()), httpStatus);
    }

    private ResponseEntity<ErrorResponseDto> error(final ErrorType errorType, final HttpStatus httpStatus, String customMessage) {
        return new ResponseEntity<>(new ErrorResponseDto(errorType.getErrorCode(), customMessage, new ArrayList<>()), httpStatus);
    }
}

