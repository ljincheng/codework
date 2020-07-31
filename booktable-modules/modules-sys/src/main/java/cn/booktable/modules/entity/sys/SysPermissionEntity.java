package cn.booktable.modules.entity.sys;

import java.io.Serializable;
import java.util.Date;

public class SysPermissionEntity implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** 主键. */
    private Long id;

    /** 资源名称. */
    private String name;

    /** 资源类型. */
    private Integer dataType;

    /** 访问url地址. */
    private String url;

    /** 权限代码字符串. */
    private String perCode;

    /** 父结点id. */
    private Long parentId;

    /** 路径. */
    private String path;

    /** 排序. */
    private Integer indexs;

    /** 是否可用. */
    private Integer available;

    /** 创建时间. */
    private Date createTime;

    /** 图标. */
    private String icon;

    public SysPermissionEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPerCode() {
        return this.perCode;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public String getPath() {
        return this.path;
    }

    public Integer getIndexs() {
        return this.indexs;
    }

    public Integer getAvailable() {
        return this.available;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setIndexs(Integer indexs) {
        this.indexs = indexs;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SysPermissionEntity)) return false;
        final SysPermissionEntity other = (SysPermissionEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$dataType = this.getDataType();
        final Object other$dataType = other.getDataType();
        if (this$dataType == null ? other$dataType != null : !this$dataType.equals(other$dataType)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$perCode = this.getPerCode();
        final Object other$perCode = other.getPerCode();
        if (this$perCode == null ? other$perCode != null : !this$perCode.equals(other$perCode)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$path = this.getPath();
        final Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
        final Object this$indexs = this.getIndexs();
        final Object other$indexs = other.getIndexs();
        if (this$indexs == null ? other$indexs != null : !this$indexs.equals(other$indexs)) return false;
        final Object this$available = this.getAvailable();
        final Object other$available = other.getAvailable();
        if (this$available == null ? other$available != null : !this$available.equals(other$available)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$icon = this.getIcon();
        final Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SysPermissionEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $dataType = this.getDataType();
        result = result * PRIME + ($dataType == null ? 43 : $dataType.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $perCode = this.getPerCode();
        result = result * PRIME + ($perCode == null ? 43 : $perCode.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $path = this.getPath();
        result = result * PRIME + ($path == null ? 43 : $path.hashCode());
        final Object $indexs = this.getIndexs();
        result = result * PRIME + ($indexs == null ? 43 : $indexs.hashCode());
        final Object $available = this.getAvailable();
        result = result * PRIME + ($available == null ? 43 : $available.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $icon = this.getIcon();
        result = result * PRIME + ($icon == null ? 43 : $icon.hashCode());
        return result;
    }

    public String toString() {
        return "SysPermissionEntity(id=" + this.getId() + ", name=" + this.getName() + ", dataType=" + this.getDataType() + ", url=" + this.getUrl() + ", perCode=" + this.getPerCode() + ", parentId=" + this.getParentId() + ", path=" + this.getPath() + ", indexs=" + this.getIndexs() + ", available=" + this.getAvailable() + ", createTime=" + this.getCreateTime() + ", icon=" + this.getIcon() + ")";
    }
}
