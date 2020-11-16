package cn.booktable.modules.entity.kids;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("esKidsMediaMetadataBo")
@Data
public class EsKidsMediaMetadataBo {
    private Long id;
    private String title;
    private String category;
}
