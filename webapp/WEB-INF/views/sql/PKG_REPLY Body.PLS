create or replace PACKAGE BODY PKG_REPLY AS

    -- 동호 -----------------------------------------------------------

  PROCEDURE PROC_REPLY_LIST(
  IN_POST_NUM IN NUMBER,
  O_CUR     OUT SYS_REFCURSOR
 ) AS
  BEGIN
    OPEN O_CUR FOR
        SELECT *
        FROM MREPLY R, MPOST P
        WHERE P.POST_NUM=IN_POST_NUM
        AND   P.POST_NUM = R.POST_NUM;
  END PROC_REPLY_LIST;

END PKG_REPLY;