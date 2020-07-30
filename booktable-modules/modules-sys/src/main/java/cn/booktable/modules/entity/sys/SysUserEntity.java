package cn.booktable.modules.entity.sys;
import cn.booktable.core.shiro.SysUserPrimaryPrincipal;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * 系统用户
 * @author sys
 * @version v1.0
 */
@Data
public class SysUserEntity implements SysUserPrimaryPrincipal,Serializable {

    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 账号是否锁定:1未锁定，2锁定 */
    private Integer locked;
    /** 头像 */
    private String img;
    /** 背景图片 */
    private String bgImg;
    /** 真实姓名 */
    private String realName;
    /** 手机号 */
    private String telphone;
    /** 邮箱 */
    private String email;
    /** IP地址 */
    private String ip;
    /** 创建时间 */
    private Date createTime;
    /** 密码错误次数 */
    private Integer incorrectTime;
    /** 最后一次修改密码时间 */
    private Date modifyPwdTime;
    /** 最后一次登录时间 */
    private Date lastTime;
    /** 更新时间 */
    private Date updateTime;
    /** 状态：1有效，0无效 */
    private Integer status;
    /** 平台ID */
    private Integer platformId;
    /** 性别 */
    private Integer sex;
    /** 老师类型：1班主任，2、教师 */
    private Integer teacherType;
    /** 兼职：1是、2否 */
    private Integer partTimeJob;
    /** 英文名字 */
    private String englishName;
    /** 生日 */
    private Date birthday;
    /** 地址 */
    private String address;
    /** 座右铭 */
    private String motto;
    /** 关注数 */
    private Integer concernCnt;
    /** 被关注数 */
    private Integer beConcernCnt;
    /** 收藏资讯数 */
    private Integer collectCnt;
    /** 备注 */
    private String remark;

}