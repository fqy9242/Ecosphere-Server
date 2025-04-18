package com.ecosphere.domain.vo;

import com.ecosphere.domain.UserDealGoodImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qht
 * @date 2025/4/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDealVo {
    private Integer id;
    private String goodName;
    private String dealDescription;
    private String exchangeCondition;
    private String goodTag;
    private Integer creatorId;
    private Long dealStatus;
    private String createTime;
    private String updateTime;
    List<UserDealGoodImg> userDealGoodImgList;
}