package life.majiang.community.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDTO {
    private Boolean showFirstPage;
    private Boolean showLastPage;
    private Boolean showPreviousPage;
    private Boolean showLatterPage;
    private Object[] Pages;
    private Integer totalPage;
    private Integer PageNum;
}
