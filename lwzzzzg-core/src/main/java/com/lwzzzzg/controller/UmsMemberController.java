package com.lwzzzzg.controller;


import com.lwzzzzg.result.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fmrx
 * @since 2020-11-05
 */
@RestController
@RequestMapping("/umsMember")
@Api(tags = "UmsMemberController", description = "用户接口")
public class UmsMemberController {

    @ApiOperation("用户列表")
    @ApiImplicitParam(value = "用户id", dataType = "Integer", name = "userId", required = false)
    @PostMapping(value = "/list")
    public ResultVo list() {
        return ResultVo.success();
    }


}
