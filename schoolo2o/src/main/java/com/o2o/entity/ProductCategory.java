package com.o2o.entity;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 14:22
 * @Description 商品类别
 */
public class ProductCategory
{
    private Long productCategoryId;
    private Long shopId;  //店铺ID
    private String productCategoryName;  //商品类别名称
    private String priority; //商品类别
    private Date createTime; //商品类别的创建时间
    public Long getProductCategoryId()
    {
        return productCategoryId;
    }
    public void setProductCategoryId(Long productCategoryId)
    {
        this.productCategoryId = productCategoryId;
    }
    public Long getShopId()
    {
        return shopId;
    }
    public void setShopId(Long shopId)
    {
        this.shopId = shopId;
    }
    public String getProductCategoryName()
    {
        return productCategoryName;
    }
    public void setProductCategoryName(String productCategoryName)
    {
        this.productCategoryName = productCategoryName;
    }
    public String getPriority()
    {
        return priority;
    }
    public void setPriority(String priority)
    {
        this.priority = priority;
    }
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
