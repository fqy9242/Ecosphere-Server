package com.ecosphere.domain;

import lombok.Data;

import java.util.List;

/**
 * @author qht
 * @date 2025/4/18
 */
@Data
public class UpdateUserDealDto extends UserDeal{
    private List<String> imageList;
}