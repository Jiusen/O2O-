package com.o2o.entity;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 14:21
 * @Description 店铺类别
 */
public class ShopCategory
{
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc; //描述
    private String shopCategoryImg; //链接地址
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent; //上级（ID）
    public Long getShopCategoryId()
    {
        return shopCategoryId;
    }
    public void setShopCategoryId(Long shopCategoryId)
    {
        this.shopCategoryId = shopCategoryId;
    }
    public String getShopCategoryName()
    {
        return shopCategoryName;
    }
    public void setShopCategoryName(String shopCategoryName)
    {
        this.shopCategoryName = shopCategoryName;
    }
    public String getShopCategoryDesc()
    {
        return shopCategoryDesc;
    }
    public void setShopCategoryDesc(String shopCategoryDesc)
    {
        this.shopCategoryDesc = shopCategoryDesc;
    }
    public String getShopCategoryImg()
    {
        return shopCategoryImg;
    }
    public void setShopCategoryImg(String shopCategoryImg)
    {
        this.shopCategoryImg = shopCategoryImg;
    }
    public Integer getPriority()
    {
        return priority;
    }
    public void setPriority(Integer priority)
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
    public Date getLastEditTime()
    {
        return lastEditTime;
    }
    public void setLastEditTime(Date lastEditTime)
    {
        this.lastEditTime = lastEditTime;
    }
    public ShopCategory getParent()
    {
        return parent;
    }
    public void setParent(ShopCategory parent)
    {
        this.parent = parent;
    }
}
