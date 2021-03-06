package cn.yznu.zubow.util.sortpage;

import java.io.Serializable;

/**
 * 分页工具(方法描述)
 *
 * @author 66495
 * @create 2018-08-26 16:09
 */

public class PageQuery implements Serializable {
    // showCount  每一页显示多少
    private int showCount;
    // 总页数
    private int totalPage;
    // 总记录数
    private int totalResult;
    // 当前页数
    private int currentPage = 1;

    private int limitFirst;

    public PageQuery(Integer page,Integer limit){
        this.currentPage=page;
        this.showCount=limit;
    }


    //计算limit第一个参数 等价于(当前页数-1)*显示页数
    public int getLimitFirst() {
        this.limitFirst = (currentPage - 1) * showCount;
        return this.limitFirst;
    }

    //计算总页数 总记录数/每页显示+1
    public int getTotalPage(){
        if(totalResult%showCount>0){
            this.totalPage=totalResult/showCount+1;
            return this.totalPage;
        }
        this.totalPage=totalResult/showCount;
        return this.totalPage;
    }
}
