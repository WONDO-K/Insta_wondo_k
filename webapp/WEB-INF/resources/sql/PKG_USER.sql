CREATE OR REPLACE 
PACKAGE PKG_USER AS 

 PROCEDURE PROC_USER_RECOMMEND(
  O_CUR     OUT SYS_REFCURSOR
 );
 
 PROCEDURE PROC_USER_LIST(
 O_CUR     OUT SYS_REFCURSOR
 );

END PKG_USER;