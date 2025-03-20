package com.ecosphere.user.controller;

import java.util.List;
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
import com.ecosphere.user.domain.EcosphereUser;
import com.ecosphere.user.service.IEcosphereUserService;
import com.ecosphere.common.utils.poi.ExcelUtil;
import com.ecosphere.common.core.page.TableDataInfo;

/**
 * 注册用户Controller
 * 
 * @author qht
 * @date 2025-03-19
 */
@RestController
@RequestMapping("/user/users")
public class EcosphereUserController extends BaseController
{
    @Autowired
    private IEcosphereUserService ecosphereUserService;

    /**
     * 查询注册用户列表
     */
    @PreAuthorize("@ss.hasPermi('user:users:list')")
    @GetMapping("/list")
    public TableDataInfo list(EcosphereUser ecosphereUser)
    {
        startPage();
        List<EcosphereUser> list = ecosphereUserService.selectEcosphereUserList(ecosphereUser);
        return getDataTable(list);
    }

    /**
     * 导出注册用户列表
     */
    @PreAuthorize("@ss.hasPermi('user:users:export')")
    @Log(title = "注册用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EcosphereUser ecosphereUser)
    {
        List<EcosphereUser> list = ecosphereUserService.selectEcosphereUserList(ecosphereUser);
        ExcelUtil<EcosphereUser> util = new ExcelUtil<EcosphereUser>(EcosphereUser.class);
        util.exportExcel(response, list, "注册用户数据");
    }

    /**
     * 获取注册用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('user:users:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(ecosphereUserService.selectEcosphereUserById(id));
    }

    /**
     * 新增注册用户
     */
    @PreAuthorize("@ss.hasPermi('user:users:add')")
    @Log(title = "注册用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EcosphereUser ecosphereUser)
    {
        return toAjax(ecosphereUserService.insertEcosphereUser(ecosphereUser));
    }

    /**
     * 修改注册用户
     */
    @PreAuthorize("@ss.hasPermi('user:users:edit')")
    @Log(title = "注册用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EcosphereUser ecosphereUser)
    {
        return toAjax(ecosphereUserService.updateEcosphereUser(ecosphereUser));
    }

    /**
     * 删除注册用户
     */
    @PreAuthorize("@ss.hasPermi('user:users:remove')")
    @Log(title = "注册用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(ecosphereUserService.deleteEcosphereUserByIds(ids));
    }
}
