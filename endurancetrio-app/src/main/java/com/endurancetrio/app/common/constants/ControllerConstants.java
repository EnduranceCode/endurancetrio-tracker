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

package com.endurancetrio.app.common.constants;

import org.springframework.http.HttpStatus;

/**
 * The {@link ControllerConstants} class contains constant values used across controller classes
 * in the application.
 */
public class ControllerConstants {

  public static final String API_VERSION_1 = "/v1";
  public static final String API_RESOURCE_TRACKER = "/tracker";

  public static final String MSG_CODE_OK = String.valueOf(HttpStatus.OK.value());
  public static final String MSG_CODE_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.toString();
  public static final String MSG_STATUS_ERROR = "ERROR";
  public static final String MSG_STATUS_OK = HttpStatus.OK.getReasonPhrase();
  public static final String MSG_SUCCESS = "Request handled successfully";

  private ControllerConstants() {
    throw new IllegalStateException("Utility Class");
  }
}
