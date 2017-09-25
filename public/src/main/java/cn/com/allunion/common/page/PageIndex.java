package cn.com.allunion.common.page;

public class PageIndex {
    private long startIndex;
    private long endIndex;

    public PageIndex(long startIndex, long endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static PageIndex getPageIndex(long viewPageCount, int currentPage, long totalPage) {
        long startpage = currentPage - (viewPageCount % 2 == 0 ? viewPageCount / 2 - 1 : viewPageCount / 2);
        long endpage = currentPage + viewPageCount / 2;
        if (startpage < 1) {
            startpage = 1;
            if (totalPage >= viewPageCount) endpage = viewPageCount;
            else endpage = totalPage;
        }
        if (endpage > totalPage) {
            endpage = totalPage;
            if ((endpage - viewPageCount) > 0) startpage = endpage - viewPageCount + 1;
            else startpage = 1;
        }
        return new PageIndex(startpage, endpage);
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startindex) {
        this.startIndex = startindex;
    }

    public long getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(long endindex) {
        this.endIndex = endindex;
    }
}