package com.bjpn.util;

public class PageUtil {
    private int pageNum = 1;//当前页码
    private int pageSize = 5;//步长
    private int startIndex;//起始下标
    private int pages;//总页数
    private int total;//总条数
    private int beginIndex;//页码导航开始位置
    private int endIndex;//页码导航结束位置

    public static PageUtil pageConfig(int pageSize, int pageNum, int total) {
        //算法写在这里
        PageUtil pageUtil = new PageUtil();
        //将各个属性赋值
        //起始下标
        pageUtil.setStartIndex((pageNum - 1) * pageSize);
        //总页数
        int pages = 0;
        if (total % pageSize == 0) {
            pages = total / pageSize;
        } else {
            pages = (total / pageSize) + 1;
        }
        pageUtil.setPageNum(pageNum);
        pageUtil.setTotal(total);
        pageUtil.setPages(pages);
        //计算页码导航开始和结束
        //以当前页为中轴   pageNum-2>1  pageNum+2<=pages
        if (pages < 5) {
            pageUtil.setBeginIndex(1);
            pageUtil.setEndIndex(pages);
        } else {
            //总页数大等于5
            if (pageNum - 2 < 1) {//1、2
                pageUtil.setBeginIndex(1);
                pageUtil.setEndIndex(5);
            } else {
                pageUtil.setBeginIndex(pageNum - 2);
                //判断endIndex
                if (pageNum + 2 <= pages) {
                    pageUtil.setEndIndex(pageNum + 2);
                } else {
                    pageUtil.setBeginIndex(pageNum - 4);
                    pageUtil.setEndIndex(pages);
                }
            }
        }
        return pageUtil;
    }

    //默认步长为5
    public static PageUtil pageConfig(int pageNum, int total) {
        PageUtil pageUtil = new PageUtil();
        pageUtil = PageUtil.pageConfig(pageUtil.pageSize, pageNum, total);
        return pageUtil;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", pages=" + pages +
                ", total=" + total +
                ", beginIndex=" + beginIndex +
                ", endIndex=" + endIndex +
                '}';
    }

    public PageUtil() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
