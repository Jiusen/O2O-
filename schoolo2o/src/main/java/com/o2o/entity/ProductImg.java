package com.o2o.entity;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 14:23
 * @Description 商品图片
 */
public class ProductImg
{
    private Long productImgId; //图片的ID
    private String imgAddr;  //图片地址
    private String imgDesc;  //图片描述
    private Integer priority; //图片的显示权重
    private Date createTime;  //图片的创建时间
    private Long productId; //图片的产品id

    public Long getProductImgId()
    {
        return productImgId;
    }
    public void setProductImgId(Long productImgId)
    {
        this.productImgId = productImgId;
    }
    public String getImgAddr()
    {
        return imgAddr;
    }
    public void setImgAddr(String imgAddr)
    {
        this.imgAddr = imgAddr;
    }
    public String getImgDesc()
    {
        return imgDesc;
    }
    public void setImgDesc(String imgDesc)
    {
        this.imgDesc = imgDesc;
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
    public Long getProductId()
    {
        return productId;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }
}
