package cn.booktable.core.page;
import java.io.Serializable;
import java.util.List;
/**
 * 分页对象
 * @author ljc
 * @param <T>
 * 数据类型
 */
public class PageDo<T> implements Serializable{

    private static final long serialVersionUID = 103177325764334271L;

    public long pageIndex;// 当前页数(>0) 状态
    private long totalNum; // 总记录数(>=0) 读写
    private long totalPageNum; // 总页数(>0) 只读
    private int pageSize; // 每页的记录数(>0) 初始化
    private List<T> page; // 当前页中存放的记录 读写

    /**
     * 分页
     * @param pageIndex 起始页
     * @param pageSize 每页记录数
     */
    public PageDo(Long pageIndex,int pageSize) {
        this.pageIndex =pageIndex;
        this.pageSize = pageSize;
    }

    /**
     * 分页，默认起始页为1。
     * @param pageSize 每页记录数
     */
    public PageDo(int pageSize) {
        this(1L,pageSize);
    }

    /**
     * 分页，默认起始页为1，每页记录数为10。
     */
    public PageDo() {
        this(10);
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     *
     * @return 该页第一条数据
     */
    public long getStartOfPage() {
        return (this.pageIndex - 1) * pageSize;
    }

    /**
     * 每页记录数。
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 每页记录数。
     * @return
     */
    public List<T> getPage() {
        return page;
    }

    /**
     * 当前起始页
     * @return
     */
    public long getPageIndex() {
        this.pageIndex=this.pageIndex<=0?1:this.pageIndex;
        return pageIndex;
    }

    /**
     * 当前起始页
     * @param pageIndex
     */
    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
        this.pageIndex=this.pageIndex<=0?1:this.pageIndex;
    }

    public long getTotalNum() {
        return totalNum;
    }

    /**
     * return true : 可以继续查询
     * return false: 没有记录
     * @param totalNum
     * @return
     */
    public boolean setTotalNum(long totalNum) {
        this.totalNum = totalNum;

        if (this.totalNum == 0) {
            this.totalPageNum = 0;
            return false;
        } else {
            this.totalPageNum = this.totalNum / this.pageSize;
            if (this.totalNum % this.pageSize > 0) {
                this.totalPageNum++;
            }
        }
        this.pageIndex = this.pageIndex > this.totalPageNum ? this.totalPageNum
                : this.pageIndex;
        return true;
    }

    /**
     * 总页数。
     * @param totalPageNum
     */
    public void setTotalPage(long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    /**
     * 总页数。
     * @return
     */
    public long getTotalPage() {
        return totalPageNum;
    }

    /**
     * 每页记录数。
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 每页数据集。
     * @param page
     */
    public void setPage(List<T> page) {
        this.page = page;
    }

}
