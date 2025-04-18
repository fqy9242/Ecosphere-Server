package com.ecosphere.controller;

import java.util.List;

import com.ecosphere.domain.UpdateUserDealDto;
import com.ecosphere.domain.dto.InsertUserDealDto;
import com.ecosphere.domain.vo.UserDealVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecosphere.common.annotation.Log;
import com.ecosphere.common.core.controller.BaseController;
import com.ecosphere.common.core.domain.AjaxResult;
import com.ecosphere.common.enums.BusinessType;
import com.ecosphere.domain.UserDeal;
import com.ecosphere.service.IUserDealService;
import com.ecosphere.common.utils.poi.ExcelUtil;
import com.ecosphere.common.core.page.TableDataInfo;

/**
 * 用户交易Controller
 * 
 * @author qht
 * @date 2025-03-19
 */
@RestController
@RequestMapping("/deal/userDeal")
@Tag(name = "用户交易相关模块")
public class UserDealController extends BaseController {
    @Autowired
    private IUserDealService userDealService;
    /**
     * 查询用户交易列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询用户交易列表")
    public TableDataInfo list(UserDeal userDeal)
    {
        startPage();
        List<UserDealVo> list = userDealService.selectUserDealList(userDeal);
        return getDataTable(list);
    }

    /**
     * 导出用户交易列表
     */
    @PreAuthorize("@ss.hasPermi('deal:userDeal:export')")
    @Log(title = "用户交易", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @Operation(summary = "导出用户交易列表")
    public void export(HttpServletResponse response, UserDeal userDeal)
    {
        List<UserDealVo> list = userDealService.selectUserDealList(userDeal);
        ExcelUtil<UserDealVo> util = new ExcelUtil<UserDealVo>(UserDealVo.class);
        util.exportExcel(response, list, "用户交易数据");
    }

    /**
     * 获取用户交易详细信息
     */
    @PreAuthorize("@ss.hasPermi('deal:userDeal:query')")
    @GetMapping(value = "/{id}")
    @Operation(summary = "获取用户交易详细信息")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(userDealService.selectUserDealById(id));
    }

    /**
     * 新增用户交易
     */
    @Log(title = "用户交易", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增用户交易")
    public AjaxResult add(@RequestBody InsertUserDealDto dto) {
        userDealService.insertUserDeal(dto);
        return AjaxResult.success();
    }

    /**
     * 修改用户交易
     */
    @PreAuthorize("@ss.hasPermi('deal:userDeal:edit')")
    @Log(title = "用户交易", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改用户交易")
    public AjaxResult edit(@RequestBody UpdateUserDealDto dto)
    {
        return toAjax(userDealService.updateUserDeal(dto));
    }

    /**
     * 删除用户交易
     */
    @PreAuthorize("@ss.hasPermi('deal:userDeal:remove')")
    @Log(title = "用户交易", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Operation(summary = "删除用户交易")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(userDealService.deleteUserDealByIds(ids));
    }
}
