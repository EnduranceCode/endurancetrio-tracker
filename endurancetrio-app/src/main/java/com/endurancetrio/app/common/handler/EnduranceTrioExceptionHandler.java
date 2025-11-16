/*
 * Copyright (c) 2025-2025 Ricardo do Canto
 *
 * This file is part of the EnduranceTrio Tracker project.
 *
 * Licensed under the Functional Software License (FSL), Version 1.1, ALv2 Future License
 * (the "License");
 *
 * You may not use this file except in compliance with the License. You may obtain a copy
 * of the License at https://fsl.software/
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND WITHOUT WARRANTIES OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING WITHOUT LIMITATION WARRANTIES OF FITNESS FOR A PARTICULAR
 * PURPOSE, MERCHANTABILITY, TITLE OR NON-INFRINGEMENT.
 *
 * IN NO EVENT WILL WE HAVE ANY LIABILITY TO YOU ARISING OUT OF OR RELATED TO THE
 * SOFTWARE, INCLUDING INDIRECT, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES,
 * EVEN IF WE HAVE BEEN INFORMED OF THEIR POSSIBILITY IN ADVANCE.
 */

package com.endurancetrio.app.common.handler;

import com.endurancetrio.app.common.constants.ControllerConstants;
import com.endurancetrio.app.common.response.EnduranceTrioResponse;
import com.endurancetrio.business.common.exception.base.EnduranceTrioException;
import com.endurancetrio.business.common.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The {@link EnduranceTrioExceptionHandler} class is a global exception handler for the
 * EnduranceTrio Tracker application. It captures unhandled exceptions and custom
 * EnduranceTrioExceptions, returning standardized error responses.
 *
 * @param <T> the type of the data payload contained in the response
 */
@ControllerAdvice
public class EnduranceTrioExceptionHandler<T> {

  private static final String MSG_STATUS_ERROR = ControllerConstants.MSG_STATUS_ERROR;
  private static final String MSG_CODE_ERROR = ControllerConstants.MSG_CODE_SERVER_ERROR;

  @ExceptionHandler({Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public EnduranceTrioResponse<T> unhandledException(
      HttpServletRequest request, Exception exception) {

    return new EnduranceTrioResponse<>(MSG_STATUS_ERROR, MSG_CODE_ERROR, exception.getMessage());
  }

  @ExceptionHandler({EnduranceTrioException.class})
  @ResponseBody
  public EnduranceTrioResponse<List<ErrorDTO>> handledException(
      final HttpServletRequest request, final HttpServletResponse response,
      final EnduranceTrioException exception
  ) {

    response.setStatus(exception.getCode());

    return new EnduranceTrioResponse<>(MSG_STATUS_ERROR, String.valueOf(exception.getCode()),
        exception.getMessage(), exception.getErrors()
    );
  }
}
