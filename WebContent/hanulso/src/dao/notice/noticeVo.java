package dao.notice;

public class noticeVo {

      private int idx;
      private String title;
      private String content;
      private String writer;
      private String wdate;
      private int viewcount;
      
      
      public int getIdx() {
         return idx;
      }
      public void setIdx(int idx) {
         this.idx = idx;
      }
      public String getTitle() {
         return title;
      }
      public void setTitle(String title) {
         this.title = title;
      }
      public String getContent() {
         return content;
      }
      public void setContent(String content) {
         this.content = content;
      }
      public String getWriter() {
         return writer;
      }
      public void setWriter(String writer) {
         this.writer = writer;
      }
      public String getWdate() {
         return wdate;
      }
      public void setWdate(String wdate) {
         this.wdate = wdate;
      }
      public int getViewcount() {
         return viewcount;
      }
      public void setViewcount(int viewcount) {
         this.viewcount = viewcount;
      }
      
      
}