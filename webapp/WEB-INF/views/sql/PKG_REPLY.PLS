create or replace PACKAGE PKG_REPLY AS 

    -- 동호 -----------------------------------------------------------
    
    PROCEDURE PROC_REPLY_LIST( IN_POST_NUM IN NUMBER, O_CUR     OUT SYS_REFCURSOR );

END PKG_REPLY;