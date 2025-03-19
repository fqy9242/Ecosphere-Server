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
import com.ecosphere.content.domain.RecommendedBook;
import com.ecosphere.content.service.IRecommendedBookService;
import com.ecosphere.common.utils.poi.ExcelUtil;
import com.ecosphere.common.core.page.TableDataInfo;

/**
 * 推荐书籍Controller
 * 
 * @author qht
 * @date 2025-02-05
 */
@RestController
@RequestMapping("/content/recommendedBook")
@Anonymous
public class RecommendedBookController extends BaseController
{
    @Autowired
    private IRecommendedBookService recommendedBookService;

    /**
     * 查询推荐书籍列表
     */
//    @PreAuthorize("@ss.hasPermi('content:recommendedBook:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecommendedBook recommendedBook)
    {
        startPage();
        List<RecommendedBook> list = recommendedBookService.selectRecommendedBookList(recommendedBook);
        return getDataTable(list);
    }

    /**
     * 导出推荐书籍列表
     */
    @PreAuthorize("@ss.hasPermi('content:recommendedBook:export')")
    @Log(title = "推荐书籍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RecommendedBook recommendedBook)
    {
        List<RecommendedBook> list = recommendedBookService.selectRecommendedBookList(recommendedBook);
        ExcelUtil<RecommendedBook> util = new ExcelUtil<RecommendedBook>(RecommendedBook.class);
        util.exportExcel(response, list, "推荐书籍数据");
    }

    /**
     * 获取推荐书籍详细信息
     */
    @PreAuthorize("@ss.hasPermi('content:recommendedBook:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(recommendedBookService.selectRecommendedBookById(id));
    }

    /**
     * 新增推荐书籍
     */
    @PreAuthorize("@ss.hasPermi('content:recommendedBook:add')")
    @Log(title = "推荐书籍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecommendedBook recommendedBook)
    {
        return toAjax(recommendedBookService.insertRecommendedBook(recommendedBook));
    }

    /**
     * 修改推荐书籍
     */
    @PreAuthorize("@ss.hasPermi('content:recommendedBook:edit')")
    @Log(title = "推荐书籍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecommendedBook recommendedBook)
    {
        return toAjax(recommendedBookService.updateRecommendedBook(recommendedBook));
    }

    /**
     * 删除推荐书籍
     */
    @PreAuthorize("@ss.hasPermi('content:recommendedBook:remove')")
    @Log(title = "推荐书籍", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(recommendedBookService.deleteRecommendedBookByIds(ids));
    }
}
