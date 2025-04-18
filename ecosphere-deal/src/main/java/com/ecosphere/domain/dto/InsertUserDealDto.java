package com.ecosphere.domain.dto;

import com.ecosphere.domain.UserDealGoodImg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发布交易商品的dto对象
 * @author qht
 * @date 2025/4/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertUserDealDto {
//    private Integer id;
    private String goodName;
    private String dealDescription;
    protected String exchangeCondition;
    private String goodTag;
    private Integer creatorId;
    private List<String> imageUrlList;
}