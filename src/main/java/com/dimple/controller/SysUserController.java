package com.dimple.controller;

import com.dimple.entity.SysUser;
import com.dimple.service.SysUserService;
import com.dimple.utils.RestResponse;
import com.dimple.utils.web.AjaxResult;
import com.dimple.utils.web.BaseController;
import com.dimple.utils.web.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2019-05-01 00:15:15
 */
@Controller
@RequestMapping("system/user")
public class SysUserController extends BaseController {


    @Autowired
    private SysUserService sysUserService;

    @GetMapping()
    public String user() {
        return "system/user/user";
    }


    @GetMapping("/add")
    public String add() {
        return "system/user/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUser user) {
        user.setCreateBy(getSysUser().getId());
        return toAjax(sysUserService.insert(user));
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("user", sysUserService.selectSysyUserById(id));
        return "system/user/update";
    }

    @PutMapping("/update")
    @ResponseBody
    public AjaxResult updateSave(SysUser sysUser) {
        return toAjax(sysUserService.update(sysUser));
    }

    @GetMapping("list")
    @ResponseBody
    public TableDataInfo list(SysUser sysUser) {
        startPage();
        List<SysUser> sysUsers = sysUserService.selectUserList(sysUser);
        return getDataTable(sysUsers);
    }

    @DeleteMapping()
    @ResponseBody
    public AjaxResult delete(String ids) {
        return toAjax(sysUserService.deleteSysUserByIds(ids));
    }
}