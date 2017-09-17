package com.ylx.librarymanage.response;

import com.ylx.librarymanage.common.Const;

public class ResponseCreator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    public static ResponseTemplate createSuccessResponseByMessage(String message){
        return new ResponseTemplate(Const.SUCCESS_CODE, message);
    }

    public static ResponseTemplate createSuccessResponseByData(Object data){
        return new ResponseTemplate(data);
    }

    public static ResponseTemplate createErrorResponse(ErrorCode error){
        return new ResponseTemplate(error.getCode(), error.getMessage());
    }

    public static ResponseTemplate createDefaultSuccessResponse(){
        return new ResponseTemplate(Const.SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE);
    }

}
