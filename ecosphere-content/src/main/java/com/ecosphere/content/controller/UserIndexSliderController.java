package com.ecosphere.content.controller;

import java.util.List;

import com.ecosphere.common.annotation.Anonymous;
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
import com.ecosphere.content.domain.UserIndexSlider;
import com.ecosphere.content.service.IUserIndexSliderService;
import com.ecosphere.common.utils.poi.ExcelUtil;
import com.ecosphere.common.core.page.TableDataInfo;

/**
 * 首页轮播图Controller
 * 
 * @author qht
 * @date 2025-02-05
 */
@RestController
@Anonymous
@RequestMapping("/content/indexSlider")
public class UserIndexSliderController extends BaseController
{
    @Autowired
    private IUserIndexSliderService userIndexSliderService;

    /**
     * 查询首页轮播图列表
     */
//    @PreAuthorize("@ss.hasPermi('content:indexSlider:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserIndexSlider userIndexSlider)
    {
        startPage();
        List<UserIndexSlider> list = userIndexSliderService.selectUserIndexSliderList(userIndexSlider);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('content:indexSlider:export')")
    @Log(title = "首页轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserIndexSlider userIndexSlider)
    {
        List<UserIndexSlider> list = userIndexSliderService.selectUserIndexSliderList(userIndexSlider);
        ExcelUtil<UserIndexSlider> util = new ExcelUtil<UserIndexSlider>(UserIndexSlider.class);
        util.exportExcel(response, list, "首页轮播图数据");
    }

    /**
     * 获取首页轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('content:indexSlider:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userIndexSliderService.selectUserIndexSliderById(id));
    }

    /**
     * 新增首页轮播图
     */
    @PreAuthorize("@ss.hasPermi('content:indexSlider:add')")
    @Log(title = "首页轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserIndexSlider userIndexSlider)
    {
        return toAjax(userIndexSliderService.insertUserIndexSlider(userIndexSlider));
    }

    /**
     * 修改首页轮播图
     */
    @PreAuthorize("@ss.hasPermi('content:indexSlider:edit')")
    @Log(title = "首页轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserIndexSlider userIndexSlider)
    {
        return toAjax(userIndexSliderService.updateUserIndexSlider(userIndexSlider));
    }

    /**
     * 删除首页轮播图
     */
    @PreAuthorize("@ss.hasPermi('content:indexSlider:remove')")
    @Log(title = "首页轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userIndexSliderService.deleteUserIndexSliderByIds(ids));
    }
}
