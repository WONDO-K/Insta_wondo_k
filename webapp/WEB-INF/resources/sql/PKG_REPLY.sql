CREATE OR REPLACE 
PACKAGE PKG_REPLY AS 

  PROCEDURE PROC_REPLY_LIST(
  IN_POST_NUM IN NUMBER,
  O_CUR     OUT SYS_REFCURSOR
  
 );

END PKG_REPLY;