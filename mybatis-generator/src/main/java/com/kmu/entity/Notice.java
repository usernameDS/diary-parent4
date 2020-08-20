package com.kmu.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-20
 */
@TableName("t_notice")
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "n_id", type = IdType.AUTO)
    private Integer nId;
    @TableField("m_id")
    private Integer id;
    @TableField("n_content")
    private String nContent;
    @TableField("n_title")
    private String nTitle;
    @TableField("notice_time")
    private Date noticeTime;
    @TableField("notice_pic")
    private String noticePic;
    /**
     * 管理员姓名
     */
    @TableField("m_name")
    private String name;
    /**
     * 管理员头像
     */
    @TableField("m_head_pic")
    private String headPic;


    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticePic() {
        return noticePic;
    }

    public void setNoticePic(String noticePic) {
        this.noticePic = noticePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    @Override
    protected Serializable pkVal() {
        return this.nId;
    }

    @Override
    public String toString() {
        return "Notice{" +
        ", nId=" + nId +
        ", id=" + id +
        ", nContent=" + nContent +
        ", nTitle=" + nTitle +
        ", noticeTime=" + noticeTime +
        ", noticePic=" + noticePic +
        ", name=" + name +
        ", headPic=" + headPic +
        "}";
    }
}
